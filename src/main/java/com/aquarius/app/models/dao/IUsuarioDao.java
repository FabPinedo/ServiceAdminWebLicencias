package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.aquarius.app.models.entity.MaeUsuario;

public interface IUsuarioDao extends JpaRepository<MaeUsuario, String>{
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_USUARIO A \r\n"
			+ "INNER JOIN LICENCIAS_USUARIO_EMPRESA B  ON B.COD_USUARIO=A.COD_USUARIO \r\n"
			+ "INNER JOIN CONTRATO_LICENCIA C ON B.COD_CONTRATO=C.ID\r\n"
			+ "INNER JOIN LICENCIA_EMPRESA D ON D.ID=C.COD_EMPRESA\r\n"
			+ " WHERE D.RAZON_SOCIAL like %:razonsocial%")
	public List<MaeUsuario> findByRazonsocial(@Param("razonsocial") String razonsocial);
	
	
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_USUARIO A \r\n"
			+ "INNER JOIN LICENCIAS_USUARIO_EMPRESA B  ON B.COD_USUARIO=A.COD_USUARIO \r\n"
			+ "INNER JOIN CONTRATO_LICENCIA C ON B.COD_CONTRATO=C.ID\r\n"
			+ "INNER JOIN LICENCIA_EMPRESA D ON D.ID=C.COD_EMPRESA\r\n"
			+ "WHERE D.CODIGO_RUC LIKE %:ruc%")
	public List<MaeUsuario> findByRuc(@Param("ruc") String ruc);
	
	
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_USUARIO A \r\n"
			+ "WHERE A.IND_BAJA =1")
	public List<MaeUsuario> findByEstado();
	
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_USUARIO A \r\n"
			+ "WHERE A.NOM_USUARIO LIKE %:usuario%")
	public List<MaeUsuario> findByName(@Param("usuario") String usuario);
	
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_USUARIO A \r\n"
			+ "INNER JOIN LICENCIAS_USUARIO_EMPRESA B  ON B.COD_USUARIO=A.COD_USUARIO \r\n"
			+ "INNER JOIN CONTRATO_LICENCIA C ON B.COD_CONTRATO=C.ID\r\n"
			+ "INNER JOIN LICENCIA_EMPRESA D ON D.ID=C.COD_EMPRESA\r\n"
			+"WHERE A.COD_USUARIO=:usuario AND A.DES_PASSWORD=:pass ")
	public MaeUsuario validarUser(@Param("usuario") String usuario,@Param("pass") String pass);
	
}
