package edu.metrocamp.meguia.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@MappedSuperclass
public abstract class AbstractEntidade {
	
	@Id
	private Integer id;
	
	@Column(name = "Ativo")
	@Type(type = "numeric_boolean")
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "Criado_por")
	private Cadastrador criadoPor;
	
	@Column(name = "Criado_em")
	private Date criadoEm;
	
	@ManyToOne
	@JoinColumn(name = "Modificado_por")
	private Cadastrador modificadoPor;
	
	@Column(name = "Modificado_em")
	private Date modificadoEm;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Cadastrador getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Cadastrador criadoPor) {
		this.criadoPor = criadoPor;
	}

	public Date getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(Date criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Date getModificadoEm() {
		return modificadoEm;
	}

	public void setModificadoEm(Date modificadoEm) {
		this.modificadoEm = modificadoEm;
	}

	public Cadastrador getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(Cadastrador modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

}
