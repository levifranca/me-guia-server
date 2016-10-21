package edu.metrocamp.meguia.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.metrocamp.meguia.api.exceptions.AbstractMeGuiaException;
import edu.metrocamp.meguia.api.exceptions.RegiaoNaoEncontradaException;
import edu.metrocamp.meguia.api.model.Regiao;
import edu.metrocamp.meguia.api.repositories.RegiaoRepository;

@Service
public class RegiaoService {
	
	@Autowired
	private RegiaoRepository repository;

	public List<Regiao> findAllRegioes() throws AbstractMeGuiaException {

		List<Regiao> regioes = repository.findAll();

		if (regioes == null || regioes.isEmpty()) {
			throw new RegiaoNaoEncontradaException("Nenhuma região encontrada no sistema!");
		}

		return regioes;
	}

}
