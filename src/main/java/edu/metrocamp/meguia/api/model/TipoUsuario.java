package edu.metrocamp.meguia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "Tipo_Usuario")
@JsonSerialize(using = TipoUsuarioSerializer.class)
public class TipoUsuario {
	
	@Id
	private Integer id;
	
	@Column(name = "Nome")
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
