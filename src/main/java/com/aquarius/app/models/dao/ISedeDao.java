package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aquarius.app.models.entity.Sede;

public interface ISedeDao extends JpaRepository<Sede,String> {
	
	@Query(nativeQuery = true, value= "SELECT A.* \r\n"
			+ "FROM LICENCIA_SEDE A \r\n"
			+ "WHERE A.COD_EMPRESA = :codigo")
	public List<Sede> findAllByCodigo(@Param("codigo") Long codigo);
}
