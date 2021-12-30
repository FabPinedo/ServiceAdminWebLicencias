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


import com.aquarius.app.models.entity.Sistema;
import com.aquarius.app.models.service.ISistemaService;

@RestController
@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("sistema")
public class SistemaController {
	@Autowired
	private ISistemaService sistemaService;
	
	@GetMapping("/find/listado")
	public List<Sistema> index() {
	return sistemaService.findAll();
		}
	@GetMapping("/find/listado/activos")
	public List<Sistema> listadoActivos() {
	return sistemaService.ListadoActivo();
		}
	
	@GetMapping("/find/page/{page}")
	public Page<Sistema> index(@PathVariable Integer page) {
		Pageable pageable=PageRequest.of(page, 5);
	return sistemaService.findAll(pageable);
		}
	
	@GetMapping("/find/id/{id}")
	public ResponseEntity<?> show(@PathVariable long id){
		Sistema sistema= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			 sistema=sistemaService.findById(id);
			
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la busqueda de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(sistema==null) {
			respuesta.put("Mensaje","La Sistema de ID: ".concat(Long.toString(id).concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
	
	return new ResponseEntity<Sistema>(sistema, HttpStatus.OK);
		}
	
	@GetMapping("/find/estado/page/{page}")
	public Page<Sistema> findbyEstado(@PathVariable int page) {
		Pageable pageable=PageRequest.of(page, 5);
	return sistemaService.findAllEstado(pageable);
		}
	

	
	@PostMapping("/post")
	public ResponseEntity<?> addSistema(@RequestBody Sistema sistema) {
		Sistema sistemaNuevo= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			sistemaNuevo=sistemaService.SaveSistema(sistema);;
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito el nuevo sistema");
		respuesta.put("Sistema", sistemaNuevo);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		}
		
	
	
	@DeleteMapping(value="/find/id/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") long id) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			sistemaService.deleteSistema(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el delete en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		respuesta.put("Mensaje","El sistema ha sido eliminado!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			
		}
	
			
			
	
	
	
	
	@PutMapping("/find/id/{id}")
	public ResponseEntity<?> updateSistema(@RequestBody Sistema sistema,@PathVariable long id) {
		Sistema sistemaActualizado=null;
		Map<String,Object> respuesta= new HashMap<>();
		Sistema sistemaActual=sistemaService.findById(id);
		if(sistemaActual==null) {
			respuesta.put("Mensaje","La empresa de ID: ".concat(Long.toString(id).concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
		
		try {
			sistemaActual.setDescripcion(sistema.getDescripcion());
			sistemaActual.setIndbaja(sistema.getIndbaja());
			sistemaActual.setNumversion(sistema.getNumversion());
			sistemaActual.setSistema(sistema.getSistema());
			sistemaActualizado=sistemaService.SaveSistema(sistemaActual);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la actualizacion en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se actualizo con Exito el sistema");
		respuesta.put("Sistema", sistemaActualizado);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		
		
	
		
		
	
}
	}
