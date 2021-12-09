package com.aquarius.app.models.service;

import java.util.List;
import com.aquarius.app.models.entity.MaePerfilGrupoFuncion;

public interface IMaePerfilGrupoFuncionService {
	
	public List<MaePerfilGrupoFuncion> findAll();
	public MaePerfilGrupoFuncion findById(Long id);
	public void deleteById(Long id);
	public MaePerfilGrupoFuncion save(MaePerfilGrupoFuncion entity);
	public List<MaePerfilGrupoFuncion> findByPerfil(Long codperfil);
	
}
