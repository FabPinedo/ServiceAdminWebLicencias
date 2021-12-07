package com.aquarius.app.models.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IMaeFuncionDao;
import com.aquarius.app.models.entity.MaeFuncion;
import com.aquarius.app.models.service.IMaeFuncionService;

@Service
public class MaeFuncionServiceImpl implements IMaeFuncionService{
	
	@Autowired
	private IMaeFuncionDao funcionDao;

	@Override
	public List<MaeFuncion> findByUsuario(String usuario) {
		return funcionDao.findByUsuario(usuario);
	}

	@Override
	public List<MaeFuncion> findByGrupo(String usuario, Long codgrupo) {
		return funcionDao.findByGrupo(usuario, codgrupo);
	}

	@Override
	public List<MaeFuncion> findByFuncionSup(String usuario, Long codfunsup) {
		return funcionDao.findByFuncionSup(usuario, codfunsup);
	}

	@Override
	public MaeFuncion findById(Long id) {
		// TODO Auto-generated method stub
		return funcionDao.findById(id).orElse(null);
	}

	@Override
	public List<MaeFuncion> findByGrupoDisp(Long id) {
		// TODO Auto-generated method stub
		return funcionDao.findByGrupoDisp(id);
	}

	@Override
	public List<MaeFuncion> findByGrupoAsig(Long id) {
		// TODO Auto-generated method stub
		return funcionDao.findByGrupoAsig(id);
	}

	@Override
	@Transactional
	public int disableFuncion(Long id) {
		// TODO Auto-generated method stub
		return funcionDao.disableFuncion(id);
	}

	@Override
	@Transactional
	public int enableFuncion(Long id) {
		// TODO Auto-generated method stub
		return funcionDao.enableFuncion(id);
	}

	@Override
	public MaeFuncion save(MaeFuncion entity) {
		// TODO Auto-generated method stub
		return funcionDao.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		funcionDao.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteByCodgrupo(Long id) {
		// TODO Auto-generated method stub
		funcionDao.deleteByCodgrupo(id);
	}

	@Override
	public List<MaeFuncion> findAllFuncionByUsuarioAndURl(String usuario, String desurl) {
		// TODO Auto-generated method stub
		return funcionDao.findAllFuncionByUsuarioAndURl(usuario, desurl);
	}



}
