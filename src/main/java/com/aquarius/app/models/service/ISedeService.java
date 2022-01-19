package com.aquarius.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.aquarius.app.models.entity.Sede;

public interface ISedeService {
	public List<Sede> findAll();
	public List<Sede> findAllbyEmpresa(Long codsede);

	public Sede saveSede(Sede sede);

	public void deleteSede(String codsede);

	public Sede findById(String codsede);
}
