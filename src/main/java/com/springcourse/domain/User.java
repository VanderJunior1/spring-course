package com.springcourse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.springcourse.domain.enums.Role;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 64, nullable = false)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	private Integer role;
	
	@OneToMany(mappedBy = "owner")
	private List<Request> requests = new ArrayList<>();
	
	@OneToMany(mappedBy = "owner")
	private List<RequestStage> stages = new ArrayList<>();
	
	public User() {
	}
	
	public User(Integer id, String nome, String email, String password, Role role) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.role = role.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Role getRole() {
		return Role.toEnum(role);
	}

	public void setRole(Role role) {
		this.role = role.getCod();
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<RequestStage> getStages() {
		return stages;
	}

	public void setStages(List<RequestStage> stages) {
		this.stages = stages;
	}

}
