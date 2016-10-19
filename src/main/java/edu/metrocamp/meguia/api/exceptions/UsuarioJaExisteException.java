package edu.metrocamp.meguia.api.exceptions;

public class UsuarioJaExisteException extends AbstractMeGuiaException {

	public final static Integer CODIGO = 1; 
	
	public UsuarioJaExisteException(String mensagem) {
		super(1, mensagem);
	}
}
