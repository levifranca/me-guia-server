package edu.metrocamp.meguia.api.services;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.metrocamp.meguia.api.dtos.PostCadastradorRequestDTO;
import edu.metrocamp.meguia.api.exceptions.UsuarioJaExisteException;
import edu.metrocamp.meguia.api.model.TipoUsuario;
import edu.metrocamp.meguia.api.model.Usuario;
import edu.metrocamp.meguia.api.repositories.TipoUsuarioRepository;
import edu.metrocamp.meguia.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	public List<Usuario> findAllUsuarios() {
		return repository.findAll();
	}

	public Usuario findUsuario(String login) {
		return repository.findByLogin(login);
	}

	public void createUsuario(PostCadastradorRequestDTO reqDTO) throws NoSuchAlgorithmException, UsuarioJaExisteException {
		
		if (existsByLogin(reqDTO.getLogin())) {
			throw new UsuarioJaExisteException(String.format("O usuário %s já existe", reqDTO.getLogin()));
		}
		
		Usuario uAdmin = repository.findByLogin(reqDTO.getLoginCriador());
		Date now = new Date();
		String senhaSha264 = DigestUtils.sha256Hex(reqDTO.getSenha());
		TipoUsuario tu = tipoUsuarioRepository.findOne(reqDTO.getTipo());
		
		Usuario u = new Usuario();
		u.setAtivo(true);
		u.setCriadoEm(now);
		u.setCriadoPor(uAdmin);
		u.setLogin(reqDTO.getLogin());
		u.setModificadoEm(now);
		u.setModificadoPor(uAdmin);
		u.setNome(reqDTO.getNome());
		u.setSenha(senhaSha264);
		u.setTipo(tu);
		
		repository.saveAndFlush(u);
	}

	private boolean existsByLogin(String login) {
		Usuario u = repository.findByLogin(login);
		return u != null;
	};
}
