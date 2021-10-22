package org.implesys.department.service;

import java.util.Optional;

import org.implesys.department.model.Department;
import org.implesys.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class DepartmentService {
	
	/*
	 * @Value("${deptservice_endpoint}") String deptServiceEndpoint;
	 */
	/*
	 * @Autowired
	 * 
	 * @LoadBalanced RestTemplate restTemplate;
	 * 
	 * @Autowired
	 * 
	 * @LoadBalanced
	 */
	@Autowired
	DepartmentRepository deptRepo;

	public Department saveDepartment(Department dept) {
		return deptRepo.save(dept);
	}

	public Optional<Department> findDepartmentById(Integer id) {
		// TODO Auto-generated method stub
		return deptRepo.findById(id);
	}

}
