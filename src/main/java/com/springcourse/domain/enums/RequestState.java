package com.springcourse.domain.enums;

public enum RequestState {

	OPEN(1, "Open"), 
	IN_PROGRESS(1, "In Progress"), 
	CLOSED(2, "Closed");

	private int cod;
	private String descricao;

	private RequestState(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static RequestState toEnum(Integer cod) {
		if (cod.equals(null)) {
			return null;
		}

		for (RequestState x : RequestState.values()) {
			return x;
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
