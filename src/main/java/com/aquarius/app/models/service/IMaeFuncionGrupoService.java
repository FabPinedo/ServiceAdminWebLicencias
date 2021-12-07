package com.aquarius.app.models.service;

import java.util.List;

import com.aquarius.app.models.entity.MaeFuncionGrupo;

public interface IMaeFuncionGrupoService {
	
	public List<MaeFuncionGrupo> findByUsuario(String usuario);
	public List<MaeFuncionGrupo> findByPerfil(Long codperfil);
	public List<MaeFuncionGrupo> findAll();
	public MaeFuncionGrupo save(MaeFuncionGrupo entity);
	public MaeFuncionGrupo findById(Long id);
	public void deleteBy(Long id);

}
