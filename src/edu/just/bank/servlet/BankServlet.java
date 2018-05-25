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

import edu.just.bank.domain.ALoan;
import edu.just.bank.domain.Account;
import edu.just.bank.domain.Customer;
import edu.just.bank.domain.Detail;
import edu.just.bank.domain.Loan;
import edu.just.bank.domain.User;
import edu.just.bank.service.AccountService;
import edu.just.bank.service.CustomerService;
import edu.just.bank.service.DetailService;
import edu.just.bank.service.LoanService;
import edu.just.bank.service.UserService;

@WebServlet("/bankServlet")
public class BankServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private AccountService accountService = new AccountService();
	
	private CustomerService customerService = new CustomerService();
	
	private UserService userService = new UserService();
	
	private DetailService detailService = new DetailService();
	
	private LoanService loanService = new LoanService();
	
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
		String userIdStr = request.getParameter("userId");

		float amount = 0;
		int userId = -1;
		String type = "存款";
		
		try {
			amount = Float.parseFloat(amountStr);
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {} 
		
		User user = userService.getUserWithUserId(userId);
		
		if(amount > 0) {
			accountService.depositAmount(user.getAccountId(), amount);
			detailService.addAccountDetails(userId, amount, type);
		}
		
		request.getRequestDispatcher("/WEB-INF/pages/deposit.jsp").forward(request, response);
	} 

	public void withdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String amountStr = request.getParameter("withdrawNumber");
		String userIdStr = request.getParameter("userId");
		
		float amount = 0;
		int userId = -1;
		String type = "取款";

		try {
			amount = Float.parseFloat(amountStr);
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {}
		
		User user = userService.getUserWithUserId(userId);
		
		if(amount > 0) {
			System.out.println("hello");
			accountService.withAmount(user.getAccountId(), amount);
			detailService.addAccountDetails(userId, amount, type);
		}
		
		request.getRequestDispatcher("/WEB-INF/pages/withdraw.jsp").forward(request, response);
	}

	public void testBalance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String userIdStr = request.getParameter("userId");
		String accountStr = request.getParameter("account");
		
		float leftBalance = 0;
		float minBalance = 0;
		int userId = -1;
		float account = -1;
		
		try {
			userId = Integer.parseInt(userIdStr);
			account = Float.parseFloat(accountStr);
		} catch (Exception e) {}
		
		if(userId > 0 && account >= 0) {
			User user = userService.getUserWithUserId(userId);
			Account account2 = accountService.getAccountWithAccountId(user.getAccountId());
			leftBalance = account2.getBalance() - account;
			minBalance = account2.getMinbalance();
		}
		
		Map<Object, Object> result = new HashMap<>();

		if(leftBalance < minBalance) {		//余额不足
			result.put("err1", 0);			
		} else {
			result.put("err1", 2);
		}

		if(account > 10000) {				//单次操作金额大于10000
			result.put("err2", 1);			
		} else {
			result.put("err2", 3);
		}
		
		result.put("account", account);
		
		ObjectMapper mapper = new ObjectMapper();
		String result1 = mapper.writeValueAsString(result);
		response.getWriter().println(result1);
	}
	
	public void addUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String identityNumber = request.getParameter("identityNumber");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		long userId = 0;
		
		if(username != null && password != null) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			userId = userService.addUser(user, 1);
		}
		
		Customer customer = new Customer(name, Integer.parseInt(age), identityNumber, telephone, address, (int)userId);
		customerService.addCustomer(customer, (int)userId);
		
		response.sendRedirect("login.jsp");
	}

	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		
		Customer customer = customerService.getCustmerWithUserId(user.getUserId());
		List<Detail> details = detailService.getDetailList(customer.getCustomerId());
		System.out.println(details);
		
		if(details == null) {
			response.sendRedirect(request.getContextPath() + "/error-1.jsp");
		}
		
		request.setAttribute("depositDetail", details);
		request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(request, response);
	}

	public void loanlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Loan> loan = loanService.getListLoan();
		
		request.setAttribute("loan", loan);
		request.getRequestDispatcher("/WEB-INF/pages/choiceloan.jsp").forward(request, response);
	}
	
	public void loanDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String aLoanId = request.getParameter("aLoanId");
		ALoan aLoan = loanService.getALoanWithALoanId(Integer.parseInt(aLoanId));
		Loan loan = loanService.getLoanWithLoanId(aLoan.getLoanId());
		
		request.setAttribute("aLoan", aLoan);
		request.setAttribute("loan", loan);
		request.getRequestDispatcher("/WEB-INF/pages/loandetail.jsp").forward(request, response);
	}

	public void regloan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String userIdStr = request.getParameter("userId");
		String loanIdStr = request.getParameter("loanId");
		
		int userId = -1;
		int loanId = -1;
		
		try {
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {}
		
		try {
			loanId = Integer.parseInt(loanIdStr);
		} catch (Exception e) {}
		
		Customer customer = customerService.getCustmerWithUserId(userId);
		Loan loan = loanService.getLoanWithLoanId(loanId);
		
		request.setAttribute("customer", customer);
		request.setAttribute("loan", loan);
		
		request.getRequestDispatcher("/WEB-INF/pages/regloan.jsp").forward(request, response);
	}
	
	public void handleLoan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String loanIdStr = request.getParameter("loanId");
		String customerIdStr = request.getParameter("customerId");
		
		int loanId = -1;
		int customerId = -1;
		
		try {
			loanId = Integer.parseInt(loanIdStr);
		} catch (Exception e) {}
		
		try {
			customerId = Integer.parseInt(customerIdStr);
		} catch (Exception e) {}
		
		String income = request.getParameter("income");
		String loanAmount = request.getParameter("loanamount");
		String yearNum = request.getParameter("yearnum");
		
		Loan loan = loanService.getLoanWithLoanId(loanId);
		
		ALoan aLoan = new ALoan();
		aLoan.setLoanAmount(Float.parseFloat(loanAmount));
		aLoan.setIncome(Float.parseFloat(income));
		aLoan.setYearNum(Integer.parseInt(yearNum));
		aLoan.setLoanId(loan.getLoanId());
		 
		loanService.addLoanDetail(loan, aLoan);
		customerService.updateCustomer(customerId, aLoan);
		
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("user");
		
		Customer customer = customerService.getCustmerWithUserId(user.getUserId());
		Account account = accountService.getAccountWithAccountId(user.getAccountId());
		
		request.setAttribute("customer", customer);
		request.setAttribute("account", account);
		request.getRequestDispatcher("/WEB-INF/pages/information.jsp").forward(request, response);
	}

}
