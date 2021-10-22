package org.implesys.employeeservice.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@JsonIgnoreProperties(initializer)
//@Table(name="Department")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Department {
	int deptId;
	String deptName;
	String hodName;
}
	
	