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
import com.aquarius.app.models.entity.MaeAccesosRes;
import com.aquarius.app.models.service.IMaeAccesosResService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/acceso")
public class MaeAccesoResController {

	@Autowired
	private IMaeAccesosResService accesoService;
	
	@GetMapping("list/usuario/{usuario}")
	public List<MaeAccesosRes> findByUsuario(@PathVariable String usuario){
		return accesoService.findByUsuario(usuario);
	}
	
	@PostMapping("save")
	@ResponseBody
	public MaeAccesosRes save(@RequestBody MaeAccesosRes acceso) {
		return accesoService.save(acceso);
	}
	
	@GetMapping("delete/id/{id}")
	public Long deleteById(@PathVariable Long id) {
		accesoService.deleteById(id);
		return 1L;
	} 
	
}
