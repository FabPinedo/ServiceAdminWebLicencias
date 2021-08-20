package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aquarius.app.models.entity.ConexionServidor;


public interface IConexionServidorDao extends JpaRepository<ConexionServidor, Long>{
	@Query(nativeQuery = true, value= "SELECT A.*"
			+ " FROM LICENCIA_CONEXION_SERVIDOR A "
			+ "INNER JOIN LICENCIA_EMPRESA B "
			+ "ON B.ID=A.COD_EMPRESA "
			+ "WHERE B.RAZON_SOCIAL LIKE %:razonsocial%")
	public Page<ConexionServidor> findByRazonsocial(@Param("razonsocial") String razonsocial,Pageable pageable);
	@Query(nativeQuery = true, value= "SELECT A.*"
			+ " FROM LICENCIA_CONEXION_SERVIDOR A "
			+ "INNER JOIN LICENCIA_EMPRESA B "
			+ "ON B.ID=A.COD_EMPRESA "
			+ "WHERE B.CODIGO_RUC LIKE %:ruc%")
	public Page<ConexionServidor> findByRUC(@Param("ruc") String ruc,Pageable pageable);
	@Query(nativeQuery = true, value= "SELECT A.*"
			+ " FROM LICENCIA_CONEXION_SERVIDOR A "
			+ "INNER JOIN LICENCIA_EMPRESA B "
			+ "ON B.ID=A.COD_EMPRESA "
			+ "WHERE B.ID =:id")
	public List<ConexionServidor> findbyIdEmpresa(@Param("id") Long id);
}
