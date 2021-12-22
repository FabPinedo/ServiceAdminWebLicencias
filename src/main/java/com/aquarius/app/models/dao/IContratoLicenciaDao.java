package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.aquarius.app.models.entity.ContratoLicencia;

public interface IContratoLicenciaDao extends JpaRepository<ContratoLicencia, Long>{
	@Query(nativeQuery = true, value= "SELECT A.*"
			+ " FROM CONTRATO_LICENCIA A "
			+ "INNER JOIN LICENCIA_EMPRESA B "
			+ "ON B.ID=A.COD_EMPRESA "
			+ "WHERE B.RAZON_SOCIAL LIKE %:razonsocial%")
	public List<ContratoLicencia> findByRazonsocial(@Param("razonsocial") String razonsocial);
	
	@Query(nativeQuery = true, value= "SELECT A.*"
			+ " FROM CONTRATO_LICENCIA A "
			+ "INNER JOIN LICENCIA_EMPRESA B "
			+ "ON B.ID=A.COD_EMPRESA "
			+ "WHERE B.CODIGO_RUC LIKE %:ruc%")
	public List<ContratoLicencia> findByRUC(@Param("ruc") String ruc);
	
	@Query(nativeQuery = true, value= "SELECT A.ID,A.COD_SISTEMA,A.COD_EMPRESA,A.COD_CONEXION,A.FECHA_INI_CONTRATO,A.FECHA_FIN_CONTRATO,A.CANT_USUARIOS,A.CANT_ACTIVOS,A.ESTADO,A.TOKEN FROM CONTRATO_LICENCIA A \r\n"
			+ "INNER JOIN LICENCIAS_USUARIO_EMPRESA B  ON B.COD_CONTRATO=A.ID  \r\n"
			+ "INNER JOIN MAE_USUARIO C ON B.COD_USUARIO=C.COD_USUARIO\r\n"
			+"WHERE C.COD_USUARIO=:usuario")
	public List<ContratoLicencia> findbyUser(@Param("usuario") String usuario);
	
	@Query(nativeQuery = true, value= "SELECT * FROM CONTRATO_LICENCIA A WHERE A.TOKEN = :token")
	public ContratoLicencia findByCodigo(@Param("token") String token);
	
	@Query(nativeQuery = true, value= "SELECT * FROM CONTRATO_LICENCIA A WHERE A.ESTADO =0")
	public Page<ContratoLicencia> findByEstado(Pageable pageable);
	@Query(nativeQuery = true, value= "SELECT * FROM CONTRATO_LICENCIA A WHERE A.ESTADO=0")
	public List<ContratoLicencia> ListadoActivos();
	@Query(nativeQuery = true, value= "SELECT * FROM CONTRATO_LICENCIA A WHERE A.COD_EMPRESA=:id")
	public List<ContratoLicencia>findbyIDEmpresa(@Param("id") Long id);
}
