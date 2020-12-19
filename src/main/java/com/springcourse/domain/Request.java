package com.springcourse.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.springcourse.domain.enums.RequestState;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 100, nullable = false)
	private String subject;
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	private RequestState state;
	
	private User user;
	
	private List<RequestStage> stages = new ArrayList<>();
	
	public Request() {
	}

	public Request(Integer id, String subject, String description, LocalDateTime creationDate, RequestState state,
			User user) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
		this.creationDate = creationDate;
		this.state = state;
		this.user = user;
	}
	
}
