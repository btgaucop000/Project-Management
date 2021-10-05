package com.destiny.pma.controllers;

import com.destiny.pma.dao.IEmployeeRepository;
import com.destiny.pma.dao.IProjectRepository;
import com.destiny.pma.dto.ChartData;
import com.destiny.pma.dto.EmployeeProject;
import com.destiny.pma.entities.Employee;
import com.destiny.pma.entities.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public String displayHome(Model model) throws JsonProcessingException {
        List<Project> projectList = projectRepo.findAll();
        model.addAttribute("projects", projectList);

        List<EmployeeProject> employeeProjects = employeeRepo.getEmployeeProject();
        List<ChartData> chartData = projectRepo.getProjectStatus();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(chartData);

        model.addAttribute("employeeProjects", employeeProjects);
        model.addAttribute("projectStatusCnt", jsonString);
        return "main/home";
    }
}
