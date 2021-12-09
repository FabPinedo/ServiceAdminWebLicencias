package com.aquarius.app.models.service;

import java.util.List;
import com.aquarius.app.models.entity.MaeAccesosRes;

public interface IMaeAccesosResService {
	
	public List<MaeAccesosRes> findByUsuario(String usuario);
	public void deleteById(Long id);
	public MaeAccesosRes save(MaeAccesosRes acceso);
}
