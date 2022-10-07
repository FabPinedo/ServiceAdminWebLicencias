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
import com.aquarius.app.models.entity.MaePerfilGrupoFuncion;
import com.aquarius.app.models.service.IMaePerfilGrupoFuncionService;

@RestController
//@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("perfilgrupofuncion")
public class MaePerfilGrupoFuncionController {

	@Autowired
	private IMaePerfilGrupoFuncionService grupoService;
	
	@GetMapping("list")
	public List<MaePerfilGrupoFuncion> findAll(){
		return grupoService.findAll();
	}
	
	@GetMapping("find/id/{id}")
	public MaePerfilGrupoFuncion findById(@PathVariable Long id){
		return grupoService.findById(id);
	}
	
	@GetMapping("find/perfil/{id}")
	public List<MaePerfilGrupoFuncion> findByPerfil(@PathVariable Long id){
		return grupoService.findByPerfil(id);
	}
	
	@GetMapping("delete/id/{id}")
	public Long deleteById(@PathVariable Long id) {
		grupoService.deleteById(id);
		return 1L;
	}
	
	@PostMapping("save")
	@ResponseBody
	public MaePerfilGrupoFuncion save(@RequestBody MaePerfilGrupoFuncion perfilgrupofuncion) {		
		return grupoService.save(perfilgrupofuncion);
	}
	
	
	
}
