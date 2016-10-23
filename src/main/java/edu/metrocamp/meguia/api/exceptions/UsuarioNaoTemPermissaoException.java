package edu.metrocamp.meguia.api.exceptions;

import org.springframework.http.HttpStatus;

public class UsuarioNaoTemPermissaoException extends AbstractMeGuiaException {

	private static final long serialVersionUID = -7220184514128087019L;
	
	public final static HttpStatus HTTP_STATUS = HttpStatus.FORBIDDEN;
	
	public UsuarioNaoTemPermissaoException(String mensagem) {
		super(CodigosExceptionsConstantes.USUARIO_NAO_TEM_PERMISSAO, mensagem);
	}
	
	public HttpStatus getHttpStatus() {
		return HTTP_STATUS;
	}
}
