package edu.metrocamp.meguia.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Beacon")
public class Beacon extends AbstractEntidade {

	@Column(name = "Endereco_MAC",columnDefinition="char(12)")
	private String enderecoMAC;

	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Descricao")
	private String descricao;

	@Column(name = "Mensagem")
	private String mensagemTexto;

	@Column(name = "Mensagem_sonora")
	private String mensagemSom;

	@Column(name = "Vibrar")
	private Boolean vibrar;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Regiao")
	private Regiao regiao;

	@ManyToMany
	@JoinTable(name = "Beacon_Tag",
    joinColumns=
        @JoinColumn(name="Beacon_id", referencedColumnName="ID"),
    inverseJoinColumns=
        @JoinColumn(name="Tag_id", referencedColumnName="ID")
    )
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
