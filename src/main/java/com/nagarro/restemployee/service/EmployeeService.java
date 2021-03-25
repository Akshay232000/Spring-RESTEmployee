package com.nagarro.restemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restemployee.entity.Employee;
import com.nagarro.restemployee.repository.EmployeeRepository;



@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> getEmployees() {
		return repository.findAll();
	}

	public Employee getEmployeeById(int id) {

		return repository.findById(id).orElse(null);
	}

	public String deleteEmployee(int id) {

		repository.deleteById(id);
		return "Employee Removed!!";
	}

	public Employee updateEmployee(Employee employee)
	{
		Employee existingEmployee=repository.findById(employee.getEmpCode()).orElse(null);
		existingEmployee.setEmpName(employee.getEmpName());
		existingEmployee.setEmpLoc(employee.getEmpLoc());
		existingEmployee.setEmpMail(employee.getEmpMail());
		existingEmployee.setEmpDOB(employee.getEmpDOB());
		return repository.save(existingEmployee);
	}
	
}