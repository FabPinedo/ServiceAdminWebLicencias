package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aquarius.app.models.entity.Cargos;


public interface ICargosDao extends JpaRepository<Cargos, String>{
	@Query(nativeQuery = true, value= "SELECT * FROM AFI_CARGOS_EMP A WHERE A.ESTADO_CARGO =1")
	public List< Cargos> ListadoActivos();
}
