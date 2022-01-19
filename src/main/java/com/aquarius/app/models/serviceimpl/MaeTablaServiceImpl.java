package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IMaeTablaDao;
import com.aquarius.app.models.entity.MaeTabla;
import com.aquarius.app.models.service.IMaeTablaService;

@Service
public class MaeTablaServiceImpl implements IMaeTablaService{
	@Autowired
	private IMaeTablaDao tablaDao;

	@Override
	public List<MaeTabla> findAll() {
		// TODO Auto-generated method stub
		return tablaDao.findAllOrderPorNombre();
	}

	@Override
	public MaeTabla save(MaeTabla maetabla) {
		// TODO Auto-generated method stub
		return tablaDao.save(maetabla);
	}

	@Override
	public MaeTabla findById(String codigo) {
		// TODO Auto-generated method stub
		return tablaDao.findById(codigo).orElse(null);
	}

	@Override
	public void deleteById(String codigo) {
		// TODO Auto-generated method stub
		tablaDao.deleteById(codigo);
	}

	@Override
	public int countByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return tablaDao.countByCodigo(codigo);
	}
}
