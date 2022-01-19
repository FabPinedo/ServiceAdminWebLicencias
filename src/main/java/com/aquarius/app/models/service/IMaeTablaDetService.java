package com.aquarius.app.models.service;

import java.util.List;

import com.aquarius.app.models.entity.MaeTablaDet;

public interface IMaeTablaDetService {

	public List<MaeTablaDet> findAllByCodigo(String codigo);
	public MaeTablaDet save(MaeTablaDet maetabladet);
	public MaeTablaDet findById(Long id);
	public void deleteById(Long id);
	public MaeTablaDet findByDcorta(String descorta);
	public MaeTablaDet findByTipoAndDesCorta(String tiptabla,String descorta);
	public MaeTablaDet findByTablaAndDetalle(String tiptabla, Long id);
	public int findByTipTablaAndDescorta(String tiptabla, String descorta);
	public List<MaeTablaDet> findAllByCodigoOutDet(String codigo, Long codacci);
	public MaeTablaDet findOneLastByTabla(String tiptabla);
}
