package com.aquarius.app.models.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aquarius.app.models.dao.IEmpresaDao;
import com.aquarius.app.models.entity.Empresa;
import com.aquarius.app.models.service.IEmpresaService;


@Service
public class EmpresaServiceImpl implements IEmpresaService {
	
	@Autowired
	private IEmpresaDao empresaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return  (List<Empresa>) empresaDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Empresa> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return empresaDao.findAll(pageable);
	}
	
	@Override
	@Transactional
	public Empresa SaveEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		return empresaDao.save(empresa);
	}

	@Override
	@Transactional
	public void deleteEmpresa(long id) {
		// TODO Auto-generated method stub
		empresaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa findById(long id) {
		// TODO Auto-generated method stub
		return empresaDao.findById(id).orElse(null);
	}

	@Override
	public Page< Empresa> findByCodigoruc(String ruc,Pageable pageable) {
		// TODO Auto-generated method stub
		return empresaDao.findByRuc(ruc, pageable);
	}

	@Override
	public Page< Empresa> findByRazonsocial(String razonsocial,Pageable pageable) {
		return empresaDao.findByRazonsocial(razonsocial, pageable);
	}

	@Override
	public Page<Empresa> findAllEstado(Pageable pageable) {
		return empresaDao.findByEstado(pageable);
	}

	@Override
	public List<Empresa> findListadoRazonsocial(String razon) {
		// TODO Auto-generated method stub
		return empresaDao.findByRazonsocialListado(razon);
	}

	@Override
	public List<Empresa> findListadoRuc(String ruc) {
		// TODO Auto-generated method stub
		return empresaDao.findByRucListado(ruc);
	}

	@Override
	public List<Empresa> ListadoActivos() {
		// TODO Auto-generated method stub
		return empresaDao.ListadoActivos();
	}

	

	





	
	


}
