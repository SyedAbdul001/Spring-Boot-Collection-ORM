package com.tahauddin.syed.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "emp_name", length = 25)
	private String empName;
	
	@Column(name = "emp_salary")
	private Double empSal;
	
	@ElementCollection
	@CollectionTable(name = "emp_task_table" , joinColumns = @JoinColumn(name="emp_id"))
	@Column(name = "emp_task")
	@OrderColumn(name = "pos")
	private List<String> empTask;
	
	@ElementCollection
	@CollectionTable(name = "emp_projs_table", joinColumns = @JoinColumn(name="emp_id"))
	@Column(name = "emp_projs", length = 25)
	private Set<String> empProjs;
	
	@ElementCollection
	@CollectionTable(name = "emp_mod_table" , joinColumns = @JoinColumn(name="emp_id"))
	@Column(name = "emp_mod", length = 25)
	@MapKeyColumn(name="pos")
	private Map<Integer,String> empMod;

}
