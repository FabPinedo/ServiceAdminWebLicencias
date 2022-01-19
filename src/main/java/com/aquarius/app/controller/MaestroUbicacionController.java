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
import com.aquarius.app.models.entity.MaestroUbicacion;
import com.aquarius.app.models.service.IMaestroUbicacionService;

@RestController
@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("/ubicacion")
public class MaestroUbicacionController {
	@Autowired
	private IMaestroUbicacionService ubicacionservice;
	
	@GetMapping("/find/listado")
	public List<MaestroUbicacion> index() {
		return ubicacionservice.findAll();
	}
	@GetMapping("/find/listado/codempresa/{id}")
	public List<MaestroUbicacion> byempresa(@PathVariable Long id) {
	return ubicacionservice.findAllbyEmpresa(id);
		}

	@GetMapping("/find/id/{codubicacion}")
	public ResponseEntity<?> show(@PathVariable String codubicacion){
		MaestroUbicacion ubicacion= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			 ubicacion=ubicacionservice.findById(codubicacion);
			
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la busqueda de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(ubicacion==null) {
			respuesta.put("Mensaje","La ubicacion de ID: ".concat(codubicacion.concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
	
	return new ResponseEntity<MaestroUbicacion>(ubicacion, HttpStatus.OK);
		}
	
	
	@PostMapping("/post")
	public ResponseEntity<?> addSistema(@RequestBody MaestroUbicacion ubicacion) {
		MaestroUbicacion ubicacionnueva= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			ubicacionnueva=ubicacionservice.saveUbicacion(ubicacion);;
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito el nuevo sistema");
		respuesta.put("sede", ubicacionnueva);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		}
	


	
	@DeleteMapping(value="/find/id/{codubicacion}")
	public ResponseEntity<?> eliminar(@PathVariable("codubicacion") String codubicacion) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			ubicacionservice.deleteUbicacion(codubicacion);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el delete en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		respuesta.put("Mensaje","La sede ha sido eliminado!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			
		}
	
			
			
	
	
	
}
