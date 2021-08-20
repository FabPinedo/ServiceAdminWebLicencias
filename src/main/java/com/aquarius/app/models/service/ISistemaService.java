package com.aquarius.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.aquarius.app.models.entity.Sistema;



public interface ISistemaService {
	public List<Sistema> findAll();

	public Sistema SaveSistema(Sistema sistema);

	public void deleteSistema(long id);

	public Sistema findById(long id);
	public Page<Sistema> findAll(Pageable pageable);
	public Page<Sistema> findAllEstado(Pageable pageable);
	public List<Sistema> ListadoActivo();
}
