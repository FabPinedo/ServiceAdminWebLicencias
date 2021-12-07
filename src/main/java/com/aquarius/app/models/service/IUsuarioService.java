package com.aquarius.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.aquarius.app.models.entity.MaeUsuario;
import com.aquarius.app.models.entity.face.IUsuarioFace;

public interface IUsuarioService {
	public List<MaeUsuario> findAll();
	public MaeUsuario SaveUsuario(MaeUsuario usuario);
	public void deleteUsuario(String codusuario);
	public MaeUsuario findById(String codusuario);
	public Page<MaeUsuario> findByCodigoruc(String ruc,Pageable pageable);
	public Page<MaeUsuario> findByRazonsocial(String razonsocial,Pageable pageable);
	public Page<MaeUsuario> findAll(Pageable pageable);
	public Page<MaeUsuario> findAllEstado(Pageable pageable);
	public MaeUsuario ValidarUsuario(String user,String pass);
	
	public Boolean save(MaeUsuario usuario);
	public MaeUsuario findByUsuario(String usuario);
	public List<IUsuarioFace> findAllUsuarioFace();
	public List<IUsuarioFace> listUsuarioFaceByNombre(String search);
	public IUsuarioFace findUsuarioFaceByUsuario(String usuario);
	public int disableUsuario(String usuario);
	public int enableUsuario(String usuario);
	public int findCountUsuario(String usuario);

}
