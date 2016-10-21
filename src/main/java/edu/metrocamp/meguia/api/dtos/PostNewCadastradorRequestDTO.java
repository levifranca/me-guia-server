package edu.metrocamp.meguia.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostNewCadastradorRequestDTO {
	private String nome;
	private String login;
	private Integer tipo;
	private String senha;

	@JsonProperty(value = "login_criador")
	private String loginCriador;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLoginCriador() {
		return loginCriador;
	}

	public void setLoginCriador(String loginCriador) {
		this.loginCriador = loginCriador;
	}

}
