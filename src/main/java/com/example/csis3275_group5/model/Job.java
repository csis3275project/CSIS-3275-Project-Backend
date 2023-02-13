package com.example.csis3275_group5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 70)
	@Column(name = "title", length = 70)
	private String title;

	@Size(max = 70)
	@Column(name = "employer", length = 70)
	private String employer;

	@Size(max = 200)
	@Column(name = "job_location", length = 200)
	private String location;

	@Size(max = 10)
	@Column(name = "job_start_date", length = 10)
	private String startDate;

	@Size(max = 10)
	@Column(name = "job_end_date", length = 10)
	private String endDate;

	@Size(max = 400)
	@Column(name = "description", length = 400)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;

	public Job() {

	}

	public Job(@Size(max = 70) String title, @Size(max = 70) String employer, @Size(max = 200) String location,
			@Size(max = 10) String startDate, @Size(max = 10) String endDate, @Size(max = 400) String description) {
		this.title = title;
		this.employer = employer;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDescr() {
		return description;
	}

	public void setDescr(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
