package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aquarius.app.db2.InfoUser.dao.InfoUserDao;
import com.aquarius.app.models.entity.face.IInfoChartBarra;
import com.aquarius.app.models.entity.face.IInfoChartTorta;
import com.aquarius.app.models.entity.face.IInfoCharts;
import com.aquarius.app.models.service.IInfoUserService;

@Service
public class InfoUserServiceImpl implements IInfoUserService{
	
	@Autowired
	private InfoUserDao infoUserDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<IInfoCharts> CantidadInventariado() {
		// TODO Auto-generated method stub
		return infoUserDAO.CantidadInventariado();
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> NoseQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<IInfoChartTorta> InfoGraficoTorta() {
		// TODO Auto-generated method stub
		return infoUserDAO.InfoGraficoTorta();
	}

	@Override
	@Transactional(readOnly = true)
	public List<IInfoChartBarra> InfoGraficoBarra() {
		// TODO Auto-generated method stub
		return infoUserDAO.InfoGraficoBarra();
	}

}
