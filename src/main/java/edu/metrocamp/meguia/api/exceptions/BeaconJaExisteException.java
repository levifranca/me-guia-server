package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class BeaconJaExisteException extends AbstractMeGuiaException {

	private static final long serialVersionUID = -7220184514128087019L;
	
	public final static HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;
	
	public BeaconJaExisteException(String mensagem) {
		super(CodigosExceptionsConstantes.BEACON_JA_EXISTE, mensagem);
	}
	
	@Override
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
