package edu.metrocamp.meguia.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.metrocamp.meguia.api.model.Beacon;
import edu.metrocamp.meguia.api.model.RegistroIdentificacao;
import edu.metrocamp.meguia.api.repositories.RegistroIdentificacaoRepository;

@Service
public class EstatisticaService {

	@Autowired
	private RegistroIdentificacaoRepository riRepository;
	
	public void adicionaRegistroDeIdentificacao(Beacon beacon) {
		RegistroIdentificacao ri = new RegistroIdentificacao();
		
		ri.setBeacon(beacon);
		ri.setTimestampMillis(System.currentTimeMillis());
		
		riRepository.saveAndFlush(ri);
	}
			
}
