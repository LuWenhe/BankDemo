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
		
		try {
			amount = Float.parseFloat(amountStr);
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {} 
		
		User user = userService.getUserWithUserId(userId);
		int accountId = user.getAccountId();
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
		String userIdStr = request.getParameter("userId");
		
		float amount = 0;
		int userId = -1;

		try {
			amount = Float.parseFloat(amountStr);
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {}
		
		User user = userService.getUserWithUserId(userId);
		int accountId = user.getAccountId();
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
		User user = (User)session.getAttribute("user");
		
		Customer customer = new Customer(name, Integer.parseInt(age), identityNumber, telephone, address, user.getUserId());
		customerService.addCustomer(customer, user.getUserId());
		
		request.setAttribute("customer", customer);
		request.getRequestDispatcher("/WEB-INF/pages/information.jsp").forward(request, response);
		
	}
	
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		System.out.println(user);
		
		Customer customer = customerService.getCustmerWithAccountId(user.getUserId());
		List<Detail> details = detailService.getDetailList(customer.getCustomerId());
		System.out.println(customer);
		
		if(details == null) {
			response.sendRedirect(request.getContextPath() + "/error-1.jsp");
		}
		
		request.setAttribute("depositDetail", details);
		request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(request, response);
	}

	public void loan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Loan> loans = loanService.getListLoan();
		
		request.setAttribute("loan", loans);
		request.getRequestDispatcher("/WEB-INF/pages/choiceloan.jsp").forward(request, response);
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
		
		Customer customer = customerService.getCustmerWithAccountId(userId);
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
		ALoan aLoan = new ALoan(Float.parseFloat(loanAmount), Float.parseFloat(income), Integer.parseInt(yearNum));
		
		Loan loan = loanService.getLoanWithLoanId(loanId);
		loan.setaLoan(aLoan);
		
		
	}
}
