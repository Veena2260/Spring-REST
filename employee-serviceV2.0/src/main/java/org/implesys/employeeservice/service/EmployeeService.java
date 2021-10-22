package org.implesys.employeeservice.service;

import java.util.Optional;

import org.implesys.employeeservice.vo.Department;
import org.implesys.employeeservice.controller.EmployeeController;
import org.implesys.employeeservice.model.Employee;
import org.implesys.employeeservice.repository.EmployeeRepository;
import org.implesys.employeeservice.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmployeeService {
	
	@Value("${deptservice_endpoint}")
	String deptServiceEndpoint;
	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;
	
	@Autowired
	EmployeeRepository empRepo;
	
	

	public Employee saveEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	public Optional<Employee> findEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id);
		//return empRepo.getById(id);
	}
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return empRepo.getById(id);
		//return empRepo.getById(id);
	}
	public ResponseVO findEmployeeWithDeptById(Integer id) {
		// TODO Auto-generated method stub
		ResponseVO responseVO=new ResponseVO();
		Employee emp=empRepo.findById(id).get();
		//need to call a different microservice to get department
		//return empRepo.findById(id);
		//return empRepo.getById(id);
	   ResponseEntity<Department> deptResponse=restTemplate.getForEntity(deptServiceEndpoint+emp.getDeptId(), Department.class);
	    log.info("deptResponse"+deptResponse);
	   
	   responseVO.setEmployee(emp);
	    responseVO.setDepartment(deptResponse.getBody());
		return responseVO;
	}

}
