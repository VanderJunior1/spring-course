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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.springcourse.domain.enums.RequestState;

import lombok.EqualsAndHashCode;

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
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column(name = "creation_date", nullable = false)
	private LocalDateTime creationDate;
	
	@Column(nullable = false)
	private Integer state;
	
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false)
	private User owner;
	
	@OneToMany(mappedBy = "request")
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
		this.state = state.getCod();
		this.owner = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public RequestState getState() {
		return RequestState.toEnum(state);
	}

	public void setState(RequestState state) {
		this.state = state.getCod();
	}

	public User getUser() {
		return owner;
	}

	public void setUser(User user) {
		this.owner = user;
	}

	public List<RequestStage> getStages() {
		return stages;
	}

	public void setStages(List<RequestStage> stages) {
		this.stages = stages;
	}
	
}
