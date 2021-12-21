package com.aquarius.app.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.aquarius.app.models.entity.LicenciasUsuarioEmpresa;

public interface ILicenciasUsuarioEmpresaDao extends JpaRepository<LicenciasUsuarioEmpresa, Long> {
	
	@Query(nativeQuery = true, value= "SELECT * FROM LICENCIAS_USUARIO_EMPRESA A WHERE a.COD_USUARIO = :usuario")
	public List<LicenciasUsuarioEmpresa> findByUser(@Param("usuario") String usuario);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value= "DELETE FROM LICENCIAS_USUARIO_EMPRESA WHERE  COD_USUARIO = :usuario AND COD_CONTRATO = :ID ")
	public void deleteByidAndUser(@Param("usuario") String usuario,@Param("ID") Long ID);
}
