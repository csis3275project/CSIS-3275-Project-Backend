package com.example.csis3275_group5.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users",
			uniqueConstraints = {@UniqueConstraint(columnNames = "username")}
		)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	@Column(name = "username", length = 100)
	@Email
	private String username;

	@NotBlank
	@Size(max = 150)
	@Column(name = "user_password", length = 150)
	@JsonIgnore
	private String password;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
				fetch = FetchType.LAZY, optional = true)
	private PersonalInfo personalInfo;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	private Set<Job> jobs = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	private Set<Education> education = new HashSet<>();
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
				fetch = FetchType.LAZY, optional = true)
	private MiscInfo miscInfo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	public Set<Education> getEducation() {
		return education;
	}

	public void setEducation(Set<Education> education) {
		this.education = education;
	}

	public MiscInfo getMiscInfo() {
		return miscInfo;
	}

	public void setMiscInfo(MiscInfo miscInfo) {
		this.miscInfo = miscInfo;
	}
	
	public void addJob(Job job) {
		this.jobs.add(job);
		job.setUser(this);
	}
	
	public void addEducation(Education education) {
		this.education.add(education);
		education.setUser(this);
	}

}
