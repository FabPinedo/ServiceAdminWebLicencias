package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IPerfilDao;
import com.aquarius.app.models.entity.Perfil;
import com.aquarius.app.models.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService {
	@Autowired
	private IPerfilDao perfildao;
	@Override
	public List<Perfil> findAll() {
		// TODO Auto-generated method stub
		return perfildao.findAll();
	}

	@Override
	public Perfil SavePerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return perfildao.save(perfil);
	}

	@Override
	public void deletePerfil(Long id) {
		// TODO Auto-generated method stub
		perfildao.deleteById(id);
	}

	@Override
	public Perfil findById(Long id) {
		// TODO Auto-generated method stub
		return perfildao.findById(id).orElse(null);
	}

	@Override
	public Page<Perfil> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return perfildao.findAll(pageable);
	}

}
