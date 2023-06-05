package com.dawes.seguridadService;

import java.util.Optional;

import com.dawes.seguridadModelo.UsuarioRolVO;

public interface ServicioUsuarioRol {

	<S extends UsuarioRolVO> S save(S entity);

	<S extends UsuarioRolVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<UsuarioRolVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<UsuarioRolVO> findAll();

	Iterable<UsuarioRolVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(UsuarioRolVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends UsuarioRolVO> entities);

	void deleteAll();

}