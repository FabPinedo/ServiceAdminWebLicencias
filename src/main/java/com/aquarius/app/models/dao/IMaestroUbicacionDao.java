package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.aquarius.app.models.entity.MaestroUbicacion;

public interface IMaestroUbicacionDao extends JpaRepository<MaestroUbicacion, String> {
	@Query(nativeQuery = true, value= "SELECT A.* \r\n"
			+ "FROM AFI_UBICACION A \r\n"
			+ "WHERE A.COD_COMPANIA = :codigo")
	public List<MaestroUbicacion> findAllByCodigo(@Param("codigo") Long codigo);
}
