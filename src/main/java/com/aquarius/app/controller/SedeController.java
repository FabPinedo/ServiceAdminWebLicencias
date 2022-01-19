package com.aquarius.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import com.aquarius.app.models.entity.Sede;
import com.aquarius.app.models.entity.Sistema;
import com.aquarius.app.models.service.ISedeService;

@RestController
@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("sede")
public class SedeController {
	@Autowired
	private ISedeService sedeService;
	
	@GetMapping("/find/listado")
	public List<Sede> index() {
	return sedeService.findAll();
		}
	@GetMapping("/find/listado/codempresa/{id}")
	public List<Sede> byempresa(@PathVariable Long id) {
	return sedeService.findAllbyEmpresa(id);
		}

	@GetMapping("/find/id/{codsede}")
	public ResponseEntity<?> show(@PathVariable String codsede){
		Sede sede= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			 sede=sedeService.findById(codsede);
			
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la busqueda de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(sede==null) {
			respuesta.put("Mensaje","La sede de ID: ".concat(codsede.concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
	
	return new ResponseEntity<Sede>(sede, HttpStatus.OK);
		}
	
	
	@PostMapping("/post")
	public ResponseEntity<?> addSistema(@RequestBody Sede sede) {
		Sede sedeNueva= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			sedeNueva=sedeService.saveSede(sede);;
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito el nuevo sistema");
		respuesta.put("sede", sedeNueva);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		}
	


	
	@DeleteMapping(value="/find/id/{codsede}")
	public ResponseEntity<?> eliminar(@PathVariable("codsede") String codsede) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			sedeService.deleteSede(codsede);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el delete en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		respuesta.put("Mensaje","La sede ha sido eliminado!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			
		}
	
			
			
	
	
	
	
	@PutMapping("/find/id/{codsede}")
	public ResponseEntity<?> updateSede(@RequestBody Sede sede,@PathVariable String codsede) {
		Sede sedeActualizada=null;
		Map<String,Object> respuesta= new HashMap<>();
		Sede sedeActual=sedeService.findById(codsede);
		if(sedeActual==null) {
			respuesta.put("Mensaje","La sede de ID: ".concat(codsede.concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
		
		try {
			sedeActual.setCodsede(sede.getCodsede());
			sedeActual.setEstado(sede.getEstado());
			sedeActual.setDescripcion(sede.getDescripcion());
			sedeActual.setFeccreacion(sede.getFeccreacion());
			sedeActual.setCodempresa(sede.getCodempresa());
			sedeActualizada=sedeService.saveSede(sedeActual);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la actualizacion en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se actualizo con Exito la sede");
		respuesta.put("Sistema", sedeActualizada);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		
		
	
		
		
	
}
}
