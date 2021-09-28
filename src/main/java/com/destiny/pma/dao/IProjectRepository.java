package com.destiny.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.destiny.pma.entities.Project;

import java.util.List;

public interface IProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();
}
