package com.dawes.service;

import java.util.List;
import java.util.Optional;

import com.dawes.modelo.ArbolVO;

public interface ArbolService {

	List<ArbolVO> findAllByFincaId(int idfinca);

	<S extends ArbolVO> S save(S entity);

	<S extends ArbolVO> Iterable<S> saveAll(Iterable<S> entities);

	Optional<ArbolVO> findById(Integer id);

	boolean existsById(Integer id);

	Iterable<ArbolVO> findAll();

	Iterable<ArbolVO> findAllById(Iterable<Integer> ids);

	long count();

	void deleteById(Integer id);

	void delete(ArbolVO entity);

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteAll(Iterable<? extends ArbolVO> entities);

	void deleteAll();

}