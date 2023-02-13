package com.example.csis3275_group5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "misc_info")
public class MiscInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 300)
	@Column(name = "soft_skill", length = 300)
	private String softSkill;
	
	@Size(max = 300)
	@Column(name = "hard_skill", length = 300)
	private String hardSkill;
	
	@Size(max = 100)
	@Column(name = "lang", length = 100)
	private String language;
	
	@Size(max = 300)
	@Column(name = "certification", length = 300)
	private String certification;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;

	public MiscInfo() {
		
	}

	public MiscInfo(String softSkill, String hardSkill, String language, String certification) {
		this.softSkill = softSkill;
		this.hardSkill = hardSkill;
		this.language = language;
		this.certification = certification;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSoftSkill() {
		return softSkill;
	}

	public void setSoftSkill(String softSkill) {
		this.softSkill = softSkill;
	}

	public String getHardSkill() {
		return hardSkill;
	}

	public void setHardSkill(String hardSkill) {
		this.hardSkill = hardSkill;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
