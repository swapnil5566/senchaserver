package com.emp.info.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.info.entites.Employee;
import com.emp.info.repositories.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Transactional
	@Override
	public List<Employee> getEmployees() throws Exception{
		return empRepo.findAll();
	}
	
	@Transactional
	@Override
	public boolean setEmployee(Employee emp) throws Exception{
		return empRepo.saveAndFlush(emp) != null ? true : false;
	}
	
	@Transactional
	@Override
	public Employee getEmployee(int id) throws Exception{
		return empRepo.findByEmpid(id) ;
	}
	
	@Transactional
	@Override
	public void delete(Employee emp) throws Exception{
		  empRepo.delete(emp); 
	}

}
