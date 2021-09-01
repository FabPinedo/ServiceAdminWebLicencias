package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IUsuarioDao;

import com.aquarius.app.models.entity.Usuario;
import com.aquarius.app.models.service.IUsuarioService;
@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	public Usuario findById(String codusuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(codusuario).orElse(null);
	}

	@Override
	public Page<Usuario> findByCodigoruc(String ruc, Pageable pageable) {
		// TODO Auto-generated method stub
		return usuarioDao.findByRuc(ruc, pageable);
	}

	@Override
	public Page<Usuario> findByRazonsocial(String razonsocial, Pageable pageable) {
		// TODO Auto-generated method stub
		return usuarioDao.findByRazonsocial(razonsocial, pageable);
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return usuarioDao.findAll(pageable);
	}

	@Override
	public Page<Usuario> findAllEstado(Pageable pageable) {
		// TODO Auto-generated method stub
		return usuarioDao.findByEstado(pageable);
	}

	@Override
	public Usuario SaveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.save(usuario);
	}

	@Override
	public void deleteUsuario(String codusuario) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(codusuario);
	}

	@Override
	public Usuario ValidarUsuario(String user, String pass) {
		// TODO Auto-generated method stub
		return usuarioDao.validarUser(user, pass);
	}

	

}
