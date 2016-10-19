package edu.metrocamp.meguia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.metrocamp.meguia.api.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
}
