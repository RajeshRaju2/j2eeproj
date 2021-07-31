package com.mph.model;

public class Employee {

	private String ename;
	private int eid;
	private String dept;
	
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [eNames=" + ename + ", eid=" + eid + ", dept=" + dept + "]";
	}
	
}
