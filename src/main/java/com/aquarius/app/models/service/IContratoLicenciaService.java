package com.aquarius.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.aquarius.app.models.entity.ContratoLicencia;



public interface IContratoLicenciaService {
	
	public ContratoLicencia findById(Long id);
	public String exportJSONfindByCodigo(String token);
	public ContratoLicencia findByCodigo(String token);
	public String generateToken();
	public List<ContratoLicencia> findAll();
	public void deleteContrato(long id);
	public ContratoLicencia SaveContrato(ContratoLicencia contrato);
	public Page<ContratoLicencia> findAll(Pageable pageable);
	public Page<ContratoLicencia> findAllByEstado(Pageable pageable);
	/*public Page<ContratoLicencia> findByRazonsocial(String razonsocial,Pageable pageable);
	public Page<ContratoLicencia> findByRuc(String ruc,Pageable pageable);*/
	public List<ContratoLicencia> findByRazonsocial(String razonsocial);
	public List<ContratoLicencia> findByRuc(String ruc);
	public List<ContratoLicencia> ListadoActivos();
	public List<ContratoLicencia> findbyIDEmpresa(Long id);
	public List<ContratoLicencia> findbyUser(@Param("usuario") String usuario);
	
}
