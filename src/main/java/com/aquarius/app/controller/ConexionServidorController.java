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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.aquarius.app.models.entity.ConexionServidor;

import com.aquarius.app.models.service.IConexionServidorService;


@RestController
@RequestMapping("conexion")
public class ConexionServidorController {
	
	@Autowired
	private IConexionServidorService conexionService;
	
	@GetMapping("/find/listado")
	public List<ConexionServidor> index() {
		return conexionService.findAll();
	}
	
	@GetMapping("/find/listado/codEmpresa/{id}")
	public List<ConexionServidor> findListadoByIdEmpresa(@PathVariable long id) {
		return conexionService.findByIdEmpresa(id);
	}
	
	@GetMapping("/find/page/{page}")
	public Page<ConexionServidor> index(@PathVariable Integer page) {
		Pageable pageable=PageRequest.of(page, 5);
		return conexionService.findAll(pageable);
	}
	
	@GetMapping("/find/razonsocial/{razonsocial}")
	public List<ConexionServidor> findRazonSocial(@PathVariable String razonsocial) {
		return conexionService.findByRazonsocial(razonsocial);
	}
	
	@GetMapping("/find/ruc/{ruc}")
	public List<ConexionServidor> findRuc(@PathVariable String ruc) {
		return conexionService.findByRuc(ruc);
	}
	
	
	@GetMapping("/find/id/{id}")
	public ResponseEntity<?> show(@PathVariable long id){
		ConexionServidor conexion= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			 conexion=conexionService.findById(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la busqueda de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(conexion==null) {
			respuesta.put("Mensaje","La conexion de ID: ".concat(Long.toString(id).concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
		return new ResponseEntity<ConexionServidor>(conexion, HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> addConexion(@RequestBody ConexionServidor conexion) {
		ConexionServidor conexionNueva= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			conexionNueva=conexionService.SaveConexionServidor(conexion);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito la nueva conexion ");
		respuesta.put("Conexion", conexionNueva);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
	}

	@DeleteMapping(value="/find/id/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") long id) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			conexionService.deleteConexionServidor(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el delete en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","La conexion ha sido eliminada!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
	}
			
		
	@PutMapping("/find/id/{id}")
	public ResponseEntity<?> updateConexion(@RequestBody ConexionServidor conexion,@PathVariable long id) {
		ConexionServidor conexionActualizada=null;
		Map<String,Object> respuesta= new HashMap<>();
		ConexionServidor conexionActual=conexionService.findById(id);
		if(conexionActual==null) {
			respuesta.put("Mensaje","La empresa de ID: ".concat(Long.toString(id).concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
		
		try {
			conexionActual.setBdservinstancia(conexion.getBdservinstancia());
			conexionActual.setBdnombre(conexion.getBdnombre());
			conexionActual.setBdcontra(conexion.getBdcontra());
			conexionActual.setBdusuario(conexion.getBdusuario());
			conexionActual.setBdtipo(conexion.getBdtipo());
			conexionActual.setTomcatpuerto(conexion.getTomcatpuerto());
			conexionActual.setTomcatusuario(conexion.getTomcatusuario());
			conexionActual.setTomcatcontra(conexion.getTomcatcontra());
			conexionActual.setWeburl(conexion.getWeburl());
			conexionActual.setCodempresa(conexion.getCodempresa());
			conexionActual.setEmpresa(conexion.getEmpresa());
			conexionActualizada=conexionService.SaveConexionServidor(conexionActual);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la actualizacion en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se actualizo con Exito el sistema");
		respuesta.put("Conexion", conexionActualizada);
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
	}

}
