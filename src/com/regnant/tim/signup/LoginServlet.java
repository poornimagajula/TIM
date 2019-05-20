package com.regnant.tim.signup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String pan = request.getParameter("PanNo");
		String password = request.getParameter("Password");
		
		//Encrypt the password
		String pwd = Base64.getEncoder().encodeToString(password.getBytes());
	
		System.out.println(userid+"************");
		
		UserCRUDOperations uop = new UserCRUDOperations();
		List<UserBean> ulist=new ArrayList<>();
		UserBean u = new UserBean();
		u.setEmail(userid);
		u.setMobile(userid);
		u.setPan(pan);
		u.setPassword(pwd);
		ulist=uop.LoginUser(u);
		
		if(ulist.isEmpty()) {
			request.getRequestDispatcher("/Login.html").forward(request, response);
		}
		else {
			request.getRequestDispatcher("Success.html").forward(request, response);	
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
