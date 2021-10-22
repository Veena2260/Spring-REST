package org.implesys.department.repository;

import org.implesys.department.model.Department;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Configuration
@Repository
public interface DepartmentRepository extends JpaRepository< Department,Integer> {
	
	
			
}
