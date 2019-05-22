package com.regnant.tim.signup;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/CustomerOverview")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long start=System.currentTimeMillis();
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String city = request.getParameter("city");
		String state = request.getParameter("State");
		String mail = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String pincode = request.getParameter("pincode");
		String pan = request.getParameter("PanNo");
		String password = request.getParameter("Password");
		String pass = request.getParameter("cnfrm");

		UserBean u = new UserBean();
		u.setFirstName(fname);
		u.setLastName(lname);
		u.setCity(city);
		u.setState(state);
		u.setEmail(mail);
		u.setMobile(mobile);
		u.setPincode(pincode);
		u.setPan(pan);
		// Encryption of the password

		String pwd = Base64.getEncoder().encodeToString(password.getBytes());
		u.setPassword(pwd);
		Validator v = new Validator();
		boolean chk = v.checkSignUp(mail, mobile, pan);
		if (chk) {
			System.out.println("^^^^^^^^" + u.mobile);
			if (password.equals(pass)) {
				System.out.println(pass + "&&&&&&&&&&&&");
				UserCRUDOperations uop = new UserCRUDOperations();
				int rows_insert = uop.AddUser(u);
				System.out.println(rows_insert + " Rows inserted");
				if (rows_insert == 1) {
					SendMail sm = new SendMail(fname, mail);
					sm.run();
					System.out.println(fname + "%%%%%%%%");
					long end=System.currentTimeMillis();
					
					System.out.println("Time Taken:"+(end-start));
					request.getRequestDispatcher("Login.html").forward(request, response);
				}
			}else {
				request.getRequestDispatcher("SignupUser.html").forward(request, response);
			}

		} else {
			request.getRequestDispatcher("alreadyuser.html").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
