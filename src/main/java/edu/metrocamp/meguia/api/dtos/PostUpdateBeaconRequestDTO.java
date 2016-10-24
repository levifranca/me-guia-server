package edu.metrocamp.meguia.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author levifranca
 *
 */
public class PostUpdateBeaconRequestDTO {
	private Boolean ativo;
	private String nome;
	private String descricao;
	private String mensagem;
	private Boolean vibrar;
	@JsonProperty("regiao_id")
	private Integer regiaoId;

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

}
