package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class DadosDeBeaconIncompletosException extends AbstractMeGuiaException {
	private static final long serialVersionUID = -7220184514128087019L;

	public final static HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

	public DadosDeBeaconIncompletosException(String mensagem) {
		super(CodigosExceptionsConstantes.DADOS_DE_BEACON_INCOMPLETOS, mensagem);
	}

	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
