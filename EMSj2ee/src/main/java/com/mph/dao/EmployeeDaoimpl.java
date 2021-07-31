package com.mph.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mph.model.Details;
import com.mph.model.Employee;
import com.mph.util.MyDBConnection;

public class EmployeeDaoimpl implements EmployeeDao {

	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	Employee employee;
	List<Employee> elist;
	Details det;
	@Override
	public List<Employee> getAllEmployee() {
		System.out.println("inside ()");
		elist = new ArrayList<Employee>();

		try {
			con = MyDBConnection.getDBConnection();
			st = con.createStatement();
			rs = st.executeQuery("select * from mphsemp");

			while (rs.next()) {
				System.out.println("inside while");
				employee = new Employee();
				employee.setEid(rs.getInt("eid"));
				employee.setEname(rs.getString("ename"));
				employee.setDept(rs.getString("dept"));
				elist.add(employee);

			}
			System.out.println(elist + "dao");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return elist;

	}

	@Override
	public Employee getEmployee(int eno) {
		// TODO Auto-generated method stub
		employee = new Employee();
		con = MyDBConnection.getDBConnection();
		try {
			System.out.println("inside dao getEmployee");
			st = con.createStatement();
			rs = st.executeQuery("select * from mphsemp where eid = "+eno);
			
			if(rs.next()) { 
			employee.setEid(rs.getInt("eid"));
			employee.setEname(rs.getString("ename"));
			employee.setDept(rs.getString("dept"));
			
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return employee;
	}

	@Override
	public boolean save(Employee emp) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		con = MyDBConnection.getDBConnection();
		try {
			ps=con.prepareStatement("insert into mphsemp values(?,?,?)");
			int eid = emp.getEid();
			String ename=emp.getEname();
			String dept= emp.getDept();
			
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setString(3, dept);
			int no_of_rows = ps.executeUpdate();
			System.out.println("No of Rows Added : "+ no_of_rows);
			flag = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public boolean update(Employee emp) {
		// TODO Auto-generated method stub
		boolean flag = false;
		con = MyDBConnection.getDBConnection();
		try {
			System.out.println(emp + "To be updated ");
			//ps = con.prepareStatement("update mphsemp set ename='"+emp.getEname() +"' ,dept='"+ emp.getDept());
		ps=con.prepareStatement("update mphsemp set  ename='"+emp.getEname()+"', dept='"+emp.getDept()+ "' where eid ="+ emp.getEid());
			
			
			int noofrows = ps.executeUpdate();
			System.out.println("no of rows = "+ noofrows);
			 flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag ;
	}

	@Override
	public boolean delete(int eno) {
		boolean flag = false;
		con = MyDBConnection.getDBConnection();
		try {
			System.out.println("inside dao delete");
			ps=con.prepareStatement("delete from mphsemp where eid =" +eno);
			
			int noofrows = ps.executeUpdate();
			System.out.println("no of rows = "+ noofrows);
			 flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag ;
	}

	@Override
	public boolean validate(Details dt) {
		// TODO Auto-generated method stub
		boolean flag =false;
		con = MyDBConnection.getDBConnection();
		try {
			System.out.println("inside dao validate");
			st=con.createStatement();
			rs=st.executeQuery("select * from valid where eid="+dt.getEid());
			System.out.println(dt.getEid()+"---"+dt.getPass());
			if(rs.next()) {
				det = new Details();
				System.out.println("inside if dao validate");
				det.setEid(rs.getInt("eid")); 
				det.setPass(rs.getString("pass"));
				System.out.println(det.getPass()+"---"+dt.getPass());
				if(det.getPass().equals(dt.getPass()))
				flag = true;
				
			}
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(flag);
		return flag;
	}

	@Override
	public boolean newUser(Details dt) {
		boolean flag = false;
		con = MyDBConnection.getDBConnection();
		try {
			ps=con.prepareStatement("insert into valid values (?,?,?,?)");
			int eid = dt.getEid();
			String ename =dt.getEname();
			String pass = dt.getPass();
			long phone = dt.getPhone_no();
			
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setString(3, pass);
			ps.setLong(4, phone);
			int no_of_rows = ps.executeUpdate();
			System.out.println("No of Rows Added : "+ no_of_rows);
			flag = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

}
