package com.emp.info.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.info.entites.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	public List<Employee> findAll();
	public Employee findByEmpid(int id);
	public void delete(Employee emp);
}
