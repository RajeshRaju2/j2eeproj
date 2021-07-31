package com.mph.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mph.dao.EmployeeDao;
import com.mph.dao.EmployeeDaoimpl;
import com.mph.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */


public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Employee> elist ;
	EmployeeDao dao = new EmployeeDaoimpl();
	RequestDispatcher rd = null;
	Employee emp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>EMS</title>");
		out.println("</head>");
		out.println("<body>");
		
		String action = request.getParameter("action");
		switch (action) {
		case "LIST":{
			listEmployee(request, response);
			break;
		}
		case "EDIT" :{
			editEmployee(request, response);
			break;
		}
		case "UPDATE" :{
			updateEmployee(request, response);
			break;
		}
		case "DELETE": {
			System.out.println("Switch indide delete");
			deleteEmployee(request, response);
		}
		case "SEARCH":{
			searchEmployee(request, response);
		}
		default:
			break;
		}
		
		out.println("</body>");
		out.println("</html>");

		
	}

	private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		emp = new Employee();
		PrintWriter out = response.getWriter();
		int eid= Integer.parseInt(request.getParameter("txteid"));
		System.out.println(eid);
		 emp=dao.getEmployee(eid);
		out.println(emp);
		
			
	}



	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("indide delete");
		int eid= Integer.parseInt(request.getParameter("eid"));
		System.out.println(eid);
		if(dao.delete(eid)) {
			listEmployee(request, response);
		}else {
			System.out.println("Some thing is wrong");
		}
		
	}



	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		emp = new Employee();
		int eid=Integer.parseInt(request.getParameter("txteid"));
		String ename =request.getParameter("txtename");
		String dept =request.getParameter("txtdept");
		emp.setEid(eid);
		emp.setEname(ename);
		emp.setDept(dept);
		boolean ee = dao.update(emp);
		if(ee) {
			listEmployee(request, response);
			}
			else {
				System.out.println("Some thing is wrong");
			}
			
	}



	private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		rd = request.getRequestDispatcher("employee-edit.jsp");
		rd.forward(request, response);
	}



	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		elist = new ArrayList<Employee>();
		 elist = dao.getAllEmployee();
		System.out.println("emplist from controller : " + elist);
		request.setAttribute("allemp", elist);
		rd = request.getRequestDispatcher("employee-list.jsp");
		rd.forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		emp = new Employee();
		int eid=Integer.parseInt(request.getParameter("txteid"));
		String ename =request.getParameter("txtename");
		String dept =request.getParameter("txtdept");
		emp.setEid(eid);
		emp.setEname(ename);
		emp.setDept(dept);
		boolean flag=dao.save(emp);
		if(flag) {
			listEmployee(request, response);
		}
		else {
			System.out.println("Some thing is wrong");
		}
		
		
		
		
		
	}
	


}

























