package edu.metrocamp.meguia.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostUpdateCadastradorRequestDTO {
	private String nome;
	private Boolean ativo;

	@JsonProperty(value = "senha_atual")
	private String senhaAtual;
	
	@JsonProperty(value = "senha_nova")
	private String senhaNova;

	@JsonProperty(value = "login_modificador")
	private String loginModificador;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}

	public String getLoginModificador() {
		return loginModificador;
	}

	public void setLoginModificador(String loginModificador) {
		this.loginModificador = loginModificador;
	}

}
