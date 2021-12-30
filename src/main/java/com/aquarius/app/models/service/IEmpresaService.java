package com.aquarius.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aquarius.app.models.entity.Empresa;



public interface IEmpresaService {
	public List<Empresa> findAll();

	public Empresa SaveEmpresa(Empresa empresa);

	public void deleteEmpresa(long id);

	public Empresa findById(long id);
	
	public Page< Empresa> findByCodigoruc(String ruc,Pageable pageable);
	
	public Page< Empresa> findByRazonsocial(String razonsocial,Pageable pageable);
	
	public Page<Empresa> findAll(Pageable pageable);
	public Page<Empresa> findAllEstado(Pageable pageable);
	public List<Empresa> findListadoRazonsocial(String razon);
	public List<Empresa> findListadoRuc(String ruc);
	public List<Empresa> findListadoRazonsocialActivos(String razon);
	public List<Empresa> findListadoRucActivos(String ruc);
	public List<Empresa> ListadoActivos();
}
