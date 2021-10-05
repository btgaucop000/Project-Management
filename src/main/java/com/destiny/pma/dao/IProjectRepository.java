package com.destiny.pma.dao;

import com.destiny.pma.dto.ChartData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.destiny.pma.entities.Project;

import java.util.List;

public interface IProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage AS label, COUNT(*) AS value " +
            "FROM project " +
            "GROUP BY stage")
    List<ChartData> getProjectStatus();

}
