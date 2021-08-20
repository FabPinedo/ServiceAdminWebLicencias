package com.aquarius.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aquarius.app.models.entity.ConexionServidor;




public interface IConexionServidorService {
	public List<ConexionServidor> findAll();

	public ConexionServidor SaveConexionServidor(ConexionServidor conexionServidor);

	public void deleteConexionServidor(long id);

	public ConexionServidor findById(long id);
	public Page<ConexionServidor> findAll(Pageable pageable);
	public Page<ConexionServidor> findByRazonsocial(String razonsocial,Pageable pageable);
	public Page<ConexionServidor> findByRuc(String ruc,Pageable pageable);
	public List<ConexionServidor>findByIdEmpresa(long id);
}
