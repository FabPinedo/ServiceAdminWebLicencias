package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.aquarius.app.models.entity.Sistema;

public interface ISistemaDao extends JpaRepository<Sistema, Long> {
	
	@Query(nativeQuery = true, value= "SELECT * FROM LICENCIA_SISTEMA A WHERE A.IND_BAJA =0")
	public Page<Sistema> findByEstado(Pageable pageable);
	@Query(nativeQuery = true, value= "SELECT * FROM LICENCIA_SISTEMA A WHERE A.IND_BAJA =0")
	public List<Sistema> ListadoActivo();
}
