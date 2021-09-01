package com.aquarius.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import com.aquarius.app.models.entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();

	public Usuario SaveUsuario(Usuario usuario);

	public void deleteUsuario(String codusuario);

	public Usuario findById(String codusuario);
	
	public Page< Usuario> findByCodigoruc(String ruc,Pageable pageable);
	
	public Page< Usuario> findByRazonsocial(String razonsocial,Pageable pageable);
	
	public Page<Usuario> findAll(Pageable pageable);
	public Page<Usuario> findAllEstado(Pageable pageable);
	public Usuario ValidarUsuario(String user,String pass);

}
