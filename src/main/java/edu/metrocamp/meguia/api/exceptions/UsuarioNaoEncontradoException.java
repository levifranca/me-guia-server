package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNaoEncontradoException extends AbstractMeGuiaException {

	private static final long serialVersionUID = -7220184514128087019L;
	
	public final static Integer CODIGO = 2;
	public final static HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
	
	public UsuarioNaoEncontradoException(String mensagem) {
		super(CODIGO, mensagem);
	}
	
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
