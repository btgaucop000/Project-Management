package com.destiny.pma.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String stage; //NOTSTARTED, COMPLETED, INPROGRESS
	
	private String description;

	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
			fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",
				joinColumns = @JoinColumn(name = "project_id"),
				inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Employee> employees;

	
}
