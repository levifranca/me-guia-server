package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class MudancaDeSenhaInvalidaException extends AbstractMeGuiaException {

private static final long serialVersionUID = -7220184514128087019L;
	
	public final static Integer CODIGO = 5;
	public final static HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;
	
	public MudancaDeSenhaInvalidaException(String mensagem) {
		super(CODIGO, mensagem);
	}
	
	@Override
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
