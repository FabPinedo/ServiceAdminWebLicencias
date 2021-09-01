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


import com.aquarius.app.models.entity.Usuario;


import com.aquarius.app.models.service.IUsuarioService;
@RestController
@RequestMapping("/Usuario")
@CrossOrigin(origins="*")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;

	
	@GetMapping("/find/listado")
	public List<Usuario> index() {
	return usuarioService.findAll();
		}
	@GetMapping("/{user}/{pass}")
	public Usuario findbyUser( @PathVariable String user,@PathVariable String pass) {
	
		return usuarioService.ValidarUsuario(user, pass);
		}

	@GetMapping("/find/ruc/{ruc}/{page}")
	public Page<Usuario> findRuc(@PathVariable String ruc, @PathVariable int page) {
		Pageable pageable=PageRequest.of(page, 5);
	return usuarioService.findByCodigoruc(ruc, pageable);
		}
	
	@GetMapping("/find/razonsocial/{razonsocial}/{page}")
	public Page<Usuario> findRazonSocial(@PathVariable String razonsocial, @PathVariable int page) {
		Pageable pageable=PageRequest.of(page, 5);
	return usuarioService.findByRazonsocial(razonsocial,pageable);
		}
	@GetMapping("/find/estado/page/{page}")
	public Page<Usuario> findbyEstado(@PathVariable int page) {
		Pageable pageable=PageRequest.of(page, 5);
	return usuarioService.findAllEstado(pageable);
		}
	
	@GetMapping("/find/page/{page}")
	public Page<Usuario> index(@PathVariable Integer page) {
		Pageable pageable=PageRequest.of(page, 5);
	return usuarioService.findAll(pageable);
		}
	
	@GetMapping("/find/codusuario/{codusuario}")
	public ResponseEntity<?> show(@PathVariable String codusuario){
		Usuario usuario= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			 usuario=usuarioService.findById(codusuario);
			
		}catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la busqueda de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(usuario==null) {
			respuesta.put("Mensaje","El usuario de ID: ".concat(codusuario.concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
	
	return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
	
	@PostMapping("/post")
	public ResponseEntity<?> addEmpresa(@RequestBody Usuario usuario) {
		Usuario usuarioNuevo= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			usuarioNuevo=usuarioService.SaveUsuario(usuario);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito el nuevo usuario");
		respuesta.put("Empresa", usuarioNuevo);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		}
	
	
	@DeleteMapping(value="/find/codusuario/{codusuario}")
	public ResponseEntity<?> eliminar(@PathVariable("codusuario") String codusuario) {
		Map<String,Object> respuesta= new HashMap<>();
		try {
			usuarioService.deleteUsuario(codusuario);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el delete en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		respuesta.put("Mensaje","El usuario ha sido eliminada!");
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.OK);
			
		}
	
	@PutMapping("/find/codusuario/{codusuario}")
	public ResponseEntity<?> updateEmpresa(@RequestBody Usuario usuario,@PathVariable String codusuario) {
		Usuario usuarioActualizado=null;
		Map<String,Object> respuesta= new HashMap<>();
		Usuario usuarioActual=usuarioService.findById(codusuario);
		if(usuarioActual==null) {
			respuesta.put("Mensaje","el usuario de ID: ".concat(codusuario.concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
		try {
			
			usuarioActual.setCodusuario(usuario.getCodusuario());
			usuarioActual.setNomusuario(usuario.getNomusuario());
			usuarioActual.setDespassword(usuario.getDespassword());
			usuarioActual.setIndbaja(usuario.getIndbaja());
			usuarioActual.setCodperfil(usuario.getCodperfil());
			usuarioActual.setCodempresa(usuario.getCodempresa());
			usuarioActual.setCodcontrato(usuario.getCodcontrato());
			//usuarioActual.setContrato(licenciaService.findById(usuario.getCodcontrato()));
			usuarioActualizado=usuarioService.SaveUsuario(usuarioActual);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar la actualizacion en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se actualizo con Exito el usuario");
		respuesta.put("Empresa", usuarioActualizado);
		
		return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.CREATED);
		
		
	}
}
