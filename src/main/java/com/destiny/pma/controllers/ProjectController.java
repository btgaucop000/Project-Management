package com.destiny.pma.controllers;

import com.destiny.pma.dao.IEmployeeRepository;
import com.destiny.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.destiny.pma.dao.IProjectRepository;
import com.destiny.pma.entities.Project;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private IProjectRepository projectRepo;

	@Autowired
	private IEmployeeRepository employeeRepo;

	@GetMapping
	public String displayProjectList(Model model) {
		List<Project> projectList = projectRepo.findAll();
		model.addAttribute("projects", projectList);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		List<Employee> employeeList = employeeRepo.findAll();
		model.addAttribute("project", new Project());
		model.addAttribute("allEmployees", employeeList);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		Project projectSaved = projectRepo.save(project);

		Iterable<Employee> selectEmployees = employeeRepo.findAllById(employees);
		for(Employee emp : selectEmployees) {
			emp.setProject(projectSaved);
			employeeRepo.save(emp);
		}
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
		
	}
}
