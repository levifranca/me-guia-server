package edu.metrocamp.meguia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Beacon")
public class Beacon extends AbstractEntidade {

	@Column(name = "Endereco_MAC",columnDefinition="char(17)")
	@JsonProperty("endereco_mac")
	private String enderecoMAC;

	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Descricao")
	private String descricao;

	@Column(name = "Mensagem")
	@JsonProperty("mensagem")
	private String mensagemTexto;

	@Column(name = "Mensagem_sonora")
	@JsonProperty("audio")
	private String mensagemSom;

	@Column(name = "Vibrar")
	private Boolean vibrar;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Regiao")
	private Regiao regiao;

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

}
