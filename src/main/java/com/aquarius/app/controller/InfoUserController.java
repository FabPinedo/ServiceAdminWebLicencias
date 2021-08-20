package com.aquarius.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarius.app.models.entity.face.IInfoChartBarra;
import com.aquarius.app.models.entity.face.IInfoChartTorta;
import com.aquarius.app.models.entity.face.IInfoCharts;
import com.aquarius.app.models.service.IInfoUserService;

@RestController
@RequestMapping("/InfoUser")
@CrossOrigin(origins="*")
public class InfoUserController {
	
	@Autowired
	private IInfoUserService infoUserService;
	
	@GetMapping("/cantidadInventario")
	public List<IInfoCharts>CantidadInventario() {
	return infoUserService.CantidadInventariado();
		}
	@GetMapping("/nose")
	public List<String>Nose() {
	return infoUserService.NoseQuery();
		}
	@GetMapping("/Torta")
	public List<IInfoChartTorta>infoGraficoTorta() {
	return infoUserService.InfoGraficoTorta();
		}
	@GetMapping("/Barra")
	public List<IInfoChartBarra>infoGraficoBarra() {
	return infoUserService.InfoGraficoBarra();
		}
}
