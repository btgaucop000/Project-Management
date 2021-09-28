package com.destiny.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.destiny.pma.entities.Employee;

import java.util.List;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();
}
