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
import edu.just.bank.service.AccountService;
import edu.just.bank.service.CustomerService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
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
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = request.getParameter("accountNumber");
		String accountPassword = request.getParameter("accountPassword");
		
		StringBuffer error = validateFormField(accountNumber, accountPassword);
		
		//����֤ͨ��, �����û����Ƿ�ƥ�����֤
		if(error.toString().equals("")) {
			error = validateAccount(accountNumber, accountPassword);
		}
		
		//�����֤��ûͨ��, ����ת����½ҳ��
		if(!error.toString().equals("")) {
			request.setAttribute("error", error);
			request.setAttribute("accountNumber", accountNumber);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		HttpSession httpSession = request.getSession();
		
		Account account = accountService.getAccountWithAccountNumber(accountNumber);

		Customer customer = customerService.getCustmerWithAccountId(account.getAccountid());
		
		request.setAttribute("customer", customer);
		httpSession.setAttribute("account", account);
		request.getRequestDispatcher("/WEB-INF/pages/" + "details.jsp").forward(request, response);
	}
	
	/**
	 * ��֤�˻���������Ƿ�Ϊ��
	 * @param username
	 * @param password
	 * @return
	 */
	public StringBuffer validateFormField(String username, String password) {
		StringBuffer error = new StringBuffer("");
		
		if(username == null || username.trim().equals("")) {
			error.append("�û�������Ϊ��");
		}
		
		if(password == null || password.trim().equals("")) {
			error.append(" ���벻��Ϊ��");
		}
		
		return error;
	}
	
	/**
	 * ��֤�û����������Ƿ�ƥ��
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
			error2.append("�˻������벻ƥ��");
		}
		return error2;
	}

}
