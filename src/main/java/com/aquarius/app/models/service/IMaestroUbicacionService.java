package com.aquarius.app.models.service;

import java.util.List;

import com.aquarius.app.models.entity.MaestroUbicacion;
import com.aquarius.app.models.entity.Sede;

public interface IMaestroUbicacionService {
	public List<MaestroUbicacion> findAll();
	public List<MaestroUbicacion> findAllbyEmpresa(Long codempresa);

	public MaestroUbicacion saveUbicacion(MaestroUbicacion ubicacion);

	public void deleteUbicacion(String codubicacion);

	public MaestroUbicacion findById(String codubicacion);
}
