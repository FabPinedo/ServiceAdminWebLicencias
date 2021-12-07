package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IMaePerfilDao;
import com.aquarius.app.models.entity.MaePerfil;
import com.aquarius.app.models.service.IMaePerfilService;

@Service
public class MaePerfilServiceImpl implements IMaePerfilService{
	
	@Autowired
	private IMaePerfilDao pefilDao;

	@Override
	public List<MaePerfil> findAll() {
		return (List<MaePerfil>) pefilDao.findAll();
	}

	@Override
	public MaePerfil findById(Long codperfil) {
		return pefilDao.findById(codperfil).orElse(null);
	}

	@Override
	public MaePerfil save(MaePerfil perfil) {
		return pefilDao.save(perfil);
	}

	@Override
	public MaePerfil findByUsuario(String usuario) {
		return pefilDao.findByUsuario(usuario);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		pefilDao.deleteById(id);
	}

}
