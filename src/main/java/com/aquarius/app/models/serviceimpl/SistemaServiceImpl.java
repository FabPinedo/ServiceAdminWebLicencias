package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aquarius.app.models.dao.ISistemaDao;
import com.aquarius.app.models.entity.Sistema;
import com.aquarius.app.models.service.ISistemaService;

@Service
public class SistemaServiceImpl implements ISistemaService{
	
	@Autowired
	private ISistemaDao sistemaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Sistema> findAll() {
		// TODO Auto-generated method stub
		return (List<Sistema>)sistemaDao.findAll();
	}
	@Override
	public Page<Sistema> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return sistemaDao.findAll(pageable);
	}
	@Override
	@Transactional
	public Sistema SaveSistema(Sistema sistema) {
		// TODO Auto-generated method stub
		return sistemaDao.save(sistema);
	
	}

	@Override
	@Transactional
	public void deleteSistema(long id) {
		// TODO Auto-generated method stub
		sistemaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Sistema findById(long id) {
		// TODO Auto-generated method stub
		return sistemaDao.findById(id).orElse(null);
	}
	@Override
	public Page<Sistema> findAllEstado(Pageable pageable) {
		// TODO Auto-generated method stub
		return sistemaDao.findByEstado(pageable);
	}
	@Override
	public List<Sistema> ListadoActivo() {
		// TODO Auto-generated method stub
		return sistemaDao.ListadoActivo();
	}


	

}
