package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IMaestroUbicacionDao;
import com.aquarius.app.models.entity.MaestroUbicacion;
import com.aquarius.app.models.service.IMaestroUbicacionService;

@Service
public class MaestroUbicacionServiceImpl implements IMaestroUbicacionService {

	@Autowired
	private IMaestroUbicacionDao ubicaciondao;
	
	
	@Override
	public List<MaestroUbicacion> findAll() {
		// TODO Auto-generated method stub
		return ubicaciondao.findAll();
	}

	@Override
	public List<MaestroUbicacion> findAllbyEmpresa(Long codempresa) {
		// TODO Auto-generated method stub
		return ubicaciondao.findAllByCodigo(codempresa);
	}

	@Override
	public MaestroUbicacion saveUbicacion(MaestroUbicacion ubicacion) {
		// TODO Auto-generated method stub
		return ubicaciondao.save(ubicacion);
	}

	@Override
	public void deleteUbicacion(String codubicacion) {
		// TODO Auto-generated method stub
		ubicaciondao.deleteById(codubicacion);
	}

	@Override
	public MaestroUbicacion findById(String codubicacion) {
		// TODO Auto-generated method stub
		return ubicaciondao.getById(codubicacion);
		
	}

}
