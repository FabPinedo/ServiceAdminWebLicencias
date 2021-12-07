package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.aquarius.app.models.entity.MaeUsuario;
import com.aquarius.app.models.entity.face.IUsuarioFace;

public interface IMaeUsuarioDao extends CrudRepository<MaeUsuario, String>{
	
	@Query(nativeQuery = true, value= "SELECT a.cod_usuario as usuario, a.nom_usuario as nombre, a.cod_perfil as perfil, "
			+ "a.ind_baja as estado, a.SYNC_CCOSTOS as syncccostos, a.sync_tip_planilla as synctiplanilla, a.sync_areas as syncareas FROM mae_usuario a")
	public List<IUsuarioFace> findAllUsuarioFace();
	
	@Query("SELECT a FROM MaeUsuario a where usuario = :usuario")
	public MaeUsuario findByUsuario(@Param("usuario") String usuario);
	
	@Query(nativeQuery = true, value= "SELECT a.cod_usuario as usuario, a.nom_usuario as nombre, a.cod_perfil as perfil, a.ind_baja as estado, a.SYNC_CCOSTOS as syncccostos, a.sync_tip_planilla as synctiplanilla, a.sync_areas as syncareas FROM mae_usuario a where a.nom_usuario LIKE %:search%" )
	public List<IUsuarioFace> listUsuarioFaceByNombre(@Param(value="search") String search);
	
	@Query(nativeQuery = true, value= "SELECT a.cod_usuario as usuario, a.nom_usuario as nombre, a.cod_perfil as perfil, a.ind_baja as estado, a.SYNC_CCOSTOS as syncccostos, a.sync_tip_planilla as synctiplanilla, a.sync_areas as syncareas FROM mae_usuario a where a.cod_usuario = :usuario")
	public IUsuarioFace findUsuarioFaceByUsuario(@Param("usuario") String usuario);
	
	@Modifying
	@Query("UPDATE MaeUsuario a set a.estado = 0 where a.id = :usuario")
	public int disableUsuario(@Param("usuario") String usuario);
	
	@Modifying
	@Query("UPDATE MaeUsuario a set a.estado = 1 where a.id = :usuario")
	public int enableUsuario(@Param("usuario") String usuario);
	
	@Query("SELECT count(a) FROM MaeUsuario a where a.usuario = :usuario")
	public int findCountUsuario(@Param("usuario") String usuario);
	
}
