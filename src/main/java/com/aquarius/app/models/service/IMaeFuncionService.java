package com.aquarius.app.models.service;

import java.util.List;

import com.aquarius.app.models.entity.MaeFuncion;

public interface IMaeFuncionService {
	
	public List<MaeFuncion> findByUsuario(String usuario);
	public List<MaeFuncion> findByGrupo(String usuario, Long codgrupo);
	public List<MaeFuncion> findByFuncionSup(String usuario, Long codfunsup);
	public List<MaeFuncion> findAllFuncionByUsuarioAndURl(String usuario, String desurl);
	public MaeFuncion findById(Long id);
	public List<MaeFuncion> findByGrupoDisp(Long id);
	public List<MaeFuncion> findByGrupoAsig(Long id);
	public int disableFuncion(Long id);
	public int enableFuncion(Long id);
	public MaeFuncion save(MaeFuncion entity);
	public void deleteById(Long id);
	public void deleteByCodgrupo(Long id);
}
