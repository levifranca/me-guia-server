package edu.metrocamp.meguia.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostUpdateRegiaoRequestDTO {
	private Boolean ativo;
	private String nome;
	private String descricao;

	@JsonProperty(value = "login_modificador")
	private String loginModificador;

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

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

	public String getLoginModificador() {
		return loginModificador;
	}

	public void setLoginModificador(String loginModificador) {
		this.loginModificador = loginModificador;
	}

}
