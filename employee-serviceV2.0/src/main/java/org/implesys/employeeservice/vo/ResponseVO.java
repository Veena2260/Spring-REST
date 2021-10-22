package org.implesys.employeeservice.vo;

import org.implesys.employeeservice.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVO {
	private Employee employee;
	private Department department;

}
