package edu.metrocamp.meguia.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name = "Tag")
@JsonSerialize(using = TagSerializer.class)
public class Tag extends AbstractEntidade {
	
	@Column(name = "Nome")
	private String nome;
	
	@ManyToMany(mappedBy = "tags")
	private List<Beacon> beacons;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
