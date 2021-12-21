package com.aquarius.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarius.app.models.entity.MaePerfil;

import com.aquarius.app.models.service.IPerfilService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/errperfil")
public class PerfilController {
	@Autowired
	private IPerfilService perfilservice;
	@GetMapping("/find/listado")
	public List<MaePerfil> index() {
	return perfilservice.findAll();
		}
	
	@GetMapping("/find/page/{page}")
	public Page<MaePerfil> index(@PathVariable Integer page) {
		Pageable pageable=PageRequest.of(page, 5);
	return perfilservice.findAll(pageable);
		}
	
	@GetMapping("/find/id/{id}")
	public ResponseEntity<?> show(@PathVariable long id){
		MaePerfil perfil= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			 perfil=perfilservice.findById(id);
			
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la busqueda de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(perfil==null) {
			respuesta.put("Mensaje","El perfil de ID: ".concat(Long.toString(id).concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
	
	return new ResponseEntity<MaePerfil>(perfil, HttpStatus.OK);
		}
	

	
	@PostMapping("/post")
	public ResponseEntity<?> addPerfil(@RequestBody MaePerfil perfil) {
		MaePerfil perfilnuevo= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			perfilnuevo=perfilservice.SavePerfil(perfil);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito el nuevo perfil");
		respuesta.put("Sistema", perfilnuevo);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		}
		
	
	
	@DeleteMapping(value="/find/id/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") long id) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			perfilservice.deletePerfil(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el delete en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		respuesta.put("Mensaje","El perfil ha sido eliminado!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			
		}

	@PutMapping("/find/id/{id}")
	public ResponseEntity<?> updatePerfil(@RequestBody MaePerfil perfil,@PathVariable long id) {
		MaePerfil perfilActualizado=null;
		Map<String,Object> respuesta= new HashMap<>();
		MaePerfil perfilActual=perfilservice.findById(id);
		if(perfilActual==null) {
			respuesta.put("Mensaje","La perfil de ID: ".concat(Long.toString(id).concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
		
		try {
			perfilActual.setDesperfil(perfil.getDesperfil());
			perfilActualizado=perfilservice.SavePerfil(perfilActual);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la actualizacion en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se actualizo con Exito el perfil");
		respuesta.put("Sistema", perfilActualizado);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		
		
	
		
		
	
}
	
}
