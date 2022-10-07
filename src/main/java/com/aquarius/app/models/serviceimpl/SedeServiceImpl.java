package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.ISedeDao;
import com.aquarius.app.models.dao.ISistemaDao;
import com.aquarius.app.models.entity.Sede;
import com.aquarius.app.models.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService {

	@Autowired
	private ISedeDao sedeDao;
	
	@Override
	public List<Sede> findAll() {
		// TODO Auto-generated method stub
		return sedeDao.findAll();
	}

	@Override
	public Sede saveSede(Sede sede) {
		// TODO Auto-generated method stub
		return sedeDao.save(sede);
	}

	@Override
	public void deleteSede(String codsede) {
		// TODO Auto-generated method stub
		sedeDao.deleteById(codsede);
	}

	@Override
	public Sede findById(String codsede) {
		// TODO Auto-generated method stub
		return sedeDao.findById(codsede).orElse(null);
	}

	@Override
	public List<Sede> findAllbyEmpresa(Long id) {
		// TODO Auto-generated method stub
		return sedeDao.findAllByCodigo(id);
	}

}
