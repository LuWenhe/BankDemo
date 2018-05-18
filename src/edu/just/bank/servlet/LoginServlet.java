package edu.just.bank.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.just.bank.domain.Account;
import edu.just.bank.domain.Customer;
import edu.just.bank.domain.User;
import edu.just.bank.service.AccountService;
import edu.just.bank.service.CustomerService;
import edu.just.bank.service.UserService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private AccountService accountService = new AccountService();
	
	private CustomerService customerService = new CustomerService();
	
	private UserService userService = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		
		try {
			Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(username);
		HttpSession httpSession = request.getSession();
		
		User user = userService.getUserWithUsername(username);
		Customer customer = customerService.getCustmerWithAccountId(user.getUserId());
		boolean flag = true;

		if(customer == null) {
			flag = false;
		}
		
		Account account = accountService.getAccountWithAccountId(user.getAccountId()); 
		
		httpSession.setAttribute("userid", user.getUserId());
		httpSession.setAttribute("account", account);
		
		if(!flag) {
			request.getRequestDispatcher("/WEB-INF/pages/adduserinfo.jsp").forward(request, response);		
			return;
		}
		
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/WEB-INF/pages/information.jsp").forward(request, response);		
	}

	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		userService.addUser(user, 1);
		
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
}
