package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aquarius.app.models.entity.Sede;
import com.aquarius.app.models.entity.Ubigeo;

public interface IUbigeoDao extends JpaRepository<Ubigeo,String> {
	@Query(nativeQuery = true, value= "SELECT A.* \r\n"
			+ "FROM AFI_UBIGEO A \r\n"
			+ "WHERE A.NUM_NIVEL_ESTRUC = 1")
	public List<Ubigeo> findAllDepartamentos();
	
	
	@Query(nativeQuery = true, value= "SELECT A.* \r\n"
			+ "FROM AFI_UBIGEO A \r\n"
			+ "WHERE A.NUM_NIVEL_ESTRUC = 2 AND A.COD_UBIGEOP =:codigo")
	public List<Ubigeo> findAllprovincias(@Param("codigo") String codigo);
	
	
	@Query(nativeQuery = true, value= "SELECT A.* \r\n"
			+ "FROM AFI_UBIGEO A \r\n"
			+ "WHERE A.NUM_NIVEL_ESTRUC = 3 AND A.COD_UBIGEOP =:codigo")
	public List<Ubigeo> findAllDistritos(@Param("codigo") String codigo);
}
