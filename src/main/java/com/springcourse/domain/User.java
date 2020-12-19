package com.springcourse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
	
	@Column(length = 100, nullable = false)
	private String email;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	private List<Request> requests = new ArrayList<>();
	
	private List<RequestStage> stages = new ArrayList<>();
	
	public User() {
	}

	public User(Integer id, String nome, String email, String password) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.password = password;
	}
	
}
