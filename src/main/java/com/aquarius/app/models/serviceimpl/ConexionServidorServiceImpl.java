package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aquarius.app.models.dao.IConexionServidorDao;
import com.aquarius.app.models.entity.ConexionServidor;

import com.aquarius.app.models.service.IConexionServidorService;

@Service
public class ConexionServidorServiceImpl implements IConexionServidorService{

	@Autowired
	private IConexionServidorDao conexionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ConexionServidor> findAll() {
		// TODO Auto-generated method stub
		return  (List<ConexionServidor>) conexionDao.findAll();
	}
	@Override
		public Page<ConexionServidor> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return conexionDao.findAll(pageable);
		}
	@Override
	@Transactional
	public ConexionServidor SaveConexionServidor(ConexionServidor conexionServidor) {
		// TODO Auto-generated method stub
		return conexionDao.save(conexionServidor);
		
	}

	@Override
	@Transactional
	public void deleteConexionServidor(long id) {
		// TODO Auto-generated method stub
		conexionDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public ConexionServidor findById(long id) {
		// TODO Auto-generated method stub
		return conexionDao.findById(id).orElse(null);
	}
	@Override
	public Page<ConexionServidor> findByRazonsocial(String razonsocial, Pageable pageable) {
		// TODO Auto-generated method stub
		return conexionDao.findByRazonsocial(razonsocial, pageable);
	}
	@Override
	public Page<ConexionServidor> findByRuc(String ruc, Pageable pageable) {
		// TODO Auto-generated method stub
		return conexionDao.findByRUC(ruc, pageable);
	}
	@Override
	public List<ConexionServidor> findByIdEmpresa(long id) {
		// TODO Auto-generated method stub
		return conexionDao.findbyIdEmpresa(id);
	}

	

}
