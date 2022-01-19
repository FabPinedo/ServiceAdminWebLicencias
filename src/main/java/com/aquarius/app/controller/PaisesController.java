package com.aquarius.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarius.app.models.entity.Pais;
import com.aquarius.app.models.entity.Sede;
import com.aquarius.app.models.service.IPaisService;
import com.aquarius.app.models.service.ISedeService;

@RestController
@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("paises")
public class PaisesController {
	@Autowired
	private IPaisService paiseService;
	
	@GetMapping("/find/listado")
	public List<Pais> index() {
	return paiseService.findAll();
		}
}
