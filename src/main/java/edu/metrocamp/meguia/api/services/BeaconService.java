package edu.metrocamp.meguia.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.metrocamp.meguia.api.exceptions.BeaconNaoEncontradoException;
import edu.metrocamp.meguia.api.model.Beacon;
import edu.metrocamp.meguia.api.repositories.BeaconRepository;

@Service
public class BeaconService {
	
	@Autowired
	private BeaconRepository repository;
	
	@Autowired
	private EstatisticaService estatisticaService;
	
	public List<Beacon> getBeaconInfo(Integer regiao, String macAddress) {
		
		List<Beacon> beacons = repository.findByRegiaoAndOrMacAddress(regiao, macAddress);
		
		if (beacons == null || beacons.isEmpty()) {
			return null;
		}
		
		for (Beacon beacon : beacons) {
			estatisticaService.adicionaRegistroDeIdentificacao(beacon);
		}
		
		return beacons;
	}

	public List<Beacon> findAllBeacons() throws BeaconNaoEncontradoException {
		List<Beacon> beacons = repository.findAll();

		if (beacons == null || beacons.isEmpty()) {
			throw new BeaconNaoEncontradoException("Nenhum beacon encontrado no sistema!");
		}

		return beacons;
	}

}
