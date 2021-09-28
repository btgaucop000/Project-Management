package com.destiny.pma.controllers;

import com.destiny.pma.dao.IEmployeeRepository;
import com.destiny.pma.dao.IProjectRepository;
import com.destiny.pma.entities.Employee;
import com.destiny.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IProjectRepository projectRepo;

    @Autowired
    private IEmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projectList = projectRepo.findAll();
        model.addAttribute("projects", projectList);

        List<Employee> employeeList = employeeRepo.findAll();
        model.addAttribute("employees", employeeList);
        return "home";
    }
}
