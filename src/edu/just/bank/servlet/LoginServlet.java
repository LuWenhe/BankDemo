package edu.just.bank.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.just.bank.domain.Customer;
import edu.just.bank.domain.User;
import edu.just.bank.service.CustomerService;
import edu.just.bank.service.UserService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
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
		String password = request.getParameter("password");
		HttpSession httpSession = request.getSession();
		
		String error = validateFormField(username, password);
		System.out.println("error: " + error);
	
		//�д���
		if(error != null) {
			request.setAttribute("username", username);
			request.setAttribute("username", username);
			request.setAttribute("error", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
				 
		User user = userService.getUserWithUsername(username);
		System.out.println("user: " + user);
		if(user == null) {
			error = "�������";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		Customer customer = customerService.getCustmerWithAccountId(user.getUserId());
		boolean flag = true;

		if(customer == null) {
			flag = false;
		}
		
		httpSession.setAttribute("user", user);
		
		if(!flag) {
			request.getRequestDispatcher("/WEB-INF/pages/adduserinfo.jsp").forward(request, response);		
			return;
		}
		
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/WEB-INF/pages/information.jsp").forward(request, response);		
	}

	public String validateFormField(String username, String password) {
		boolean flag1 = true;
		boolean flag2 = true;
		
		if(username == null || username.trim().equals("")) {
			flag1 = false;
		}
		
		if(password == null || password.trim().equals("")) {
			flag2 = false;
		}
		
		if(!flag1) {
			return "�������û���";
		}
		
		if(!flag2) {
			return "����������";
		}
		
		return null;
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
