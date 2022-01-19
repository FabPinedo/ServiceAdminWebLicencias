package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IPaisesDao;
import com.aquarius.app.models.dao.IUbigeoDao;
import com.aquarius.app.models.entity.Pais;
import com.aquarius.app.models.entity.Ubigeo;
import com.aquarius.app.models.service.IPaisService;
import com.aquarius.app.models.service.IUbigeoService;

@Service
public class UbigeoServiceImpl implements IUbigeoService {
	@Autowired
	private IUbigeoDao ubigeoDao;
	
	@Override
	public List<Ubigeo> findAllDepartamentos() {
		// TODO Auto-generated method stub
		return ubigeoDao.findAllDepartamentos();
	}

	@Override
	public List<Ubigeo> findAllbyProvincias(String codubigeo) {
		// TODO Auto-generated method stub
		return ubigeoDao.findAllprovincias(codubigeo);
	}

	@Override
	public List<Ubigeo> findAllbydistrios(String codUbigeo) {
		// TODO Auto-generated method stub
		return ubigeoDao.findAllDistritos(codUbigeo);
	}

}