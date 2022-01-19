package com.aquarius.app.models.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IMaeTablaDetDao;
import com.aquarius.app.models.entity.MaeTablaDet;
import com.aquarius.app.models.service.IMaeTablaDetService;

@Service
public class MaeTablaDetServiceImpl implements IMaeTablaDetService {
	@Autowired
	private IMaeTablaDetDao tablaDao;

	@Override
	public List<MaeTablaDet> findAllByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return tablaDao.findAllByCodigo(codigo);
	}

	@Override
	public MaeTablaDet save(MaeTablaDet maetabladet) {
		// TODO Auto-generated method stub
		return tablaDao.save(maetabladet);
	}

	@Override
	public MaeTablaDet findById(Long id) {
		// TODO Auto-generated method stub
		return tablaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		tablaDao.disabledTablaDet(id);
	}

	@Override
	public MaeTablaDet findByDcorta(String descorta) {
		// TODO Auto-generated method stub
		//return tablaDao.findByDcorta(descorta);
		return null;
	}

	@Override
	public MaeTablaDet findByTipoAndDesCorta(String tiptabla, String descorta) {
		// TODO Auto-generated method stub
		return tablaDao.findByTipoAndDesCorta(tiptabla, descorta);
	}

	@Override
	public MaeTablaDet findByTablaAndDetalle(String tiptabla, Long id) {
		// TODO Auto-generated method stub
		return tablaDao.findByTablaAndDetalle(tiptabla, id);
	}

	@Override
	public int findByTipTablaAndDescorta(String tiptabla, String descorta) {
		// TODO Auto-generated method stub
		return tablaDao.findByTipTablaAndDescorta(tiptabla, descorta);
	}

	@Override
	public List<MaeTablaDet> findAllByCodigoOutDet(String codigo, Long codacci) {
		// TODO Auto-generated method stub
		return tablaDao.findAllByCodigoOutDet(codigo, codacci);
	}

	@Override
	public MaeTablaDet findOneLastByTabla(String tiptabla) {
		// TODO Auto-generated method stub
		return tablaDao.findOneLastByTabla(tiptabla);
	}

}
