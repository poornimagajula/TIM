package com.regnant.tim.admin;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name="Adminlogin", urlPatterns= {"/AdminServlet"}, 
	initParams = {@WebInitParam(name="AdminId", value="Admin101"),@WebInitParam(name="password", value="Admin@123")})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sc=getServletConfig();
		String Adminid_param = sc.getInitParameter("AdminId");
		String password_param=sc.getInitParameter("password");
		
		String Adminid=request.getParameter("adminid");
		String pwd=request.getParameter("adminpwd");
		
		if(Adminid_param.equals(Adminid)&& password_param.equals(pwd)) {
			request.getRequestDispatcher("SignupUser.html").forward(request, response);
		}else {
			request.getRequestDispatcher("AdminLogin.html").forward(request, response);
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
