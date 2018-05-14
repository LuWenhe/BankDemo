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
import edu.just.bank.service.AccountService;
import edu.just.bank.service.CustomerService;

@WebServlet("/bankServlet")
public class BankServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private AccountService accountService = new AccountService();
	
	private CustomerService customerService = new CustomerService();
	
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
		
		String accountNumber = request.getParameter("accountNumber");
		request.setAttribute("accountNumber", accountNumber);
		
		request.getRequestDispatcher("/WEB-INF/pages/" + pageName + ".jsp").forward(request, response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = request.getParameter("accountNumber");
		String accountPassword = request.getParameter("accountPassword");
		
		StringBuffer error = validateFormField(accountNumber, accountPassword);
		
		//表单验证通过, 进行用户名是否匹配的验证
		if(error.toString().equals("")) {
			error = validateAccount(accountNumber, accountPassword);
		}
		
		//如果验证都没通过, 则跳转到登陆页面
		if(!error.toString().equals("")) {
			request.setAttribute("error", error);
			request.setAttribute("accountNumber", accountNumber);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		HttpSession httpSession = request.getSession();
		
		Account account = accountService.getAccountWithAccountNumber(accountNumber);

		Customer customer = customerService.getCustmerWithAccountId(account.getAccountid());
		customer.setBalance(account.getBalance());
		
		request.setAttribute("customer", customer);
		httpSession.setAttribute("account", account);
		request.getRequestDispatcher("/WEB-INF/pages/" + "details.jsp").forward(request, response);
	}

	/**
	 * 验证账户的密码的是否为空
	 * @param username
	 * @param password
	 * @return
	 */
	public StringBuffer validateFormField(String username, String password) {
		StringBuffer error = new StringBuffer("");
		
		if(username == null || username.trim().equals("")) {
			error.append("用户名不能为空");
		}
		
		if(password == null || password.trim().equals("")) {
			error.append(" 密码不能为空");
		}
		
		return error;
	}
	
	/**
	 * 验证用户名和密码是否匹配
	 * @param username
	 * @param password
	 * @return
	 */
	public StringBuffer validateAccount(String accountNumber, String accountPasssword) {
		Boolean flag = false;
		Account account = accountService.getAccountWithAccountNumber(accountNumber);
		
		if(account != null) {
			if(accountPasssword.trim().equals(account.getAccountPassword())) {
				flag = true;
			}
		}
		
		StringBuffer error2 = new StringBuffer("");
		
		if(!flag) {
			error2.append("账户的密码不匹配");
		}
		return error2;
	}
	
	public void deposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amountStr = request.getParameter("depositNumber");
		String accountNumber = request.getParameter("accountNumber");
		
		float amount = 0;
		
		try {
			amount = Float.parseFloat(amountStr);
		} catch (Exception e) {} 
		
		if(amount > 0) {
			accountService.depositBalance(accountNumber, amount);
		}
		
		Account account = accountService.getAccountWithAccountNumber(accountNumber);
		int balance = account.getBalance();
		
		request.setAttribute("balance", balance);
		request.setAttribute("amount", amount);
		request.getRequestDispatcher("/WEB-INF/pages/deposit.jsp").forward(request, response);
	} 

	public void withdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amountStr = request.getParameter("withdrawNumber");
		String accountNumber = request.getParameter("accountNumber");
		
		float amount = 0;
		
		try {
			amount = Float.parseFloat(amountStr);
		} catch (Exception e) {}
		
		System.out.println("heelo");
		
		if(amount > 0) {
			accountService.withdrawBalance(accountNumber, amount);
		}
		
		Account account = accountService.getAccountWithAccountNumber(accountNumber);
		int balance = account.getBalance();
		
		request.setAttribute("balance", balance);
		request.setAttribute("amount", amount);
		request.getRequestDispatcher("/WEB-INF/pages/withdraw.jsp").forward(request, response);
	}
	
	public void transfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountSide = request.getParameter("accountSide");
		
		
	}

	public void validateAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String accountSideStr = request.getParameter("accountSide");
		long count = accountService.getCountWithAccountNumber(accountSideStr);
		
		Map<String, Object> result = new HashMap<>();
		System.out.println(count);
		if(count > 0) {
			result.put("result", 1);
		} else {
			result.put("result", 0);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String result1 = mapper.writeValueAsString(result);
		
		response.setContentType("text/html");
		response.getWriter().println(result1);
	}

}
