package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class DadosDeRegiaoIncompletosException extends AbstractMeGuiaException {
	private static final long serialVersionUID = -7220184514128087019L;

	public final static HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

	public DadosDeRegiaoIncompletosException(String mensagem) {
		super(CodigosExceptionsConstantes.DADOS_DE_REGIAO_INCOMPLETOS, mensagem);
	}

	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
