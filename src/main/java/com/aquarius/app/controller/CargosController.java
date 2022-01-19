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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarius.app.models.entity.Cargos;

import com.aquarius.app.models.service.ICargosService;


@RestController
@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("cargos")
public class CargosController {
	@Autowired
	private ICargosService cargoservice;
	
	@GetMapping("/find/listado")
	public List<Cargos> index() {
	return cargoservice.findAll();
		}
	@GetMapping("/find/listado/activo")
	public List<Cargos> Activos() {
	return cargoservice.findAllActivos();
		}

	@GetMapping("/find/id/{codcargo}")
	public ResponseEntity<?> show(@PathVariable String codcargo){
		Cargos cargo= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			 cargo=cargoservice.findById(codcargo);
			
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la busqueda de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(cargo==null) {
			respuesta.put("Mensaje","el cargo de ID: ".concat(codcargo.concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
	
	return new ResponseEntity<Cargos>(cargo, HttpStatus.OK);
		}
	
	
	@PostMapping("/post")
	public ResponseEntity<?> addCargo(@RequestBody Cargos cargo) {
		Cargos cargoNuevo= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			cargoNuevo=cargoservice.saveCargo(cargo);;
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito el nuevo sistema");
		respuesta.put("sede", cargoNuevo);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		}
	


	
	@DeleteMapping(value="/find/id/{codcargo}")
	public ResponseEntity<?> eliminar(@PathVariable("codcargo") String codcargo) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			cargoservice.deleteCargo(codcargo);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el delete en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		respuesta.put("Mensaje","El cargo ha sido eliminado!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			
		}
	
}
