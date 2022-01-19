package com.aquarius.app.models.service;

import java.util.List;

import com.aquarius.app.models.entity.Cargos;

public interface ICargosService {
	
	public List<Cargos> findAll();
	public List<Cargos> findAllActivos();

	public Cargos saveCargo(Cargos cargo);

	public void deleteCargo(String codcargo);

	public Cargos findById(String codcargo);
}
