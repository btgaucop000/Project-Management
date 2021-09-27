package com.destiny.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.destiny.pma.dao.IProjectRepository;
import com.destiny.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private IProjectRepository projectRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		model.addAttribute("project", new Project());
		return "new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		projectRepo.save(project);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects/new";
		
	}
}
