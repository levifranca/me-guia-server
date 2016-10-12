package edu.metrocamp.meguia.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario extends AbstractEntidade {

	@ManyToOne
	@JoinColumn(name = "Tipo")
	private TipoUsuario tipo;
	
	@Column(name = "Login")
	private String login;
	
	@Column(name = "Senha")
	private String senha;
	
	@Column(name = "Nome")
	private String nome;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

}
