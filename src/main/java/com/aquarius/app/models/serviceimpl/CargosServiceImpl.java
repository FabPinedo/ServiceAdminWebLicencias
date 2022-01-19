package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.ICargosDao;
import com.aquarius.app.models.entity.Cargos;
import com.aquarius.app.models.service.ICargosService;

@Service
public class CargosServiceImpl implements ICargosService {
	
	@Autowired
	private ICargosDao cargoDao;
	
	@Override
	public List<Cargos> findAll() {
		// TODO Auto-generated method stub
		return cargoDao.findAll();
	}

	@Override
	public List<Cargos> findAllActivos() {
		// TODO Auto-generated method stub
		return cargoDao.ListadoActivos();
	}

	@Override
	public Cargos saveCargo(Cargos cargo) {
		// TODO Auto-generated method stub
		return cargoDao.save(cargo);
	}

	@Override
	public void deleteCargo(String codcargo) {
		// TODO Auto-generated method stub
		cargoDao.deleteById(codcargo);
	}

	@Override
	public Cargos findById(String codcargo) {
		// TODO Auto-generated method stub
		return cargoDao.getById(codcargo);
	}

}
