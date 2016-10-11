package edu.metrocamp.meguia.api.model;

import java.util.Date;

public abstract class AbstractEntidade {
	private Integer id;
	private Boolean ativo;
	private Cadastrador criadoPor;
	private Date criadoEm;
	private Cadastrador modificadoPor;
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
