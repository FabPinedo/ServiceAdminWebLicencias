package com.aquarius.app.models.service;

import java.util.List;
import com.aquarius.app.models.entity.MaePerfil;

public interface IMaePerfilService {
	
	public List<MaePerfil> findAll();
	public MaePerfil findById(Long codperfil);
	public MaePerfil findByUsuario(String usuario);
	public MaePerfil save(MaePerfil perfil);
	public void deleteById(Long id);
}
