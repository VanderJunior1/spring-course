package com.springcourse.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.springcourse.domain.enums.RequestState;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class RequestStage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column(name = "realization_date", nullable = false)
	private LocalDateTime realizationDate;

	@Column(nullable = false)
	private Integer state;
	
	@ManyToOne
	@JoinColumn(name = "request_id")
	private Request request;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public RequestStage() {
	}

	public RequestStage(Integer id, String description, LocalDateTime realizationDate, RequestState state,
			Request request, User user) {
		super();
		this.id = id;
		this.description = description;
		this.realizationDate = realizationDate;
		this.state = state.getCod();
		this.request = request;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(LocalDateTime realizationDate) {
		this.realizationDate = realizationDate;
	}

	public RequestState getState() {
		return RequestState.toEnum(state);
	}

	public void setState(RequestState state) {
		this.state = state.getCod();
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
