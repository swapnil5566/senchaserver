package com.emp.info.entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "EMPLOYEE")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="EMPID")
	private int empid;
	
	@Column(name="FIRST",length=45)
	private String first;
		
	@Column(name="LAST",length=45)
	private String last;
	
	@Column(name="EMAIL",length=225)
	private String email;

	public int getEmpID() {
		return empid;
	}

	public void setEmpID(int empid) {
		this.empid = empid;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Employee() {
		
	}

	public Employee(int empid, String first, String last, String email) {
		this.empid = empid;
		this.first = first;
		this.last = last;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", first=" + first + ", last=" + last + ", email=" + email + "]";
	}
	
	
	
	
}
