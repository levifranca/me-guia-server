package edu.metrocamp.meguia.api.exceptions;

public class UsuarioJaExisteException extends AbstractMeGuiaException {

	private static final long serialVersionUID = -7220184514128087019L;
	
	public final static Integer CODIGO = 1; 
	
	public UsuarioJaExisteException(String mensagem) {
		super(1, mensagem);
	}
}
