package com.aquarius.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.aquarius.app.models.entity.ContratoLicencia;
import com.aquarius.app.models.service.IConexionServidorService;
import com.aquarius.app.models.service.IContratoLicenciaService;
import com.aquarius.app.models.service.IEmpresaService;
import com.aquarius.app.models.service.ISistemaService;

@RestController
@RequestMapping("Contrato")
@CrossOrigin(origins="*" )
public class ContratoLicenciaController {
	
	@Autowired
	private IContratoLicenciaService licenciaService;
	@Autowired
	private IEmpresaService empresaService;
	@Autowired
	private IConexionServidorService conexionService;
	@Autowired
	private ISistemaService sistemaService;

	@GetMapping("/find/listado")
	public List<ContratoLicencia> index() {
		
	return licenciaService.findAll();
		}
	@GetMapping("/find/listado/activos")
	public List<ContratoLicencia> ListadoActivos() {
	return licenciaService.ListadoActivos();
		}
	@GetMapping("/find/estado/page/{page}")
	public Page<ContratoLicencia> findbyEstado(@PathVariable int page) {
		Pageable pageable=PageRequest.of(page, 5);
	return licenciaService.findAllByEstado(pageable);
		}
	@GetMapping("/find/listado/codempresa/{id}")
	public List<ContratoLicencia> findbyIDEmpresa(@PathVariable Long id) {
		
	return licenciaService.findbyIDEmpresa(id);
		}
	
	@GetMapping("/find/page/{page}")
	public Page<ContratoLicencia> index(@PathVariable Integer page) {
		Pageable pageable=PageRequest.of(page, 5);
	return licenciaService.findAll(pageable);
		}
	
	@GetMapping("/find/razonsocial/{razonsocial}/{page}")
	public Page<ContratoLicencia> findRazonSocial(@PathVariable String razonsocial, @PathVariable int page) {
		Pageable pageable=PageRequest.of(page, 5);
	return licenciaService.findByRazonsocial(razonsocial,pageable);
		}
	
	@GetMapping("/find/ruc/{ruc}/{page}")
	public Page<ContratoLicencia> findRuc(@PathVariable String ruc, @PathVariable int page) {
		Pageable pageable=PageRequest.of(page, 5);
	return licenciaService.findByRuc(ruc, pageable);
		}
	
	@GetMapping("find/codigo/{codigo}")
	public ResponseEntity<byte[]> findByCodigo(@PathVariable String codigo) {
		
		String licenciaJson = licenciaService.exportJSONfindByCodigo(codigo);
		byte[] customerJsonBytes = licenciaJson.getBytes();
		
		return ResponseEntity
				.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=aquariuskey.json")
				.contentType(MediaType.APPLICATION_JSON)
				.contentLength(customerJsonBytes.length)
				.body(customerJsonBytes);
	}
	
	
	@GetMapping("find/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		ContratoLicencia licencia= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			 licencia=licenciaService.findById(id);
			
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la busqueda de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(licencia==null) {
			respuesta.put("Mensaje","La licencia de ID: ".concat(Long.toString(id).concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
	
	return new ResponseEntity<ContratoLicencia>(licencia, HttpStatus.OK);
		}
	
	@GetMapping("find/estado/codigo/{codigo}")
	public Boolean estadoLicencia(@PathVariable String codigo) {
		ContratoLicencia licencia = new ContratoLicencia();
		Boolean estado = false;
		licencia = licenciaService.findByCodigo(codigo);
		if(licencia != null) {
			estado = licencia.getEstado();
		}
		return estado; 
	}

	@DeleteMapping(value="/find/id/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> eliminar(@PathVariable("id") long id) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			licenciaService.deleteContrato(id);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el update en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		respuesta.put("Mensaje","La licencia ha sido eliminada!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			
		}
			
	
	@PostMapping("/post")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> addContrato(@RequestBody ContratoLicencia contrato) {
		ContratoLicencia licencianueva= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			
			contrato.setEmpresa(empresaService.findById(contrato.getCodempresa()));
			contrato.setSistema(sistemaService.findById(contrato.getCodsistema()));
			contrato.setConexion(conexionService.findById(contrato.getCodconexion()));
			licencianueva=licenciaService.SaveContrato(contrato);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito la nueva licencia ");
		respuesta.put("Licencia", licencianueva);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		}
		
	
	
	
	@PutMapping("/find/id/{id}")
	public ResponseEntity<?> updateContrato(@RequestBody ContratoLicencia contrato,@PathVariable long id) {
		ContratoLicencia licenciaActualizada=null;
		Map<String,Object> respuesta= new HashMap<>();
		ContratoLicencia contratoActual=licenciaService.findById(id);
		if(contratoActual==null) {
			respuesta.put("Mensaje","La licencia de ID: ".concat(Long.toString(id).concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
		
		try {
			contratoActual.setCodempresa(contrato.getCodempresa());
			contratoActual.setEmpresa(empresaService.findById(contrato.getCodempresa()));
			contratoActual.setCodsistema(contrato.getCodsistema());
			contratoActual.setSistema(sistemaService.findById(contrato.getCodsistema()));
			contratoActual.setCodconexion(contrato.getCodconexion());
			contratoActual.setConexion(conexionService.findById(contrato.getCodconexion()));
			contratoActual.setEstado(contrato.getEstado());
			contratoActual.setFechafincontrato(contrato.getFechafincontrato());
			contratoActual.setFechainicontrato(contrato.getFechainicontrato());
			contratoActual.setToken(contrato.getToken());
			contratoActual.setCantactivos(contrato.getCantactivos());
			contratoActual.setCantusuarios(contrato.getCantusuarios());
			licenciaActualizada=licenciaService.SaveContrato(contratoActual);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el update en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se actualizo con Exito el sistema");
		respuesta.put("Licencia", licenciaActualizada);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
	
}

		
		
		
	
	
}
