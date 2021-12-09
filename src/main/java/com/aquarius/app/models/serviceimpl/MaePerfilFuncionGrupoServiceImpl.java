package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IMaePerfilGrupoFuncionDao;
import com.aquarius.app.models.entity.MaePerfilGrupoFuncion;
import com.aquarius.app.models.service.IMaePerfilGrupoFuncionService;

@Service
public class MaePerfilFuncionGrupoServiceImpl implements IMaePerfilGrupoFuncionService {
	
	@Autowired
	private IMaePerfilGrupoFuncionDao grupoDao;

	@Override
	public List<MaePerfilGrupoFuncion> findAll() {
		// TODO Auto-generated method stub
		return (List<MaePerfilGrupoFuncion>) grupoDao.findAll();
	}

	@Override
	public MaePerfilGrupoFuncion findById(Long id) {
		// TODO Auto-generated method stub
		return grupoDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		grupoDao.deleteById(id);
	}

	@Override
	public MaePerfilGrupoFuncion save(MaePerfilGrupoFuncion entity) {
		// TODO Auto-generated method stub
		return grupoDao.save(entity);
	}

	@Override
	public List<MaePerfilGrupoFuncion> findByPerfil(Long codperfil) {
		// TODO Auto-generated method stub
		return grupoDao.findByPerfil(codperfil);
	}

}
