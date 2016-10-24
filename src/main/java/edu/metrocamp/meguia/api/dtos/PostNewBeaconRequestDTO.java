package edu.metrocamp.meguia.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostNewBeaconRequestDTO {

	private String nome;
	@JsonProperty("endereco_mac")
	private String enderecoMac;
	private String descricao;
	private String mensagem;
	private Boolean vibrar;
	@JsonProperty("regiao_id")
	private Integer regiaoId;
	@JsonProperty("login_criador")
	private String loginCriador;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnderecoMac() {
		return enderecoMac;
	}

	public void setEnderecoMac(String enderecoMac) {
		this.enderecoMac = enderecoMac;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Boolean getVibrar() {
		return vibrar;
	}

	public void setVibrar(Boolean vibrar) {
		this.vibrar = vibrar;
	}

	public Integer getRegiaoId() {
		return regiaoId;
	}

	public void setRegiaoId(Integer regiaoId) {
		this.regiaoId = regiaoId;
	}

	public String getLoginCriador() {
		return loginCriador;
	}

	public void setLoginCriador(String loginCriador) {
		this.loginCriador = loginCriador;
	}

}
