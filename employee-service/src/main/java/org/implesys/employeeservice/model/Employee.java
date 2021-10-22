package org.implesys.employeeservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 	//POJO
//@Table(name="Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employee {
	
	@Id
	@Column//(name="emp_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer empId;
	@Column//(name="emp_name")
	String empName;
	@Column//()
	String phone;
	@Column//(name="deptId")
	//@GeneratedValue(strategy=GenerationType.AUTO)
	Integer deptId;
	
	
}
	