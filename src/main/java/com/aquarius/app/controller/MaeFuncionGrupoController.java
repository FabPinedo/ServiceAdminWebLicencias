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
import com.aquarius.app.models.entity.MaeFuncionGrupo;
import com.aquarius.app.models.service.IMaeFuncionGrupoService;

@RestController
//@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("/fgrupo")
public class MaeFuncionGrupoController {
	
	@Autowired
	private IMaeFuncionGrupoService grupoService;
	
	@GetMapping("/list")
	public List<MaeFuncionGrupo> findAll() {
		return grupoService.findAll();
	}
	
	@GetMapping("/list/{usuario}")
	public List<MaeFuncionGrupo> listFuncion(@PathVariable String usuario) {
		return grupoService.findByUsuario(usuario);
	}
	
	@GetMapping("/list/perfil/{id}")
	public List<MaeFuncionGrupo> listByPerfil(@PathVariable Long id) {
		return grupoService.findByPerfil(id);
	}
	
	@PostMapping("save")
	@ResponseBody
	public MaeFuncionGrupo save(@RequestBody MaeFuncionGrupo funciongrupo) {
		return grupoService.save(funciongrupo);
	}
	
	@GetMapping("/find/id/{id}")
	public MaeFuncionGrupo findById(@PathVariable Long id) {
		return grupoService.findById(id);
	}

}
