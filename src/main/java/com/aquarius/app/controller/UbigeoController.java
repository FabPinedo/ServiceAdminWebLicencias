package com.aquarius.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarius.app.models.entity.Pais;
import com.aquarius.app.models.entity.Ubigeo;
import com.aquarius.app.models.service.IPaisService;
import com.aquarius.app.models.service.IUbigeoService;

@RestController
@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("ubigeo")
public class UbigeoController {
	@Autowired
	private IUbigeoService ubigeoService;
	
	@GetMapping("/find/departamentos")
	public List<Ubigeo> DEPARTAMENTOS() {
	return ubigeoService.findAllDepartamentos();
		}
	@GetMapping("/find/provincia/{codubigeo}")
	public List<Ubigeo> PROVINCIAS(@PathVariable String codubigeo) {
	return ubigeoService.findAllbyProvincias(codubigeo);
		}
	@GetMapping("/find/distrito/{codubigeo}")
	public List<Ubigeo> DISTRITOS(@PathVariable String codubigeo) {
	return ubigeoService.findAllbydistrios(codubigeo);
		}
}
