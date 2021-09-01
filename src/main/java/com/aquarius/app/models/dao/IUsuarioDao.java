package com.aquarius.app.models.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.aquarius.app.models.entity.Usuario;



public interface IUsuarioDao extends JpaRepository<Usuario, String>{
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_USUARIO A \r\n"
			+ "INNER JOIN LICENCIAS_USUARIO_EMPRESA B  ON B.COD_USUARIO=A.COD_USUARIO \r\n"
			+ "INNER JOIN CONTRATO_LICENCIA C ON B.COD_CONTRATO=C.ID\r\n"
			+ "INNER JOIN LICENCIA_EMPRESA D ON D.ID=C.COD_EMPRESA\r\n"
			+ " WHERE D.RAZON_SOCIAL like %:razonsocial%")
	public Page< Usuario> findByRazonsocial(@Param("razonsocial") String razonsocial,Pageable pageable);
	
	
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_USUARIO A \r\n"
			+ "INNER JOIN LICENCIAS_USUARIO_EMPRESA B  ON B.COD_USUARIO=A.COD_USUARIO \r\n"
			+ "INNER JOIN CONTRATO_LICENCIA C ON B.COD_CONTRATO=C.ID\r\n"
			+ "INNER JOIN LICENCIA_EMPRESA D ON D.ID=C.COD_EMPRESA\r\n"
			+ "WHERE D.CODIGO_RUC LIKE %:ruc%")
	public Page< Usuario> findByRuc(@Param("ruc") String ruc,Pageable pageable);
	
	
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_USUARIO A \r\n"
			+ "INNER JOIN LICENCIAS_USUARIO_EMPRESA B  ON B.COD_USUARIO=A.COD_USUARIO \r\n"
			+ "WHERE A.IND_BAJA =0")
	public Page< Usuario> findByEstado(Pageable pageable);
	

	
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_USUARIO A \r\n"
			+ "INNER JOIN LICENCIAS_USUARIO_EMPRESA B  ON B.COD_USUARIO=A.COD_USUARIO \r\n"
			+ "INNER JOIN CONTRATO_LICENCIA C ON B.COD_CONTRATO=C.ID\r\n"
			+ "INNER JOIN LICENCIA_EMPRESA D ON D.ID=C.COD_EMPRESA\r\n"
			+"WHERE A.COD_USUARIO=:usuario AND A.DES_PASSWORD=:pass ")
	public Usuario validarUser(@Param("usuario") String usuario,@Param("pass") String pass);
	
	
}
