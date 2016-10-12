package edu.metrocamp.meguia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.metrocamp.meguia.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
