package com.aquarius.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.aquarius.app.models.entity.MaePerfil;

public interface IMaePerfilDao extends CrudRepository<MaePerfil, Long>{
	
	@Query(nativeQuery = true, value= "SELECT a.* FROM Mae_Perfil a inner join Mae_Usuario b on a.id = b.cod_perfil where b.cod_usuario = :usuario")
	public MaePerfil findByUsuario(@Param("usuario") String usuario);
}
