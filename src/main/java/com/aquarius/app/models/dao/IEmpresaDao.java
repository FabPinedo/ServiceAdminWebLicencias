package com.aquarius.app.models.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.aquarius.app.models.entity.Empresa;

public interface IEmpresaDao extends JpaRepository<Empresa, Long> {
	
	@Query(nativeQuery = true, value= "SELECT * FROM LICENCIA_EMPRESA A WHERE A.RAZON_SOCIAL like %:razonsocial%")
	public Page< Empresa> findByRazonsocial(@Param("razonsocial") String razonsocial,Pageable pageable);
	
	@Query(nativeQuery = true, value= "SELECT * FROM LICENCIA_EMPRESA A WHERE A.RAZON_SOCIAL like %:razonsocial% AND A.IND_BAJA =0")
	public List<Empresa> findByRazonsocialListado(@Param("razonsocial") String razonsocial);
	
	@Query(nativeQuery = true, value= "SELECT * FROM LICENCIA_EMPRESA A WHERE A.CODIGO_RUC like %:ruc%")
	public Page< Empresa> findByRuc(@Param("ruc") String ruc,Pageable pageable);
	
	@Query(nativeQuery = true, value= "SELECT * FROM LICENCIA_EMPRESA A WHERE A.CODIGO_RUC like %:ruc% AND A.IND_BAJA =0")
	public List< Empresa> findByRucListado(@Param("ruc") String ruc);
	
	@Query(nativeQuery = true, value= "SELECT * FROM LICENCIA_EMPRESA A WHERE A.IND_BAJA =0")
	public Page< Empresa> findByEstado(Pageable pageable);
	@Query(nativeQuery = true, value= "SELECT * FROM LICENCIA_EMPRESA A WHERE A.IND_BAJA =0")
	public List< Empresa> ListadoActivos();
	
}
