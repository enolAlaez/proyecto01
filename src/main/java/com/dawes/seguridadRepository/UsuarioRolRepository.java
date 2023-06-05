package com.dawes.seguridadRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.seguridadModelo.UsuarioRolVO;

@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRolVO, Integer> {
}

