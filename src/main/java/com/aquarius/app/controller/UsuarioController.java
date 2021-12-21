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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.aquarius.app.models.entity.MaeUsuario;
import com.aquarius.app.models.entity.face.IUsuarioFace;
import com.aquarius.app.models.service.IEmpresaService;
import com.aquarius.app.models.service.IUsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	/*@Autowired
	private IEmpresaService empresaService;*/
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/find/listado")
	public List<MaeUsuario> index() {
	return usuarioService.findAll();
		}
	@GetMapping("/{user}/{pass}")
	public MaeUsuario findbyUser( @PathVariable String user,@PathVariable String pass) {
		return usuarioService.ValidarUsuario(user, pass);
	}
	@GetMapping("/find/name/{name}")
	public List<MaeUsuario> findName(@PathVariable String name ) {
		
		return usuarioService.findbyname(name);
	}
	@GetMapping("/find/ruc/{ruc}")
	public List<MaeUsuario> findRuc(@PathVariable String ruc ) {
		
		return usuarioService.findByCodigoruc(ruc);
	}
	
	@GetMapping("/find/razonsocial/{razonsocial}")
	public List<MaeUsuario> findRazonSocial(@PathVariable String razonsocial) {
		return usuarioService.findByRazonsocial(razonsocial);
	}
	
	@GetMapping("/find/estado")
	public List<MaeUsuario> findbyEstado() {
		return usuarioService.findAllEstado();
	}
	
	@GetMapping("/find/page/{page}")
	public Page<MaeUsuario> index(@PathVariable Integer page) {
		Pageable pageable=PageRequest.of(page, 5);
		return usuarioService.findAll(pageable);
	}
	
	@GetMapping("/find/codusuario/{codusuario}")
	public ResponseEntity<?> show(@PathVariable String codusuario){
		MaeUsuario usuario= null;
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
	
		return new ResponseEntity<MaeUsuario>(usuario, HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> addEmpresa(@RequestBody MaeUsuario usuario) {
		MaeUsuario usuarioNuevo= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			//usuario.setEmpresa(empresaService.findById(usuario.getCodempresa()));
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
	public ResponseEntity<?> updateEmpresa(@RequestBody MaeUsuario usuario,@PathVariable String codusuario) {
		MaeUsuario usuarioActualizado=null;
		Map<String,Object> respuesta= new HashMap<>();
		MaeUsuario usuarioActual=usuarioService.findById(codusuario);
		if(usuarioActual==null) {
			respuesta.put("Mensaje","el usuario de ID: ".concat(codusuario.concat("  No existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.NOT_FOUND);		
		}
		try {
			usuarioActual.setUsuario(usuario.getUsuario());
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setPassword(usuario.getPassword());
			usuarioActual.setEstado(usuario.getEstado());
			usuarioActual.setPerfil(usuario.getPerfil());
			//usuarioActual.setCodempresa(usuario.getCodempresa());
			//usuarioActual.setEmpresa(empresaService.findById(usuario.getCodempresa()));
			
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
	
	@GetMapping("find/usuario/{usuario}")
	public IUsuarioFace findIUsuarioFaceByUsuario(@PathVariable String usuario) {
		return usuarioService.findUsuarioFaceByUsuario(usuario);
	}
	
	@GetMapping("/list/nombre/{search}")
	public List<IUsuarioFace> listIUsuarioFaceByNombre(@PathVariable String search){
		return usuarioService.listUsuarioFaceByNombre(search);
	}
	
	@GetMapping("list")
	public List<IUsuarioFace> findAll(){
		return usuarioService.findAllUsuarioFace();
	}
	
	@PostMapping("save")
	@ResponseBody
	public Boolean save(@RequestBody MaeUsuario usuario) {
		
		if(usuario.getSyncccostos() == null) {
			usuario.setSyncccostos(false);
		}
		
		if(usuario.getSynctiplanilla() == null) {
			usuario.setSynctiplanilla(false);
		}
		
		if(usuario.getSyncareas() == null ) {
			usuario.setSyncareas(false);
		}
		
		if(usuario.getPassword() != null && usuario.getPassword() != "") {
			String password = passwordEncoder.encode(usuario.getPassword());
			usuario.setPassword(password);	
		}else {
			MaeUsuario user = usuarioService.findByUsuario(usuario.getUsuario());
			usuario.setPassword(user.getPassword());
		}
		return usuarioService.save(usuario);
	}
	
	@GetMapping("/disable/id/{usuario}")
	public int disableUsuario(@PathVariable String usuario){
		return usuarioService.disableUsuario(usuario);
	}
	
	@GetMapping("/enable/id/{usuario}")
	public int enableUsuario(@PathVariable String usuario){
		return usuarioService.enableUsuario(usuario);
	}
	
	@GetMapping("/findcount/usuario/{usuario}")
	public int findCountUsuario(@PathVariable String usuario) {
		return usuarioService.findCountUsuario(usuario);
	}
	
}
