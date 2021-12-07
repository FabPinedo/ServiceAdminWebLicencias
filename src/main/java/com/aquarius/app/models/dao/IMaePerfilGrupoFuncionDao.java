package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.aquarius.app.models.entity.MaePerfilGrupoFuncion;

public interface IMaePerfilGrupoFuncionDao extends CrudRepository<MaePerfilGrupoFuncion, Long>{
	
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_PERFIL_GRUPO_FUNCION A WHERE A.COD_PERFIL = :codperfil")
	public List<MaePerfilGrupoFuncion> findByPerfil(@Param("codperfil") Long codperfil);

}
