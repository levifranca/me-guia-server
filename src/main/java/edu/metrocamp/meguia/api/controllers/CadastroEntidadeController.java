package edu.metrocamp.meguia.api.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.metrocamp.meguia.api.dtos.PostCadastradorRequestDTO;
import edu.metrocamp.meguia.api.exceptions.UsuarioJaExisteException;
import edu.metrocamp.meguia.api.model.Usuario;
import edu.metrocamp.meguia.api.services.UsuarioService;

@RestController
@RequestMapping("/api/")
public class CadastroEntidadeController {
	
	@Autowired
	private UsuarioService usuarioService;

	/** Usuarios **/
	@RequestMapping(path = "/cadastradores", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> getCadastradores() {
		List<Usuario> us = usuarioService.findAllUsuarios();
		return us;
	}
	
	@RequestMapping(path = "/cadastrador/{login}", method = RequestMethod.GET)
	public @ResponseBody Usuario getCadastrador(HttpServletResponse resp, @PathVariable String login) {
		Usuario u = usuarioService.findUsuario(login);
		
		if (u == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return u;
	}
	
	@RequestMapping(path = "/cadastrador", method = RequestMethod.POST)
	private String postNewCadastrador(HttpServletResponse resp, @RequestBody PostCadastradorRequestDTO reqDTO) throws NoSuchAlgorithmException, UsuarioJaExisteException {
		
		usuarioService.createUsuario(reqDTO);
		
		resp.setStatus(HttpStatus.CREATED.value());
		return HttpStatus.CREATED.getReasonPhrase();
	}
}