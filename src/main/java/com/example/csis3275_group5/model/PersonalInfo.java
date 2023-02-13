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
@Table(name = "personal_info")
public class PersonalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 30)
	@Column(name = "first_name", length = 30)
	private String firstName;
	
	@Size(max = 30)
	@Column(name = "last_name", length = 30)
	private String lastName;
	
	@Size(max = 20)
	@Column(name = "phone", length = 20)
	private String phone;
	
	@Size(max = 100)
	@Column(name = "email", length = 100)
	private String email;
	
	@Size(max = 90)
	@Column(name = "city", length = 90)
	private String city;
	
	@Size(max = 50)
	@Column(name = "province", length = 50)
	private String province;
	
	@Size(max = 60)
	@Column(name = "country", length = 60)
	private String country;
	
	@Size(max = 70)
	@Column(name = "profession", length = 70)
	private String profession;
	
	@Size(max = 500)
	@Column(name = "summary", length = 500)
	private String summary;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;

	public PersonalInfo() {

	}

	public PersonalInfo(String firstName, String lastName, String phone, String email, String city, String province,
			String country, String profession, String summary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.province = province;
		this.country = country;
		this.profession = profession;
		this.summary = summary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
