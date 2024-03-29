package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioJaExisteException extends AbstractMeGuiaException {

	private static final long serialVersionUID = -7220184514128087019L;
	
	public final static HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;
	
	public UsuarioJaExisteException(String mensagem) {
		super(CodigosExceptionsConstantes.USUARIO_JA_EXISTE, mensagem);
	}
	
	@Override
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
