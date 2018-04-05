package com.emp.info.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.emp.info.services.EmployeeService;
import com.emp.info.entites.Employee;
import com.emp.info.entites.Response;

@RestController
@RequestMapping("/info/employeeService")
@CrossOrigin(origins = "http://localhost:1841")
public class EmployeeController {
	final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value = "/emps/", method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response> getEmployees(){
		List<Employee> empList = null;
		Response response = new Response();
		try {
			empList = empService.getEmployees();
			if(empList != null){
				response.setStatus(true); response.setMessage("Employee List loaded");
				response.setData(empList);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			} else {
				response.setStatus(false); response.setMessage("Employee List not loaded");
				response.setData(empList);
				return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response.setStatus(false); response.setMessage("Employee List not loaded");
			response.setData(empList);
			return new ResponseEntity<Response>(response,HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	/*@RequestMapping(value = "/emps/", method = RequestMethod.GET, produces =MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response> getEmployee(@RequestParam("empID") int empID,@RequestParam("_dc") long _dc){
		log.info("EMP ID: "+empID);
		Employee emp = new Employee();
		Response response = new Response();
		try {
			emp = empService.getEmployee(empID);
			if(emp != null){
				response.setStatus(true); response.setMessage("Employee Record loaded");
				response.setData(emp);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			} else {
				response.setStatus(false); response.setMessage("Employee Record not loaded");
				response.setData(emp);
				return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response.setStatus(false); response.setMessage("Employee Record not loaded");
			response.setData(emp);
			return new ResponseEntity<Response>(response,HttpStatus.NOT_IMPLEMENTED);
		}
	}*/
	
	@RequestMapping(value = "/emps", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response> addEmployee(@RequestBody Employee emps){
		Response response = new Response();
		try {
				if(empService.setEmployee(emps)) {
				response.setStatus(true); response.setMessage("Employee add successfully");
				response.setData(emps);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			}else {
				response.setStatus(false); response.setMessage("Employee add failed");
				response.setData(emps);
				return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			response.setStatus(false); response.setMessage("Employee add failed");
			response.setData(emps);
			return new ResponseEntity<Response>(response,HttpStatus.NOT_IMPLEMENTED);
		}
		
	}
	
	@RequestMapping(value = "/emps/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response> deleteEmployee(@PathVariable int id, @RequestBody Employee emps){
		Response response = new Response();
		try {
				empService.delete(emps);
				response.setStatus(true); response.setMessage("Employee delete successfully");
				return new ResponseEntity<Response>(response,HttpStatus.OK);
				
		}catch (Exception e) {
			response.setStatus(false); response.setMessage(e.getMessage());
			return new ResponseEntity<Response>(response,HttpStatus.NOT_IMPLEMENTED);
		}
		
	}
	
	@RequestMapping(value = "/emps/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Response> updateEmployee(@PathVariable int id, @RequestBody Employee emps){
		Response response = new Response();
		try {
				if(empService.setEmployee(emps)) {
				response.setStatus(true); response.setMessage("Employee update successfully");
				response.setData(emps);
				return new ResponseEntity<Response>(response,HttpStatus.OK);
			}else {
				response.setStatus(false); response.setMessage("Employee add failed");
				response.setData(emps);
				return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			response.setStatus(false); response.setMessage("Employee add failed");
			response.setData(emps);
			return new ResponseEntity<Response>(response,HttpStatus.NOT_IMPLEMENTED);
		}
		
	}

}
