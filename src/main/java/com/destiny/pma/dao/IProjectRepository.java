package com.destiny.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.destiny.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {

}
