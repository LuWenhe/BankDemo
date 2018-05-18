package edu.just.bank.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.just.bank.domain.Account;
import edu.just.bank.domain.Customer;
import edu.just.bank.domain.Detail;
import edu.just.bank.domain.User;
import edu.just.bank.service.AccountService;
import edu.just.bank.service.CustomerService;
import edu.just.bank.service.DetailService;
import edu.just.bank.service.UserService;

@WebServlet("/bankServlet")
public class BankServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private AccountService accountService = new AccountService();
	
	private CustomerService customerService = new CustomerService();
	
	private UserService userService = new UserService();
	
	private DetailService detailService = new DetailService();
	
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

	public void forwardPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageName = request.getParameter("page");
		
		request.getRequestDispatcher("/WEB-INF/pages/" + pageName + ".jsp").forward(request, response);
	}
	
	public void deposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amountStr = request.getParameter("depositNumber");
		String accountIdStr = request.getParameter("accountId");

		float amount = 0;
		int accountId = -1;
		
		try {
			amount = Float.parseFloat(amountStr);
			accountId = Integer.parseInt(accountIdStr);
		} catch (Exception e) {} 
		
		String type = "´æ¿î";
		Account account = accountService.getAccountWithAccountId(accountId);
		
		if(amount > 0 && accountId > 0) {
			accountService.depositAmount(accountId, amount);
			accountService.addAccountDetails(accountId, amount, type);
		}
		
		float balance = account.getBalance();
		
		request.setAttribute("balance", balance);
		request.setAttribute("amount", amount);
		request.getRequestDispatcher("/WEB-INF/pages/deposit.jsp").forward(request, response);
	} 

	public void withdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amountStr = request.getParameter("withdrawNumber");
		String accountIdStr = request.getParameter("accountId");
		
		float amount = 0;
		int accountId = -1;

		try {
			amount = Float.parseFloat(amountStr);
			accountId = Integer.parseInt(accountIdStr);
		} catch (Exception e) {}
		
		String type = "È¡¿î";
		Account account = accountService.getAccountWithAccountId(accountId);
		
		if(amount > 0) {
			accountService.withAmount(accountId, amount);
			accountService.addAccountDetails(accountId, amount, type);
		}
		
		request.setAttribute("account", account);
		request.setAttribute("amount", amount);
		request.getRequestDispatcher("/WEB-INF/pages/withdraw.jsp").forward(request, response);
	}

	public void addUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String identityNumber = request.getParameter("identityNumber");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userid");
		
		Customer customer = new Customer(name, Integer.parseInt(age), identityNumber, telephone, address, userId);
		customerService.addCustomer(customer, userId);
		
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/WEB-INF/pages/information.jsp").forward(request, response);
		
	}
	
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = (int)request.getSession().getAttribute("userid");
		User user = userService.getUserWithUserId(userId);
		
		Customer customer = customerService.getCustmerWithAccountId(user.getUserId());
		List<Detail> details = detailService.getDetailList(customer.getCustomerId());
		System.out.println(customer);
		
		if(details == null) {
			response.sendRedirect(request.getContextPath() + "/error-1.jsp");
		}
		
		request.setAttribute("depositDetail", details);
		request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(request, response);
	}
}
