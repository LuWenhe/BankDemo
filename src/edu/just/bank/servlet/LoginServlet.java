package edu.just.bank.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.just.bank.domain.Account;
import edu.just.bank.domain.Customer;
import edu.just.bank.domain.User;
import edu.just.bank.service.AccountService;
import edu.just.bank.service.CustomerService;
import edu.just.bank.service.UserService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private CustomerService customerService = new CustomerService();
	
	private UserService userService = new UserService();
	
	private AccountService accountService = new AccountService();
	
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
		HttpSession httpSession = request.getSession();
		
		User user = userService.getUserWithUsername(username);
		Customer customer = customerService.getCustmerWithUserId(user.getUserId());
		Account account = accountService.getAccountWithAccountId(user.getAccountId());
		
		httpSession.setAttribute("user", user);
		
		request.setAttribute("customer", customer);
		request.setAttribute("account", account);
		request.getRequestDispatcher("/WEB-INF/pages/information.jsp").forward(request, response);
	}

	public void testLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userService.getUserWithUsername(username);
		
		Map<Object, Object> result = new HashMap<>();
		
		if(user == null) {
			result.put("err", 0);
		} else {
			
			if(!password.equals(user.getPassword())) {
				result.put("err", 1);
			} else {
				result.put("err", 2);
			}
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
		String result1 = mapper.writeValueAsString(result);
		response.getWriter().println(result1);
	}

	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/pages/adduserinfo.jsp").forward(request, response);
	}
}
