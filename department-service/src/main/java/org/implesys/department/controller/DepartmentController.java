package org.implesys.department.controller;


import org.implesys.department.service.DepartmentService;

import java.util.Optional;

import org.implesys.department.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@PostMapping(value="/")
	public Department saveDepartment(@RequestBody Department dept) {
		log.info("Inside saveDepartment");
		System.out.println("In saveDepartment()");
		return deptService.saveDepartment(dept);
	}
	
	@GetMapping("/{id}")
	public Optional<Department> getDepartment(@PathVariable("id") Integer id) {
		log.info("fetching Department for id: "+ id);
		System.out.println("In getDepartment()");
		return deptService.findDepartmentById(id);
		
	}

}
