package com.dawes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.ArbolVO;
import com.dawes.modelo.FincaVO;

@Repository
public interface ArbolRepository extends CrudRepository<ArbolVO, Integer>{
	
	@Query("select f FROM ArbolVO f WHERE f.finca.idfinca = :idfinca")
	List<ArbolVO> findAllByFincaId(int idfinca);
	


}