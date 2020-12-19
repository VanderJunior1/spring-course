package com.springcourse.domain.enums;

public enum Role {

	ADMINSTRATOR(1, "Adminitrador"), 
	SIMPLE(2, "Simples");

	private int cod;
	private String descricao;

	private Role(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Role toEnum(Integer cod) {
		if (cod.equals(null)) {
			return null;
		}

		for (Role x : Role.values()) {
			return x;
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
