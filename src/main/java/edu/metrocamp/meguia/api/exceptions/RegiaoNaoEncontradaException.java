package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class RegiaoNaoEncontradaException extends AbstractMeGuiaException {

	private static final long serialVersionUID = -7220184514128087019L;
	
	public final static Integer CODIGO = 7;
	public final static HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
	
	public RegiaoNaoEncontradaException(String mensagem) {
		super(CodigosExceptionsConstantes.REGIAO_NAO_ENCONTRADA, mensagem);
	}
	
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
