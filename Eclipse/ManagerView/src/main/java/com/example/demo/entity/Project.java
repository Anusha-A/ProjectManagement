package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "project")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Project implements Serializable
{
	
	private static final long serialVersionUID = 5246598565057913432L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long projectId;
	
	@NotNull
	@Column(name = "project_name")
	private String name;
	
	@NotNull
	@Column(name = "budget")
	private Long budget;
	
	@NotNull
	@Column(name = "githubLink")
	private String githubLink;
	
		
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY,optional=false,targetEntity = Employee.class)
    @JoinColumn(name="manager_id")
	private Employee managerId;	
	
	@NotNull
	@Column(name = "start_date")
	private Date startDate;
	
	@NotNull
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "is_completed", columnDefinition = "boolean default 0")
	private boolean isCompleted;
	

	
}
