package org.implesys.department.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@JsonIgnoreProperties(initializer)
@Entity 	//POJO
@Table(name="Department")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Department {
	
	@Id
	//@Column(name="dept_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column()
	String deptName;
	@Column()
	String hodName;
	/*
	 * public int getId() { return id; } public void setId(int id) { this.id = id; }
	 * public String getDeptName() { return deptName; } public void
	 * setDeptName(String deptName) { this.deptName = deptName; } public String
	 * getHodName() { return hodName; } public void setHodName(String hodName) {
	 * this.hodName = hodName; }
	 */
	
	}