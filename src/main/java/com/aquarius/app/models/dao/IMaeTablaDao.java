package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aquarius.app.models.entity.MaeTabla;

public interface IMaeTablaDao extends CrudRepository<MaeTabla, String>{
	
	@Query(nativeQuery = true, value= "SELECT A.* FROM MAE_TABLA A ORDER BY A.DES_TABLA")
	public List<MaeTabla> findAllOrderPorNombre();
	
	@Query(nativeQuery = true, value= "SELECT COUNT (*) AS CONTAR FROM MAE_TABLA A WHERE A.TIP_TABLA = :codigo")
	public int countByCodigo(@Param("codigo") String codigo);
	
}