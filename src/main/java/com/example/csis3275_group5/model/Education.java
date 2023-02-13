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
@Table(name = "education")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 70)
	@Column(name = "institution", length = 70)
	private String institution;

	@Size(max = 200)
	@Column(name = "edu_location", length = 200)
	private String location;

	@Size(max = 50)
	@Column(name = "degree", length = 50)
	private String degree;

	@Size(max = 70)
	@Column(name = "field", length = 70)
	private String field;

	@Size(max = 10)
	@Column(name = "edu_start_date", length = 10)
	private String startDate;

	@Size(max = 10)
	@Column(name = "edu_end_date", length = 10)
	private String endDate;

	@Size(max = 400)
	@Column(name = "description", length = 400)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;

	public Education() {

	}

	public Education(@Size(max = 70) String institution, @Size(max = 200) String location,
			@Size(max = 50) String degree, @Size(max = 70) String field, @Size(max = 10) String startDate,
			@Size(max = 10) String endDate, @Size(max = 400) String description) {
		this.institution = institution;
		this.location = location;
		this.degree = degree;
		this.field = field;
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
