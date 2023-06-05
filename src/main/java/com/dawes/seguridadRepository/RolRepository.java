package com.dawes.seguridadRepository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.seguridadModelo.RolVO;

@Repository
public interface RolRepository extends CrudRepository<RolVO, Integer> {
	Optional<RolVO> findByNombre(String nombre);
}
