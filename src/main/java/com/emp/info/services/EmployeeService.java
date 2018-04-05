package com.emp.info.services;

import java.util.List;


import com.emp.info.entites.Employee;

public interface EmployeeService {
	List<Employee> getEmployees() throws Exception;
	boolean setEmployee(Employee emp) throws Exception;
	Employee getEmployee(int id) throws Exception;
	void delete(Employee emp) throws Exception;
}
