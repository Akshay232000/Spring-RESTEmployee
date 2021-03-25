package com.nagarro.restemployee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.restemployee.entity.Employee;
import com.nagarro.restemployee.service.EmployeeService;



@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/addemployee")
	public void addEmployee(@RequestBody Employee employee) {
		service.saveEmployee(employee);
	}

	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return service.getEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}

	@PutMapping("/update")
	public void updateEmployee(@RequestBody Employee employee) {
		service.updateEmployee(employee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteEmployee(id);
	}

}
