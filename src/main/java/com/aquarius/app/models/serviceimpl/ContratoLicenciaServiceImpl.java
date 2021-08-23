package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aquarius.app.models.dao.IContratoLicenciaDao;
import com.aquarius.app.models.entity.ContratoLicencia;

import com.aquarius.app.models.service.IContratoLicenciaService;
import com.aquarius.app.util.JwtUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class ContratoLicenciaServiceImpl implements IContratoLicenciaService{
	
	@Autowired
	private IContratoLicenciaDao licenciaDao;
	

	@Override
	@Transactional(readOnly = true)
	public List<ContratoLicencia> findAll() {
		// TODO Auto-generated method stub
		return  (List<ContratoLicencia>) licenciaDao.findAll();
		}
	@Override
	public Page<ContratoLicencia> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return licenciaDao.findAll(pageable);
	}
	
	@Override
	public String exportJSONfindByCodigo(String token) {
		ContratoLicencia licencia = licenciaDao.findByCodigo(token);
		ContratoLicencia jwtLicencia = new ContratoLicencia();
		JwtUtil jwt = new JwtUtil();
		if(licencia != null) {
			jwtLicencia = jwt.JwtConvert(licencia);
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		String customerInJson = gson.toJson(jwtLicencia);
		return customerInJson;
	}

	@Override
	@Transactional
	public String generateToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ContratoLicencia findById(Long id) {
		// TODO Auto-generated method stub
		return licenciaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public ContratoLicencia findByCodigo(String token) {
		// TODO Auto-generated method stub
		return licenciaDao.findByCodigo(token);
	}
	
	@Override
	@Transactional
	public void deleteContrato(long id) {
		// TODO Auto-generated method stub
		licenciaDao.deleteById(id);
	}
	@Override
	@Transactional
	public ContratoLicencia SaveContrato(ContratoLicencia contrato) {
		// TODO Auto-generated method stub
		return licenciaDao.save(contrato);
	}
	@Override
	public Page<ContratoLicencia> findAllByEstado(Pageable pageable) {
		// TODO Auto-generated method stub
		return licenciaDao.findByEstado(pageable);
	}
	@Override
	public Page<ContratoLicencia> findByRazonsocial(String razonsocial, Pageable pageable) {
		// TODO Auto-generated method stub
		return licenciaDao.findByRazonsocial(razonsocial, pageable);
	}
	@Override
	public Page<ContratoLicencia> findByRuc(String ruc, Pageable pageable) {
		// TODO Auto-generated method stub
		return licenciaDao.findByRUC(ruc, pageable);
	}

	





}
