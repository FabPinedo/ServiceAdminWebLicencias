package com.aquarius.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aquarius.app.models.entity.LicenciasUsuarioEmpresa;
import com.aquarius.app.models.service.ILicenciasUsuarioEmpresaService;

@RestController
@RequestMapping("/LicenciaUserEmpresa")
public class LicenciasUsuarioEmpresaController {
	@Autowired
	private ILicenciasUsuarioEmpresaService userEmpresaService;
	
	@GetMapping("/find/listado")
	public List<LicenciasUsuarioEmpresa> index() {
	return userEmpresaService.findAll();
		}
	@GetMapping("/find/listado/user/{user}")
	public List<LicenciasUsuarioEmpresa> findByUser(@PathVariable("user") String user) {
	return userEmpresaService.findLicenciasByUser(user);
		}
	@DeleteMapping(value="/find/user/{user}/contrato/{id}")
	public ResponseEntity<?> deleteByUserandId(@PathVariable("user") String user,@PathVariable("id") Long id) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			userEmpresaService.deleteObjeto(user,id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el delete en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		respuesta.put("Mensaje","La relacion user contrato ha sido eliminada!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			
		}
	@PostMapping("/post")
	public ResponseEntity<?> addRelacion(@RequestBody LicenciasUsuarioEmpresa licenciasUsuarioEmpresa) {
		LicenciasUsuarioEmpresa nuevaRelacion= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			nuevaRelacion=userEmpresaService.SaveLicenciasUsuarioEmpresa(licenciasUsuarioEmpresa);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito la nueva relacion contrato user");
		respuesta.put("Empresa", nuevaRelacion);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		}
	
	
	@DeleteMapping(value="/find/id/{id}")
	public ResponseEntity<?> eliminar(@PathVariable("id") long id) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			userEmpresaService.deleteLicenciasUsuarioEmpresa(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el delete en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		respuesta.put("Mensaje","La relacion user contrato ha sido eliminada!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			
		}
}
