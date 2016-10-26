package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class MensagemSonoraNaoEncontradaException extends AbstractMeGuiaException {

	private static final long serialVersionUID = -7220184514128087019L;
	
	public final static HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;
	
	public MensagemSonoraNaoEncontradaException(String mensagem) {
		super(CodigosExceptionsConstantes.MENSAGEM_SONORA_NAO_ENCONTRADA, mensagem);
	}
	
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
