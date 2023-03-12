package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name", nullable = false)
	private String userName;

	@Column(name = "mobile", nullable = false)
	@Size(max = 10, message = "Mobile number cannot be more than 10 digits")
	private String mobile;

	@Column(name = "Email", nullable = false)
	@javax.validation.constraints.Email(message = "please enter valid email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	private String email;

	@Column(name = "Password", nullable = false)
	@Size(min = 4, max = 8, message = "Password cannot be more than 8 characters and cannot be less than 4 characters")
	private String password;
	
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public UserEntity(long id, String userName,
			@Size(max = 10, message = "Mobile number cannot be more than 10 digits") String mobile,
			@Email(message = "please enter valid email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}") String email,
			@Size(min = 4, max = 8, message = "Password cannot be more than 8 characters and cannot be less than 4 characters") String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}



	
	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setId(long id) {
		this.id = id;
	}

	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
