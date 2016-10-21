package edu.metrocamp.meguia.api.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.metrocamp.meguia.api.exceptions.AbstractMeGuiaException;
import edu.metrocamp.meguia.api.model.Regiao;
import edu.metrocamp.meguia.api.services.RegiaoService;

@RestController
@RequestMapping("/api/")
public class RegiaoController {

	@Autowired
	private RegiaoService regiaoService;

	@RequestMapping(path = "/regioes", method = RequestMethod.GET)
	public @ResponseBody List<Regiao> getCadastradores(HttpServletResponse resp) throws AbstractMeGuiaException {

		List<Regiao> rs = regiaoService.findAllRegioes();

		if (rs == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
		}

		return rs;
	}
	
	/*
	@RequestMapping(path = "/regiao/{id}", method = RequestMethod.GET)
	public @ResponseBody Usuario getCadastrador(HttpServletResponse resp, @PathVariable String login)
			throws AbstractMeGuiaException {
		Usuario u = usuarioService.findUsuario(login);

		if (u == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return u;
	}

	@RequestMapping(path = "/regiao", method = RequestMethod.POST)
	public String postNewCadastrador(HttpServletResponse resp, @RequestBody PostNewCadastradorRequestDTO reqDTO)
			throws AbstractMeGuiaException {

		usuarioService.createUsuario(reqDTO);

		resp.setStatus(HttpStatus.CREATED.value());
		return HttpStatus.CREATED.getReasonPhrase();
	}

	@RequestMapping(path = "/regiao/{id}", method = RequestMethod.POST)
	public String postUpdateCadastrador(HttpServletResponse resp, @PathVariable String login,
			@RequestBody PostUpdateCadastradorRequestDTO reqDTO) throws AbstractMeGuiaException {

		usuarioService.updateUsuario(login, reqDTO);

		resp.setStatus(HttpStatus.OK.value());
		return HttpStatus.OK.getReasonPhrase();
	}
	
	*/
}