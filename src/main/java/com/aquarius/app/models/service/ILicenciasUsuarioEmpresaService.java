package com.aquarius.app.models.service;

import java.util.List;


import com.aquarius.app.models.entity.LicenciasUsuarioEmpresa;

public interface ILicenciasUsuarioEmpresaService {
	public List<LicenciasUsuarioEmpresa> findAll();
	public List<LicenciasUsuarioEmpresa> findcant(String contrato);
	public LicenciasUsuarioEmpresa SaveLicenciasUsuarioEmpresa(LicenciasUsuarioEmpresa userempresa);
	
	public void deleteObjeto(String codusuario);

	public void deleteLicenciasUsuarioEmpresa(long id);
	
	public List<LicenciasUsuarioEmpresa> findLicenciasByUser(String usuario);
}
