package edu.metrocamp.meguia.api.services;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.metrocamp.meguia.api.dtos.PostNewBeaconRequestDTO;
import edu.metrocamp.meguia.api.dtos.PostUpdateBeaconRequestDTO;
import edu.metrocamp.meguia.api.exceptions.AbstractMeGuiaException;
import edu.metrocamp.meguia.api.exceptions.BeaconJaExisteException;
import edu.metrocamp.meguia.api.exceptions.BeaconNaoEncontradoException;
import edu.metrocamp.meguia.api.exceptions.DadosDeBeaconIncompletosException;
import edu.metrocamp.meguia.api.exceptions.UsuarioInativoException;
import edu.metrocamp.meguia.api.model.Beacon;
import edu.metrocamp.meguia.api.model.Regiao;
import edu.metrocamp.meguia.api.model.Usuario;
import edu.metrocamp.meguia.api.repositories.BeaconRepository;

@Service
public class BeaconService {

	@Autowired
	private BeaconRepository repository;

	@Autowired
	private EstatisticaService estatisticaService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private RegiaoService regiaoService;

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

	public List<Beacon> findAllBeacons() throws AbstractMeGuiaException {
		List<Beacon> beacons = repository.findAll();

		if (beacons == null || beacons.isEmpty()) {
			throw new BeaconNaoEncontradoException("Nenhum beacon encontrado no sistema!");
		}

		return beacons;
	}

	public Beacon findBeacon(Integer id) throws AbstractMeGuiaException {
		Beacon b = repository.findOne(id);

		if (b == null) {
			throw new BeaconNaoEncontradoException(
					String.format("O beacon com id = %s não foi encontrado no sistema!", id));
		}

		return b;
	}

	public void createBeacon(PostNewBeaconRequestDTO reqDTO) throws AbstractMeGuiaException {

		if (StringUtils.isAnyBlank(reqDTO.getNome(), reqDTO.getEnderecoMac(), reqDTO.getLoginCriador(),
				reqDTO.getMensagem()) || reqDTO.getRegiaoId() == null) {
			throw new DadosDeBeaconIncompletosException(
					"Um dos seguintes dados não foram enviados: nome, endereco_mac, login_criador, mensagem ou regiao.");
		}

		if (existsBeaconWithMacAddress(reqDTO.getEnderecoMac())) {
			throw new BeaconJaExisteException(
					String.format("Já existe um beacon cadastrado com o Endereço MAC: %s", reqDTO.getEnderecoMac()));
		}

		Usuario cadastrador = usuarioService.findUsuario(reqDTO.getLoginCriador());
		if (!cadastrador.getAtivo()) {
			throw new UsuarioInativoException(
					String.format("O cadastrador com o login %s não está ativo.", reqDTO.getLoginCriador()));
		}

		Regiao r = regiaoService.findRegiao(reqDTO.getRegiaoId());
		Date now = new Date();

		Beacon b = new Beacon();
		b.setAtivo(true);
		b.setCriadoEm(now);
		b.setCriadoPor(cadastrador);
		b.setDescricao(reqDTO.getDescricao());
		b.setEnderecoMAC(reqDTO.getEnderecoMac().toUpperCase());
		b.setMensagemTexto(reqDTO.getMensagem());
		b.setModificadoEm(now);
		b.setModificadoPor(cadastrador);
		b.setNome(reqDTO.getNome());
		b.setRegiao(r);
		b.setVibrar(reqDTO.getVibrar());

		repository.saveAndFlush(b);

	}

	private boolean existsBeaconWithMacAddress(String enderecoMac) {
		Beacon b = repository.findByEnderecoMAC(enderecoMac.toUpperCase());
		return !(b == null);
	}

	public void updateBeacon(Integer id, PostUpdateBeaconRequestDTO reqDTO) throws AbstractMeGuiaException {

		Beacon b = repository.findOne(id);
		if (b == null) {
			throw new BeaconNaoEncontradoException(String.format("Nenhum beacon com id = %d foi encontrado.", id));
		}

		if (StringUtils.isBlank(reqDTO.getLoginModificador())) {
			throw new DadosDeBeaconIncompletosException("O campo login_modificador não foi enviado.");
		}

		Usuario modificador = usuarioService.findUsuario(reqDTO.getLoginModificador());
		if (!modificador.getAtivo()) {
			throw new UsuarioInativoException(
					String.format("O cadastrador com o login %s não está ativo.", reqDTO.getLoginModificador()));
		}


		if (StringUtils.isNotBlank(reqDTO.getMensagem())) {

		}

		if (reqDTO.getVibrar() != null) {
			b.setVibrar(reqDTO.getVibrar());
		}
		if (reqDTO.getAtivo() != null) {
			b.setAtivo(reqDTO.getAtivo());
		}

		if (StringUtils.isNotBlank(reqDTO.getNome())) {
			b.setNome(reqDTO.getNome());
		}

		if (reqDTO.getRegiaoId() != null) {
			Regiao r = regiaoService.findRegiao(reqDTO.getRegiaoId());
			b.setRegiao(r);
		}

		b.setMensagemTexto(reqDTO.getMensagem());
		b.setDescricao(reqDTO.getDescricao());

		Date now = new Date();
		b.setModificadoEm(now);
		b.setModificadoPor(modificador);
		
		repository.saveAndFlush(b);
	}

}
