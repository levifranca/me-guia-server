package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class AdministradorNaoEncontradoException extends AbstractMeGuiaException {

private static final long serialVersionUID = -7220184514128087019L;
	
	public final static HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;
	
	public AdministradorNaoEncontradoException(String mensagem) {
		super(CodigosExceptionsConstantes.ADMINISTRADOR_NAO_ENCONTRADO, mensagem);
	}
	
	@Override
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
