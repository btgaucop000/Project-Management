package com.destiny.pma.dao;

import com.destiny.pma.dto.EmployeeProject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.destiny.pma.entities.Employee;

import java.util.List;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT e.first_name AS firstName, e.last_name AS lastName, COUNT(pe.employee_id) AS totalProject " +
            "FROM employee e LEFT JOIN project_employee pe " +
            "ON pe.employee_id = e.id " +
            "GROUP BY e.first_name, e.last_name ORDER BY 3 DESC ")
    public List<EmployeeProject> getEmployeeProject();
}
