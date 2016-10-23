package edu.metrocamp.meguia.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostNewRegiaoRequestDTO {
	private String nome;
	private String descricao;

	@JsonProperty(value = "login_criador")
	private String loginCriador;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLoginCriador() {
		return loginCriador;
	}

	public void setLoginCriador(String loginCriador) {
		this.loginCriador = loginCriador;
	}

}
