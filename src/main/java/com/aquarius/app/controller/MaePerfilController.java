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
import com.aquarius.app.models.entity.MaePerfil;
import com.aquarius.app.models.service.IMaePerfilService;

@RestController
@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("/perfil")
public class MaePerfilController {
	
	@Autowired
	private IMaePerfilService perfilService;
	
	@GetMapping("list")
	public List<MaePerfil> findAll() {
		return perfilService.findAll();
	}
	
	@GetMapping("/find/listado")
	public List<MaePerfil> index() {
		return perfilService.findAll();
	}
	
	@GetMapping("find/{usuario}")
	public MaePerfil findByUsuario(@PathVariable String usuario) {
		System.out.println("El usuario es: " + usuario);
		return perfilService.findByUsuario(usuario);
	}
	
	@GetMapping("find/id/{id}")
	public MaePerfil findById(@PathVariable Long id) {
		return perfilService.findById(id);
	}
	
	@PostMapping("save")
	@ResponseBody
	public MaePerfil save(@RequestBody MaePerfil perfil) {
		System.out.println("perfil id:  " + perfil.getId());
		return perfilService.save(perfil);
	}
	
	@GetMapping("delete/id/{id}")
	public Long deleteById(@PathVariable Long id) {
		perfilService.deleteById(id);
		return 1L;
	}

}
