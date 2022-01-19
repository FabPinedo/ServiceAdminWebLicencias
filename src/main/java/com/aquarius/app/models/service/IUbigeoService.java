package com.aquarius.app.models.service;

import java.util.List;

import com.aquarius.app.models.entity.Sede;
import com.aquarius.app.models.entity.Ubigeo;

public interface IUbigeoService {
	public List<Ubigeo> findAllDepartamentos();
	public List<Ubigeo> findAllbyProvincias(String codubigeo);
	public List<Ubigeo> findAllbydistrios(String codUbigeo);

}
