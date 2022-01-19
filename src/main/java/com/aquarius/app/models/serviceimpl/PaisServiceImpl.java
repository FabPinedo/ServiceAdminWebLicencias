package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IPaisesDao;
import com.aquarius.app.models.dao.ISedeDao;
import com.aquarius.app.models.entity.Pais;
import com.aquarius.app.models.entity.Sede;
import com.aquarius.app.models.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService {
	@Autowired
	private IPaisesDao paisdao;
	
	@Override
	public List<Pais> findAll() {
		// TODO Auto-generated method stub
		return paisdao.findAll();
	}

}
