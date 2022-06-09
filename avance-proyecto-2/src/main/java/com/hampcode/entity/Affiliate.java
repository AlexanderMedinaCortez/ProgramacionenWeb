package com.hampcode.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "affiliates")
public class Affiliate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Ingresar su nombre")
	@Column(name = "first_name", nullable = false, length = 70)
	private String firstName;

	@NotEmpty(message = "Ingresar su apellido")
	@Column(name = "last_name", nullable = false, length = 70)
	private String lastName;

	@NotEmpty(message = "Ingresar el nombre de la empresa")
	@Column(name = "company_name", nullable = false)
	private String companyName;

	@NotEmpty(message = "Ingresar el ruc de la empresa")
	@Column(name = "ruc", nullable = false)
	private String ruc;

	@NotEmpty(message = "Ingresar su numero de celular")
	@Column(name = "telefono", nullable = false, length = 9)
	private String phone;

	@NotEmpty(message = "Ingresar su correo electronico")
	@Column(name = "email", nullable = false)
	private String email;

	@NotEmpty(message = "Ingresar su contrasenia")
	@Column(name = "password", nullable = false)
	private String password;

	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	private Department department;

	@ManyToOne
	@JoinColumn(name = "province_id", nullable = false)
	private Province province;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
