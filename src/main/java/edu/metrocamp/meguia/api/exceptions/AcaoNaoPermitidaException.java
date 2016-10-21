package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class AcaoNaoPermitidaException extends AbstractMeGuiaException {

	private static final long serialVersionUID = -7220184514128087019L;
	
	public final static Integer CODIGO = 6;
	public final static HttpStatus HTTP_STATUS = HttpStatus.FORBIDDEN;
	
	public AcaoNaoPermitidaException(String mensagem) {
		super(CODIGO, mensagem);
	}
	
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
