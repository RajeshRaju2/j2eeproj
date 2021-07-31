package com.mph.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mph.dao.EmployeeDao;
import com.mph.dao.EmployeeDaoimpl;
import com.mph.model.Details;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao dao = new EmployeeDaoimpl();
	RequestDispatcher rd = null;
	Details dt;
    public Login() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>EMS</title>");
		out.println("</head>");
		out.println("<body>");
		
		String action = request.getParameter("action");
		switch (action) {
		case "VALIDATE":{
			validateEmployee(request, response);
			break;
		}
		case "NEWUSER" : {
			newuserEmpoyee(request, response);
		}
		
		}
		out.println("</body>");
		out.println("</html>");

	
	}
	private void validateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("inside validate");
		dt = new Details();
		PrintWriter out = response.getWriter();
		int eid= Integer.parseInt(request.getParameter("txteid"));
		String pass = request.getParameter("txtpass");
		dt.setEid(eid);
		dt.setPass(pass);
		System.out.println(dt.getEid()+"--"+dt.getPass());
		if(dao.validate(dt)) {
			out.println("Welcome");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		else {
			out.println("Not A valid user");
		}
		
	}


	private void newuserEmpoyee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		// TODO Auto-generated method stub
		dt = new Details();
		PrintWriter out = response.getWriter();
		int eid = Integer.parseInt(request.getParameter("EmployeeID"));
		String ename= request.getParameter("fullname");
		String pwd = request.getParameter("password");
		long phone = Long.parseLong(request.getParameter("contact"));
		dt.setEid(eid);
		dt.setEname(ename);
		dt.setPass(pwd);
		dt.setPhone_no(phone);
		if(dao.newUser(dt)) {
			out.println("User Added");
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("Something is wrong");
		}
		
		
	}


	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
