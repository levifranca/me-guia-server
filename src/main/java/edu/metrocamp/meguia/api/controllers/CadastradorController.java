package edu.metrocamp.meguia.api.controllers;

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

import edu.metrocamp.meguia.api.dtos.PostNewCadastradorRequestDTO;
import edu.metrocamp.meguia.api.dtos.PostUpdateCadastradorRequestDTO;
import edu.metrocamp.meguia.api.exceptions.AbstractMeGuiaException;
import edu.metrocamp.meguia.api.model.Usuario;
import edu.metrocamp.meguia.api.services.UsuarioService;

@RestController
@RequestMapping("/api/")
public class CadastradorController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(path = "/cadastradores", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> getCadastradores(HttpServletResponse resp) throws AbstractMeGuiaException {

		List<Usuario> us = usuarioService.findAllUsuarios();

		if (us == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
		}

		return us;
	}

	@RequestMapping(path = "/cadastrador/{login}", method = RequestMethod.GET)
	public @ResponseBody Usuario getCadastrador(HttpServletResponse resp, @PathVariable String login)
			throws AbstractMeGuiaException {
		Usuario u = usuarioService.findUsuario(login);

		if (u == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return u;
	}

	@RequestMapping(path = "/cadastrador", method = RequestMethod.POST)
	public String postNewCadastrador(HttpServletResponse resp, @RequestBody PostNewCadastradorRequestDTO reqDTO)
			throws AbstractMeGuiaException {

		usuarioService.createUsuario(reqDTO);

		resp.setStatus(HttpStatus.CREATED.value());
		return HttpStatus.CREATED.getReasonPhrase();
	}

	@RequestMapping(path = "/cadastrador/{login}", method = RequestMethod.POST)
	public String postUpdateCadastrador(HttpServletResponse resp, @PathVariable String login,
			@RequestBody PostUpdateCadastradorRequestDTO reqDTO) throws AbstractMeGuiaException {

		usuarioService.updateUsuario(login, reqDTO);

		resp.setStatus(HttpStatus.OK.value());
		return HttpStatus.OK.getReasonPhrase();
	}
}