package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity

@NoArgsConstructor
@Table(name = "project")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Project implements Serializable
{
	public Project(Long projectId, @NotNull String name, @NotNull Date startDate, @NotNull Date endDate,
			@NotNull String githubLink, @NotNull Long budget, @NotNull boolean isCompleted, Employee managerId) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.githubLink = githubLink;
		this.budget = budget;
		this.isCompleted = isCompleted;
		this.managerId = managerId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long projectId;
	
	@NotNull
	@Column(name = "project_name")
	private String name;
	
	
	@NotNull
	@Column(name = "start_date")
	private Date startDate;
	
	@NotNull
	@Column(name = "end_date")
	private Date endDate;
	
	@NotNull
	@Column(name="githubLink")
	private String githubLink;
	
	@NotNull
	@Column(name="budget")
	private Long budget;
	
	@NotNull
	@Column(name = "is_completed", columnDefinition = "boolean default 0")
	private boolean isCompleted;
	
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Employee.class)
    @JoinColumn(name="manager_id")
	private Employee managerId;
	
	
	
	
	
	
}
