package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.aquarius.app.models.entity.MaeFuncionGrupo;

public interface IMaeFuncionGrupoDao extends CrudRepository<MaeFuncionGrupo, Long>{
	
	@Query(nativeQuery = true, value= "SELECT c.* FROM MAE_PERFIL A \r\n"
			+ "	INNER JOIN MAE_PERFIL_GRUPO_FUNCION B ON A.ID  = B.COD_PERFIL\r\n"
			+ "	INNER JOIN MAE_FUNCION_GRUPO C ON C.ID = B.COD_GRUPO\r\n"
			+ "	INNER JOIN MAE_USUARIO D ON D.COD_PERFIL = A.ID\r\n"
			+ "	WHERE D.COD_USUARIO = :usuario")
	public List<MaeFuncionGrupo> findByUsuario(@Param("usuario") String usuario);
	
	@Query(nativeQuery = true, value= "SELECT A.* FROM MAE_FUNCION_GRUPO A \r\n"
			+ "WHERE A.ID NOT IN (SELECT B.COD_GRUPO FROM MAE_PERFIL_GRUPO_FUNCION B WHERE COD_PERFIL = :codperfil)")
	public List<MaeFuncionGrupo> findByPerfil(@Param("codperfil") Long codperfil);
	
}
