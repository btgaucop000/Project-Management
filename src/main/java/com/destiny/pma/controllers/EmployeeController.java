package com.destiny.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.destiny.pma.dao.IEmployeeRepository;
import com.destiny.pma.entities.Employee;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeRepository employeeRepo;

	@GetMapping
	public String displayEmployeeList(Model model) {
		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute("employees", employeeList);
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		employeeRepo.save(employee);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/employees";
		
	}

}
