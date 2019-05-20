package com.regnant.signup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgotServlet
 */
@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		UserBean u=new UserBean();
		u.setEmail(email);
		UserCRUDOperations uop=new UserCRUDOperations();
		List<UserBean> ulist=new ArrayList<>();
		ulist=uop.userCheck(u);
		String fname="";
		for(UserBean u1:ulist) {
			fname=u1.getFirstName();
		}
		String OTP=ForgotPasswordOtp.OTP();
		ForgotMail fm = new ForgotMail();
		fm.Mailsend(fname,email, OTP);
		ServletContext sc=getServletContext();
		sc.setAttribute("otp", OTP);
		sc.setAttribute("email",email);
				
		if(ulist.isEmpty()) {
			request.getRequestDispatcher("SignupUser.html").forward(request, response);
		}else {
		request.getRequestDispatcher("setpwd.html").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
