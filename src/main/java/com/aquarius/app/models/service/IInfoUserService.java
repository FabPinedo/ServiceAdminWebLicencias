package com.aquarius.app.models.service;

import java.util.List;

import com.aquarius.app.models.entity.face.IInfoChartBarra;
import com.aquarius.app.models.entity.face.IInfoChartTorta;
import com.aquarius.app.models.entity.face.IInfoCharts;


public interface IInfoUserService {

	public List<IInfoCharts> CantidadInventariado();

	public List<String> NoseQuery();
	
	public List<IInfoChartTorta> InfoGraficoTorta();
	
	public List<IInfoChartBarra> InfoGraficoBarra();
}
