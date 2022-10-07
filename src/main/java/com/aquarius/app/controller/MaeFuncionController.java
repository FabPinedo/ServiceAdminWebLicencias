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
import com.aquarius.app.models.entity.MaeFuncion;
import com.aquarius.app.models.service.IMaeFuncionGrupoService;
import com.aquarius.app.models.service.IMaeFuncionService;

@RestController
//@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("/funcion")
public class MaeFuncionController {
	
	@Autowired
	private IMaeFuncionService funcionService;
	
	@Autowired
	private IMaeFuncionGrupoService grupoService;
	
	@GetMapping("/list/{usuario}")
	public List<MaeFuncion> listFuncion(@PathVariable String usuario) {
		return funcionService.findByUsuario(usuario);
	}
	
	@GetMapping("/list/codgrupo/{usuario}/{codgrupo}")
	public List<MaeFuncion> listFuncionGrupo(@PathVariable String usuario, @PathVariable Long codgrupo) {
		return funcionService.findByGrupo(usuario, codgrupo);
	}
	
	@GetMapping("/list/codfunsup/{usuario}/{codfunsup}")
	public List<MaeFuncion> listFuncionSup(@PathVariable String usuario, @PathVariable Long codfunsup) {
		return funcionService.findByFuncionSup(usuario, codfunsup);
	}
	
	@GetMapping("/list/funcion/{usuario}/{desurl}")
	public Boolean findAllAcceso(@PathVariable String usuario, @PathVariable String desurl) {
		
		List<MaeFuncion> list = funcionService.findAllFuncionByUsuarioAndURl(usuario, desurl);
		
		if(list.size() > 0) {
			//1L
			return true;
		}else {
			//0L
			return false;
		}
		
	}
	
	@GetMapping("find/{id}")
	public MaeFuncion findById(@PathVariable Long id) {
		return funcionService.findById(id);
	}
	
	@GetMapping("/list/disp/codgrupo/{id}")
	public List<MaeFuncion> listFuncionGrupoDisp(@PathVariable Long id) {
		return funcionService.findByGrupoDisp(id);
	}
	
	@GetMapping("/list/asig/codgrupo/{id}")
	public List<MaeFuncion> listFuncionGrupoAsig(@PathVariable Long id) {
		return funcionService.findByGrupoAsig(id);
	}
	
	@GetMapping("/disable/id/{id}")
	public int disableFuncion(@PathVariable Long id){
		 funcionService.deleteById(id);
		return 1;
	}
	
	@GetMapping("/enable/id/{id}")	
	public int enableFuncion(@PathVariable Long id){
		return funcionService.enableFuncion(id);
	}
	
	@GetMapping("delete/grupo/id/{id}")
	public Long deleteByCodgrupo(@PathVariable Long id) {
		if(funcionService.findByGrupoAsig(id).size()>0) {
			funcionService.deleteByCodgrupo(id);
		}
		grupoService.deleteBy(id);
		return 1L;
	}
	
	@PostMapping("save")
	@ResponseBody
	public MaeFuncion save(@RequestBody MaeFuncion submenu) {
		
	if(submenu.getDesurl() != null) {	
		if(submenu.getDesurl().trim() == "") {
			submenu.setDesurl(null);
		}
	}
		submenu.setEstado(true);
		return funcionService.save(submenu);
	}
	

}
