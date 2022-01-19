package com.aquarius.app.models.service;

import java.util.List;

import com.aquarius.app.models.entity.MaeTabla;

public interface IMaeTablaService {
	public List<MaeTabla> findAll();
	public MaeTabla save(MaeTabla maetabla);
	public MaeTabla findById(String codigo);
	public void deleteById(String codigo);
	public int countByCodigo(String codigo);

}
