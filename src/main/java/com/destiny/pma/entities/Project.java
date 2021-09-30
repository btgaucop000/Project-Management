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

	@OneToMany(mappedBy = "project")
	private List<Employee> employees;

	
}
