package com.aquarius.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.aquarius.app.models.entity.Perfil;

public interface IPerfilService {
	public List<Perfil> findAll();

	public Perfil SavePerfil(Perfil perfil);

	public void deletePerfil(Long id);

	public Perfil findById(Long id);
	
	public Page<Perfil> findAll(Pageable pageable);
	
}
