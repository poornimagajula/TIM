package com.regnant.signup;

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
		
		UserCRUDOperations uop = new UserCRUDOperations();
		List<UserBean> ulist=new ArrayList<>();
		ulist=uop.LoginUser();
		for(UserBean u:ulist) {		
			if((userid.equals(u.getEmail())||userid.equals(u.getMobile()))&&pan.equals(u.getPan())&&pwd.equals(u.getPassword())) {
				request.getRequestDispatcher("Success.html").forward(request, response);
			}		
		}	
		request.getRequestDispatcher("Login.html").forward(request, response);
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
