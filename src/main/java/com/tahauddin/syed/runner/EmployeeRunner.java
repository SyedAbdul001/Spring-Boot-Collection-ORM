package com.tahauddin.syed.runner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tahauddin.syed.entity.Employee;
import com.tahauddin.syed.repo.EmployeeRepo;

@Component
public class EmployeeRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public void run(String... args) throws Exception {
		
		Employee employee = new Employee();
		employee.setEmpId(101);
		employee.setEmpName("Syed");
		employee.setEmpSal(30000d);
		
		employee.setEmpTask(Arrays.asList("Java", "Python", "Spring", "Spring Boot"));
		Set<String> coursesNames = new HashSet<String>();
		coursesNames.add("AWS");
		coursesNames.add("Devops");
		coursesNames.add("Azure");
		
		employee.setEmpProjs(coursesNames);
		HashMap<Integer,String> oracleNames = new HashMap<Integer, String>();
		oracleNames.put(1, "SQL");
		oracleNames.put(2, "PLSQL");
		
		employee.setEmpMod(oracleNames);
		
		repo.save(employee);
		
		System.out.println("Employee Saved Successfully...");
		
	}

}
