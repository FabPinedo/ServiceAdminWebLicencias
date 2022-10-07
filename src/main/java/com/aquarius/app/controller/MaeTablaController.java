package com.aquarius.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aquarius.app.models.entity.MaeTabla;
import com.aquarius.app.models.service.IMaeTablaService;


@RestController
//@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("/tabla")
public class MaeTablaController {
	@Autowired
	private IMaeTablaService tablaService;
	
	@GetMapping("list")
	public List<MaeTabla> findAll(){
		return tablaService.findAll();
	}
	
	@PostMapping("save")
	@ResponseBody
	public MaeTabla save(@RequestBody MaeTabla maetabla) {
		
		int count = tablaService.countByCodigo(maetabla.getTiptabla());
		
		if(count > 0 && !maetabla.getIsupdate()) {
			return null;
		}else {
			return tablaService.save(maetabla);
		}
		
	}
	
	@GetMapping("find/id/{id}")
	public MaeTabla findById(@PathVariable String id) {
		return tablaService.findById(id);
	}
	
	@GetMapping("delete/id/{codigo}")
	public Long deleteById(@PathVariable String codigo) {
		System.out.println(codigo);
		tablaService.deleteById(codigo);
		return 1L;
	}
}
