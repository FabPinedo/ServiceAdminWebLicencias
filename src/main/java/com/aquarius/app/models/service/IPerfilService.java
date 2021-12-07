package com.aquarius.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.aquarius.app.models.entity.MaePerfil;

public interface IPerfilService {
	public List<MaePerfil> findAll();

	public MaePerfil SavePerfil(MaePerfil perfil);

	public void deletePerfil(Long id);

	public MaePerfil findById(Long id);
	
	public Page<MaePerfil> findAll(Pageable pageable);
	
}
