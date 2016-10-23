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

import edu.metrocamp.meguia.api.dtos.PostNewRegiaoRequestDTO;
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

	@RequestMapping(path = "/regiao/{id}", method = RequestMethod.GET)
	public @ResponseBody Regiao getCadastrador(HttpServletResponse resp, @PathVariable Integer id)
			throws AbstractMeGuiaException {
		
		Regiao r = regiaoService.findRegiao(id);

		if (r == null) {
			resp.setStatus(HttpStatus.NOT_FOUND.value());
		}
		return r;
	}

	@RequestMapping(path = "/regiao", method = RequestMethod.POST)
	public String postNewRegiao(HttpServletResponse resp, @RequestBody PostNewRegiaoRequestDTO reqDTO)
			throws AbstractMeGuiaException {
		
		regiaoService.createRegiao(reqDTO);

		resp.setStatus(HttpStatus.CREATED.value());
		return HttpStatus.CREATED.getReasonPhrase();
	}

	/*
	@RequestMapping(path = "/regiao/{id}", method = RequestMethod.POST)
	public String postUpdateCadastrador(HttpServletResponse resp, @PathVariable String login,
			@RequestBody PostUpdateCadastradorRequestDTO reqDTO) throws AbstractMeGuiaException {

		usuarioService.updateUsuario(login, reqDTO);

		resp.setStatus(HttpStatus.OK.value());
		return HttpStatus.OK.getReasonPhrase();
	}
	
	*/
}