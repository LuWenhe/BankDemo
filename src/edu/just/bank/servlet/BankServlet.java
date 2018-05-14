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
	
	public void deposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amountStr = request.getParameter("depositNumber");
		String accountNumber = request.getParameter("accountNumber");
		
		float amount = 0;
		String type = "´æÈë";
		
		try {
			amount = Float.parseFloat(amountStr);
		} catch (Exception e) {} 
		
		if(amount > 0) {
			accountService.addDepositDetails(accountNumber, amount, type);
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
		
		request.setAttribute("account", account);
		request.setAttribute("amount", amount);
		request.getRequestDispatcher("/WEB-INF/pages/withdraw.jsp").forward(request, response);
	}
	
	public void transfer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountSide = request.getParameter("accountSide");
		String amount = request.getParameter("amount");
	
		String accountNumber = request.getParameter("accountNumber");
		System.out.println(accountNumber);
		accountService.transferBalance(accountNumber, accountSide, Float.parseFloat(amount));
		
		Account account = accountService.getAccountWithAccountNumber(accountSide);
		Customer customer = customerService.getCustmerWithAccountId(account.getAccountid());
		
		request.setAttribute("cutomer", customer);
		request.setAttribute("amount", amount);
		request.getRequestDispatcher("/WEB-INF/pages/transfer.jsp").forward(request, response);
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
