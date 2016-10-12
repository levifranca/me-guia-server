package edu.metrocamp.meguia.api.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.metrocamp.meguia.api.model.TipoUsuario;
import edu.metrocamp.meguia.api.model.Usuario;

@RestController
@RequestMapping("/api/")
public class CadastroEntidadeController {

	@RequestMapping(path = "/cadastradores", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> getCadastradores() {
		List<Usuario> us = new ArrayList<>();
		// TODO make the actual call
		Usuario u = new Usuario();
		u.setAtivo(true);
		u.setCriadoEm(new Date());
		u.setCriadoPor(u);
		u.setId(1);
		u.setLogin("user");
		u.setModificadoEm(new Date());
		u.setModificadoPor(u);
		u.setNome("User");
		u.setSenha("123456");
		TipoUsuario tu = new TipoUsuario();
		tu.setId(0);
		tu.setNome("Administrador");
		u.setTipo(tu);
		us.add(u);
		
		u = new Usuario();
		u.setAtivo(false);
		u.setCriadoEm(new Date());
		u.setCriadoPor(u);
		u.setId(1);
		u.setLogin("user1");
		u.setModificadoEm(new Date());
		u.setModificadoPor(u);
		u.setNome("User1");
		u.setSenha("1111111");
		tu = new TipoUsuario();
		tu.setId(1);
		tu.setNome("Comum");
		u.setTipo(tu);
		us.add(u);
		
		return us;
	}
}