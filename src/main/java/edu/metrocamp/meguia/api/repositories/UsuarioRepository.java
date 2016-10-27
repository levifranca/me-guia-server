package edu.metrocamp.meguia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.metrocamp.meguia.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByLogin(String login);

	@Query("SELECT u FROM Usuario u WHERE u.ativo = 1 AND u.login = :login AND u.senha = sha2(:senha, 256)")
	Usuario checkUsuario(@Param("login") String login, @Param("senha") String senha);
	
}
