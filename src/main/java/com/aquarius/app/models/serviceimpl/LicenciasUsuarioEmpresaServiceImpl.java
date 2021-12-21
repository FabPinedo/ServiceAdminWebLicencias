package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.ILicenciasUsuarioEmpresaDao;
import com.aquarius.app.models.entity.LicenciasUsuarioEmpresa;
import com.aquarius.app.models.service.ILicenciasUsuarioEmpresaService;

@Service
public class LicenciasUsuarioEmpresaServiceImpl implements ILicenciasUsuarioEmpresaService {

	@Autowired
	private ILicenciasUsuarioEmpresaDao userEmpresaDao;
	
	@Override
	public List<LicenciasUsuarioEmpresa> findAll() {
		// TODO Auto-generated method stub
		return userEmpresaDao.findAll();
	}

	@Override
	public LicenciasUsuarioEmpresa SaveLicenciasUsuarioEmpresa(LicenciasUsuarioEmpresa userempresa) {
		// TODO Auto-generated method stub
		return userEmpresaDao.save(userempresa);
	}

	@Override
	public void deleteLicenciasUsuarioEmpresa(long id) {
		// TODO Auto-generated method stub
		userEmpresaDao.deleteById(id);
		
	}

	@Override
	public List<LicenciasUsuarioEmpresa> findLicenciasByUser(String usuario) {
		// TODO Auto-generated method stub
		return userEmpresaDao.findByUser(usuario);
	}

	@Override
	public void deleteObjeto(String codusuario, Long id) {
		// TODO Auto-generated method stub
		 userEmpresaDao.deleteByidAndUser(codusuario, id);
	}

}
