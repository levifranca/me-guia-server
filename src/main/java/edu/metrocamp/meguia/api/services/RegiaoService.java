package edu.metrocamp.meguia.api.services;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.metrocamp.meguia.api.dtos.PostNewRegiaoRequestDTO;
import edu.metrocamp.meguia.api.exceptions.AbstractMeGuiaException;
import edu.metrocamp.meguia.api.exceptions.DadosDeRegiaoIncompletosException;
import edu.metrocamp.meguia.api.exceptions.RegiaoNaoEncontradaException;
import edu.metrocamp.meguia.api.exceptions.UsuarioInativoException;
import edu.metrocamp.meguia.api.model.Regiao;
import edu.metrocamp.meguia.api.model.Usuario;
import edu.metrocamp.meguia.api.repositories.RegiaoRepository;

@Service
public class RegiaoService {
	
	@Autowired
	private RegiaoRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;

	public List<Regiao> findAllRegioes() throws AbstractMeGuiaException {

		List<Regiao> regioes = repository.findAll();

		if (regioes == null || regioes.isEmpty()) {
			throw new RegiaoNaoEncontradaException("Nenhuma região encontrada no sistema!");
		}

		return regioes;
	}

	public Regiao findRegiao(Integer id) throws AbstractMeGuiaException {
		
		Regiao r = repository.findOne(id);

		if (r == null) {
			throw new RegiaoNaoEncontradaException(
					String.format("A região de id %s não foi encontrado no sistema!", id));
		}

		return r;
	}

	public void createRegiao(PostNewRegiaoRequestDTO reqDTO) throws AbstractMeGuiaException {
		
		if (StringUtils.isAnyBlank(reqDTO.getNome(), reqDTO.getDescricao(), reqDTO.getLoginCriador())) {
			throw new DadosDeRegiaoIncompletosException("Dados de região estão faltando, confira o envio de nome, descrição e login_criador.");
		}
		
		Usuario criador = usuarioService.findUsuario(reqDTO.getLoginCriador());
		if (criador != null && !criador.getAtivo()) {
			throw new UsuarioInativoException("O criador está inativo.");
		}
		
		Date now = new Date();
		
		Regiao r = new Regiao();
		
		r.setAtivo(true);
		r.setCriadoEm(now);
		r.setCriadoPor(criador);
		r.setDescricao(reqDTO.getDescricao());
		r.setModificadoEm(now);
		r.setModificadoPor(criador);
		r.setNome(reqDTO.getNome());
		
		repository.saveAndFlush(r);
	}

}
