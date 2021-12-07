package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.aquarius.app.models.entity.MaeAccesosRes;


public interface IMaeAccesosResDao extends CrudRepository<MaeAccesosRes, Long>{

	@Query(nativeQuery = true, value= "SELECT A.* FROM MAE_ACCESOS_RES A WHERE COD_USUARIO = :usuario")
	public List<MaeAccesosRes> findByUsuario(@Param("usuario") String usuario);
	
}
