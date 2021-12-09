package com.aquarius.app.models.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IMaeFuncionGrupoDao;
import com.aquarius.app.models.entity.MaeFuncionGrupo;
import com.aquarius.app.models.service.IMaeFuncionGrupoService;

@Service
public class MaeFuncionGrupoServiceImpl implements IMaeFuncionGrupoService{
	
	@Autowired
	private IMaeFuncionGrupoDao grupoDao;
	
	@Override
	public List<MaeFuncionGrupo> findByUsuario(String usuario) {
		return grupoDao.findByUsuario(usuario);
	}

	@Override
	public List<MaeFuncionGrupo> findByPerfil(Long codperfil) {
		// TODO Auto-generated method stub
		return grupoDao.findByPerfil(codperfil);
	}

	@Override
	public List<MaeFuncionGrupo> findAll() {
		// TODO Auto-generated method stub
		return (List<MaeFuncionGrupo>) grupoDao.findAll();
	}

	@Override
	public MaeFuncionGrupo save(MaeFuncionGrupo entity) {
		// TODO Auto-generated method stub
		return grupoDao.save(entity);
	}

	@Override
	public MaeFuncionGrupo findById(Long id) {
		// TODO Auto-generated method stub
		return grupoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteBy(Long id) {
		// TODO Auto-generated method stub
		grupoDao.deleteById(id);
	}

}
