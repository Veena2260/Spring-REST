package org.implesys.employeeservice.controller;


import org.implesys.employeeservice.service.EmployeeService;
import org.implesys.employeeservice.vo.ResponseVO;
import org.implesys.employeeservice.service.EmployeeService;

import java.util.Optional;

import org.implesys.employeeservice.model.Employee;
import org.implesys.employeeservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="/",produces="application/json",consumes="application/json",method=RequestMethod.POST)
	//@RequestMapping(value="/",produces="application/json",consumes="application/json", method=RequestMethod.POST)

	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		log.info("Inside saveEmployee");
		System.out.println("In saveEmployee()");
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Connection","Keep-Alive");
		headers.set("Keep-Alive","timeout:20");
		ResponseEntity<Employee> responseEntity=new ResponseEntity<Employee>(emp,headers,HttpStatus.OK);
		empService.saveEmployee(emp);
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") Integer id) {
		log.info("fetching Employee for id: "+ id);
		return empService.findEmployeeById(id);
		
	}
	@GetMapping("employeeWithDept/{id}")
	public ResponseVO getEmployeeWithDept(@PathVariable("id") Integer id) {
		log.info("fetching Employee for id: "+ id);
		return empService.findEmployeeWithDeptById(id);
	}

}
