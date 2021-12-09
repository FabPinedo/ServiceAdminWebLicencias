package com.aquarius.app.models.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IMaeAccesosResDao;
import com.aquarius.app.models.entity.MaeAccesosRes;
import com.aquarius.app.models.service.IMaeAccesosResService;

@Service
public class MaeAccesosResServiceImpl implements IMaeAccesosResService{
	
	@Autowired
	private IMaeAccesosResDao maeAccesoResDao;

	@Override
	public List<MaeAccesosRes> findByUsuario(String usuario) {
		return maeAccesoResDao.findByUsuario(usuario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		maeAccesoResDao.deleteById(id);
	}

	@Override
	public MaeAccesosRes save(MaeAccesosRes acceso) {
		return maeAccesoResDao.save(acceso);
	}

}
