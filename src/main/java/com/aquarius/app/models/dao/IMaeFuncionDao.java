package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.aquarius.app.models.entity.MaeFuncion;

public interface IMaeFuncionDao extends CrudRepository<MaeFuncion, Long>{
	
	@Query(nativeQuery = true, value= "SELECT D.* FROM MAE_PERFIL A \r\n"
			+ "	INNER JOIN MAE_PERFIL_GRUPO_FUNCION B ON A.ID  = B.COD_PERFIL\r\n"
			+ "	INNER JOIN MAE_FUNCION_GRUPO C ON C.ID = B.COD_GRUPO\r\n"
			+ "	INNER JOIN MAE_FUNCION D ON D.COD_GRUPO = C.ID\r\n"
			+ "	INNER JOIN MAE_USUARIO E ON A.ID = E.COD_PERFIL\r\n"
			+ "WHERE D.ID NOT IN (SELECT COD_FUNCION FROM MAE_ACCESOS_RES F WHERE F.COD_USUARIO = :usuario) AND E.COD_USUARIO = :usuario")
	public List<MaeFuncion> findByUsuario(@Param("usuario") String usuario);
	
	@Query(nativeQuery = true, value="SELECT D.* FROM MAE_PERFIL A\r\n"
			+ "	INNER JOIN MAE_PERFIL_GRUPO_FUNCION B ON A.ID = B.COD_PERFIL\r\n"
			+ "	INNER JOIN MAE_FUNCION_GRUPO C ON C.ID = B.COD_GRUPO\r\n"
			+ "	INNER JOIN MAE_FUNCION D ON D.COD_GRUPO = C.ID\r\n"
			+ "	INNER JOIN MAE_USUARIO E ON A.ID = E.COD_PERFIL\r\n"
			+ "	WHERE \r\n"
			+ "	D.ID NOT IN (SELECT COD_FUNCION FROM MAE_ACCESOS_RES F WHERE F.COD_USUARIO = :usuario)\r\n"
			+ "	AND E.COD_USUARIO = :usuario AND D.COD_GRUPO = :codgrupo")
	public List<MaeFuncion> findByGrupo(@Param("usuario") String usuario, @Param("codgrupo") Long codgrupo);
	
	@Query(nativeQuery = true, value="SELECT D.* FROM MAE_PERFIL A\r\n"
			+ "	INNER JOIN MAE_PERFIL_GRUPO_FUNCION B ON A.ID = B.COD_PERFIL\r\n"
			+ "	INNER JOIN MAE_FUNCION_GRUPO C ON C.ID = B.COD_GRUPO\r\n"
			+ "	INNER JOIN MAE_FUNCION D ON D.COD_GRUPO = C.ID\r\n"
			+ "	INNER JOIN MAE_USUARIO E ON A.ID = E.COD_PERFIL\r\n"
			+ "	WHERE \r\n"
			+ "	D.ID NOT IN (SELECT COD_FUNCION FROM MAE_ACCESOS_RES F WHERE F.COD_USUARIO = :usuario)\r\n"
			+ "	AND E.COD_USUARIO = :usuario AND D.COD_FUNCION_SUP = :codfunsup")
	public List<MaeFuncion> findByFuncionSup(@Param("usuario") String usuario, @Param("codfunsup") Long codfunsup);
	
	
	
	/*MENU DISPONIBLE POR USUARIO ACCESO*/
	@Query(nativeQuery = true, value="SELECT C.* \r\n"
			+ "FROM MAE_PERFIL A \r\n"
			+ "	INNER JOIN MAE_PERFIL_GRUPO_FUNCION B ON A.ID = B.COD_PERFIL\r\n"
			+ "	INNER JOIN MAE_FUNCION C ON B.COD_GRUPO = C.COD_GRUPO\r\n"
			+ "	INNER JOIN MAE_USUARIO D ON A.ID = D.COD_PERFIL\r\n"
			+ "WHERE C.ID NOT IN (SELECT E.COD_FUNCION FROM MAE_ACCESOS_RES E WHERE E.COD_USUARIO = :usuario) AND\r\n"
			+ "D.COD_USUARIO = :usuario AND C.DES_URL = :desurl")
	public List<MaeFuncion> findAllFuncionByUsuarioAndURl(@Param("usuario") String usuario, @Param("desurl") String desurl);
	
	
	/*SUBMENU DISPONIBLES*/ 
	@Query(nativeQuery = true, value="SELECT A.* FROM MAE_FUNCION A \r\n"
			+ "WHERE A.COD_GRUPO NOT IN (SELECT B.ID FROM MAE_FUNCION_GRUPO B WHERE B.ID = :id ) OR A.IND_BAJA = '0'")
	public List<MaeFuncion> findByGrupoDisp(@Param("id") Long id);
	
	/*SUBMENU ASIGNADO POR GRUPO*/
	@Query(nativeQuery = true, value="SELECT A.* FROM MAE_FUNCION A WHERE A.COD_GRUPO = :id")
	public List<MaeFuncion> findByGrupoAsig(@Param("id") Long id);
	
	@Modifying
	@Query(nativeQuery = true, value="UPDATE MAE_FUNCION  set IND_BAJA = 0 where id = :id")
	public int disableFuncion(@Param("id") Long id);
	
	@Modifying
	@Query(nativeQuery = true, value="UPDATE MAE_FUNCION set IND_BAJA = 1 where id = :id")
	public int enableFuncion(@Param("id") Long id);
	
	public void deleteById(Long id);
	
	public void deleteByCodgrupo(Long id);
	
	
}
