package edu.metrocamp.meguia.api.services;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.metrocamp.meguia.api.dtos.PostNewCadastradorRequestDTO;
import edu.metrocamp.meguia.api.dtos.PostUpdateCadastradorRequestDTO;
import edu.metrocamp.meguia.api.exceptions.AbstractMeGuiaException;
import edu.metrocamp.meguia.api.exceptions.AcaoNaoPermitidaException;
import edu.metrocamp.meguia.api.exceptions.AdministradorNaoEncontradoException;
import edu.metrocamp.meguia.api.exceptions.MudancaDeSenhaInvalidaException;
import edu.metrocamp.meguia.api.exceptions.UsuarioJaExisteException;
import edu.metrocamp.meguia.api.exceptions.UsuarioNaoEncontradoException;
import edu.metrocamp.meguia.api.exceptions.UsuarioNaoTemPermissaoException;
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

	public List<Usuario> findAllUsuarios() throws AbstractMeGuiaException {

		List<Usuario> usuarios = repository.findAll();

		if (usuarios == null || usuarios.isEmpty()) {
			throw new UsuarioNaoEncontradoException("Nenhum usuário encontrado no sistema!");
		}

		return usuarios;
	}

	public Usuario findUsuario(String login) throws AbstractMeGuiaException {
		Usuario u = repository.findByLogin(login);

		if (u == null) {
			throw new UsuarioNaoEncontradoException(
					String.format("O usuário %s não foi encontrado no sistema!", login));
		}

		return u;
	}

	public void createUsuario(PostNewCadastradorRequestDTO reqDTO)
			throws AbstractMeGuiaException {

		if (existsByLogin(reqDTO.getLogin())) {
			throw new UsuarioJaExisteException(String.format("O usuário %s já existe", reqDTO.getLogin()));
		}

		Usuario admin = repository.findByLogin(reqDTO.getLoginCriador());
		if (admin == null) {
			throw new AdministradorNaoEncontradoException(String.format("O administrador %s fornecido não está cadastrado!", reqDTO.getLoginCriador()));
		}
		if (!"Administrador".equals(admin.getTipo().getNome())) {
			throw new UsuarioNaoTemPermissaoException("O usuario criador não é Administrador!");
		}

		Date now = new Date();
		String senhaSha264 = DigestUtils.sha256Hex(reqDTO.getSenha());
		TipoUsuario tu = tipoUsuarioRepository.findOne(reqDTO.getTipo());

		Usuario u = new Usuario();
		u.setAtivo(true);
		u.setCriadoEm(now);
		u.setCriadoPor(admin);
		u.setLogin(reqDTO.getLogin());
		u.setModificadoEm(now);
		u.setModificadoPor(admin);
		u.setNome(reqDTO.getNome());
		u.setSenha(senhaSha264);
		u.setTipo(tu);

		repository.saveAndFlush(u);
	}

	private boolean existsByLogin(String login) {
		Usuario u = repository.findByLogin(login);
		return u != null;
	}

	public void updateUsuario(String login, PostUpdateCadastradorRequestDTO reqDTO) throws AbstractMeGuiaException {
		Usuario u = repository.findByLogin(login);
		if (u == null) {
			throw new UsuarioNaoEncontradoException(
					String.format("O usuário %s não foi encontrado no sistema!", login));
		}
		
		Usuario admin = repository.findByLogin(reqDTO.getLoginModificador());
		if (admin == null) {
			throw new AdministradorNaoEncontradoException(String.format("O administrador %s fornecido não está cadastrado!", reqDTO.getLoginModificador()));
		}
		if ("Administrador".equals(u.getTipo().getNome()) && !"Administrador".equals(admin.getTipo().getNome())) {
			throw new UsuarioNaoTemPermissaoException("O usuario modificador não é Administrador!");
		}
		
		if (StringUtils.isNotBlank(reqDTO.getSenhaAtual())) {
			if (StringUtils.isBlank(reqDTO.getSenhaNova())) {
				throw new MudancaDeSenhaInvalidaException("Senha nova não enviada!");
			}
			
			if (!u.getLogin().equals(admin.getLogin()) && !"Administrador".equals(admin.getTipo().getNome())) {
				throw new AcaoNaoPermitidaException("Somente o próprio usuario ou um Administrador pode mudar a senha!");
			}
			
			if (!u.getSenha().equals(DigestUtils.sha256Hex(reqDTO.getSenhaAtual()))){
				throw new AcaoNaoPermitidaException("A senha atual enviada está incorreta!");
			}
			
			u.setSenha(DigestUtils.sha256Hex(reqDTO.getSenhaNova()));
			
		} else {
			
			if (StringUtils.isNotBlank(reqDTO.getSenhaNova())) {
				throw new MudancaDeSenhaInvalidaException("Senha atual não enviada!");
			}
			
		}
		
		if (StringUtils.isNotBlank(reqDTO.getNome())){
			u.setNome(reqDTO.getNome());
		}
		
		if (reqDTO.getAtivo() != null){
			u.setAtivo(reqDTO.getAtivo());
		}
		
		u.setModificadoEm(new Date());
		u.setModificadoPor(admin);
		repository.saveAndFlush(u);
	}
	
	public Usuario checkUsuario(String login, String senha) {
		return repository.checkUsuario(login, senha);
	}
}
