package com.regnant.tim.signup;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetPwdServlet
 */
@WebServlet("/SetPwdServlet")
public class SetPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetPwdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String otp = request.getParameter("otp");
		String password = request.getParameter("password");
		String cnfrm = request.getParameter("cnfrm");
		
		ServletContext sc=getServletContext();
		String mailotp=(String) sc.getAttribute("otp");
		String mail=(String)sc.getAttribute("email");

		UserBean u = new UserBean();
		u.setEmail(mail);
		String pwd = Base64.getEncoder().encodeToString(password.getBytes());
		u.setPassword(pwd);
		if (mailotp.equals(otp)) {
			if (password.equals(cnfrm)) {
				
				UserCRUDOperations uop = new UserCRUDOperations();
				int row_count = uop.updatePwd(u);
				System.out.println(row_count + " rows inserted");
				request.getRequestDispatcher("Login.html").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("wrongotp.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
