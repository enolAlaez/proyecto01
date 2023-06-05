package com.dawes.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.ReposicionVO;
import com.dawes.repository.ReposicionRepository;
import com.dawes.service.ReposicionService;

@Service
public class ReposicionServiceImpl implements ReposicionService {
	
	@Autowired
	private ReposicionRepository repr;

	@Override
	public <S extends ReposicionVO> S save(S entity) {
		return repr.save(entity);
	}

	@Override
	public <S extends ReposicionVO> Iterable<S> saveAll(Iterable<S> entities) {
		return repr.saveAll(entities);
	}

	@Override
	public Optional<ReposicionVO> findById(Integer id) {
		return repr.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return repr.existsById(id);
	}

	@Override
	public Iterable<ReposicionVO> findAll() {
		return repr.findAll();
	}

	@Override
	public Iterable<ReposicionVO> findAllById(Iterable<Integer> ids) {
		return repr.findAllById(ids);
	}

	@Override
	public long count() {
		return repr.count();
	}

	@Override
	public void deleteById(Integer id) {
		repr.deleteById(id);
	}

	@Override
	public void delete(ReposicionVO entity) {
		repr.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		repr.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends ReposicionVO> entities) {
		repr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		repr.deleteAll();
	}
	
	

}
