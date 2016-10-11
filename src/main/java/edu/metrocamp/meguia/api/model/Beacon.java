package edu.metrocamp.meguia.api.model;

import java.util.List;

public class Beacon extends AbstractEntidade {

	private String enderecoMAC;
	private String nome;
	private String descricao;
	private String mensagemTexto;
	private String mensagemSom;
	private Boolean vibrar;
	private Regiao regiao;
	private List<Tag> tags;

	public String getEnderecoMAC() {
		return enderecoMAC;
	}

	public void setEnderecoMAC(String enderecoMAC) {
		this.enderecoMAC = enderecoMAC;
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

	public String getMensagemTexto() {
		return mensagemTexto;
	}

	public void setMensagemTexto(String mensagemTexto) {
		this.mensagemTexto = mensagemTexto;
	}

	public String getMensagemSom() {
		return mensagemSom;
	}

	public void setMensagemSom(String mensagemSom) {
		this.mensagemSom = mensagemSom;
	}

	public Boolean getVibrar() {
		return vibrar;
	}

	public void setVibrar(Boolean vibrar) {
		this.vibrar = vibrar;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
