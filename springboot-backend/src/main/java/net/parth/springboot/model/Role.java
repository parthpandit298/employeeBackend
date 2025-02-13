package net.parth.springboot.model;

import jakarta.persistence.*;


@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_name")
	private String userName;

	@Column(name = "role")
	private String role;
	
	@Column(name = "password")
	private String password;
	
	public Role() {
		
	}

	public Role(String userName, String role, String password) {
		super();
		this.userName = userName;
		this.role = role;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
	
	