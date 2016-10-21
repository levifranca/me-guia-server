package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public abstract class AbstractMeGuiaException extends Exception {

	private static final long serialVersionUID = 8669271071476703167L;
	public final static HttpStatus HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
	
	private Integer codigo;
	private String mensagem;
	
	public AbstractMeGuiaException(Integer codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
