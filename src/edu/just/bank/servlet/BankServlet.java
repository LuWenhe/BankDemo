package edu.just.bank.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
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
import edu.just.bank.domain.Detail;
import edu.just.bank.service.AccountService;
import edu.just.bank.service.CustomerService;
import edu.just.bank.service.DetailService;

@WebServlet("/bankServlet")
public class BankServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private AccountService accountService = new AccountService();
	
	private CustomerService customerService = new CustomerService();
	
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
		
		String accountNumber = request.getParameter("accountNumber");
		request.setAttribute("accountNumber", accountNumber);
		
		request.getRequestDispatcher("/WEB-INF/pages/" + pageName + ".jsp").forward(request, response);
	}
	
	public void deposit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amountStr = request.getParameter("depositNumber");
		String accountNumber = request.getParameter("accountNumber");
		System.out.println("deposit: " + accountNumber);
		float amount = 0;
		String type = "存入";
		
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
		System.out.println("withdraw: " + accountNumber);
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
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("account");
		
		String accountSideStr = request.getParameter("accountSide");
		String accountMineStr = account.getAccountNumber();
		System.out.println(accountMineStr + " " + accountSideStr);
		long count = accountService.getCountWithAccountNumber(accountSideStr);

		Map<String, Object> result = new HashMap<>();
		
		//如果是自己的账户
		if(accountSideStr.equals(accountMineStr)) {
			result.put("result", 0);
		  //存在对方账户
		} else if(count > 0) {
			result.put("result", 1);
		  //剩下的是不存在的账户
		} else {
			result.put("result", 2);
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String result1 = mapper.writeValueAsString(result);
		
		response.setContentType("text/html");
		response.getWriter().println(result1);
	}

	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = request.getParameter("accountNumber");
		
		Account account = accountService.getAccountWithAccountNumber(accountNumber);
		Customer customer = customerService.getCustmerWithAccountId(account.getAccountid());
		List<Detail> details = detailService.getDetailList(customer.getCustomerId());
		System.out.println(customer);
		
		if(details == null) {
			response.sendRedirect(request.getContextPath() + "/error-1.jsp");
		}
		
		request.setAttribute("depositDetail", details);
		request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(request, response);
	}
}
