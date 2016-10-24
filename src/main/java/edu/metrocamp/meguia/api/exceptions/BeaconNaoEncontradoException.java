package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class BeaconNaoEncontradoException extends AbstractMeGuiaException {

	private static final long serialVersionUID = -7220184514128087019L;
	
	public final static HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
	
	public BeaconNaoEncontradoException(String mensagem) {
		super(CodigosExceptionsConstantes.BEACON_NAO_ENCONTRADO, mensagem);
	}
	
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
