package com.aquarius.app.models.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aquarius.app.models.dao.IMaeUsuarioDao;
import com.aquarius.app.models.dao.IUsuarioDao;
import com.aquarius.app.models.entity.MaeUsuario;
import com.aquarius.app.models.entity.face.IUsuarioFace;
import com.aquarius.app.models.service.IUsuarioService;
@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao userDao;
	
	@Autowired
	private IMaeUsuarioDao usuarioDao;
	
	@Override
	public List<MaeUsuario> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public MaeUsuario findById(String codusuario) {
		// TODO Auto-generated method stub
		return userDao.findById(codusuario).orElse(null);
	}

	@Override
	public Page<MaeUsuario> findByCodigoruc(String ruc, Pageable pageable) {
		// TODO Auto-generated method stub
		return userDao.findByRuc(ruc, pageable);
	}

	@Override
	public Page<MaeUsuario> findByRazonsocial(String razonsocial, Pageable pageable) {
		// TODO Auto-generated method stub
		return userDao.findByRazonsocial(razonsocial, pageable);
	}

	@Override
	public Page<MaeUsuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return userDao.findAll(pageable);
	}

	@Override
	public Page<MaeUsuario> findAllEstado(Pageable pageable) {
		// TODO Auto-generated method stub
		return userDao.findByEstado(pageable);
	}

	@Override
	public MaeUsuario SaveUsuario(MaeUsuario usuario) {
		// TODO Auto-generated method stub
		return userDao.save(usuario);
	}

	@Override
	public void deleteUsuario(String codusuario) {
		// TODO Auto-generated method stub
		userDao.deleteById(codusuario);
	}

	@Override
	public MaeUsuario ValidarUsuario(String user, String pass) {
		// TODO Auto-generated method stub
		return userDao.validarUser(user, pass);
	}

	@Override
	public Boolean save(MaeUsuario usuario) {
		usuario.setEstado(true);
		MaeUsuario usuarioN = usuarioDao.save(usuario);
		if(usuarioN != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public MaeUsuario findByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsuario(usuario);
	}

	@Override
	public List<IUsuarioFace> findAllUsuarioFace() {
		// TODO Auto-generated method stub
		return usuarioDao.findAllUsuarioFace();
	}

	@Override
	public List<IUsuarioFace> listUsuarioFaceByNombre(String search) {
		// TODO Auto-generated method stub
		return usuarioDao.listUsuarioFaceByNombre(search);
	}

	@Override
	public IUsuarioFace findUsuarioFaceByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findUsuarioFaceByUsuario(usuario);
	}

	@Override
	public int disableUsuario(String usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.disableUsuario(usuario);
	}

	@Override
	public int enableUsuario(String usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.enableUsuario(usuario);
	}

	@Override
	public int findCountUsuario(String usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findCountUsuario(usuario);
	}

	

}
