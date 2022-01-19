package com.aquarius.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aquarius.app.models.entity.MaeTablaDet;

public interface IMaeTablaDetDao  extends CrudRepository<MaeTablaDet, Long>{
	
	@Query(nativeQuery = true, value= "SELECT A.* FROM MAE_TABLA_DET A WHERE A.ESTADO = '1'")
	public List<MaeTablaDet> findAllActive();
	
	@Modifying
	@Query(value= "UPDATE MaeTablaDet SET ESTADO = '0' WHERE id = :id")
	public int disabledTablaDet(@Param("id") Long id);
	
	@Query(nativeQuery = true, value= "SELECT B.* \r\n"
			+ "FROM MAE_TABLA A INNER JOIN MAE_TABLA_DET B \r\n"
			+ "	ON A.TIP_TABLA = B.TIP_TABLA \r\n"
			+ "WHERE A.TIP_TABLA = :codigo AND B.ESTADO = '1'")
	public List<MaeTablaDet> findAllByCodigo(@Param("codigo") String codigo);
	
	/*@Query(nativeQuery = true, value= "SELECT A.* FROM MAE_TABLA_DET A WHERE A.DES_CORTA = :descorta")
	public MaeTablaDet findByDcorta(@Param("descorta") String descorta);*/
	
	@Query(nativeQuery = true, value= "SELECT A.* FROM MAE_TABLA_DET A \r\n"
			+ "WHERE A.TIP_TABLA = :tiptabla AND A.DES_CORTA = :descorta")
	public MaeTablaDet findByTipoAndDesCorta(@Param("tiptabla") String tiptabla, @Param("descorta") String descorta);
	
	@Query(nativeQuery = true, value= "SELECT * FROM MAE_TABLA_DET WHERE ID = :id AND TIP_TABLA = :tiptabla ")
	public MaeTablaDet findByTablaAndDetalle(@Param("tiptabla") String tiptabla, @Param("id") Long id);
	
	//ASEGURADORA
	@Query(nativeQuery = true, value= "SELECT TOP 1 * FROM MAE_TABLA_DET WHERE TIP_TABLA = :tiptabla")
	public MaeTablaDet findOneLastByTabla(@Param("tiptabla") String tiptabla);
	
	@Query(nativeQuery = true, value= "SELECT COUNT(*) FROM MAE_TABLA A INNER JOIN MAE_TABLA_DET B \r\n"
			+ "ON A.TIP_TABLA = B.TIP_TABLA WHERE B.TIP_TABLA = :tiptabla AND B.DES_CORTA = :descorta ")
	public int findByTipTablaAndDescorta(@Param("tiptabla") String tiptabla, @Param("descorta") String descorta);
	
	//LISTAR TABLA DETALLE VALIDANDO CAUSAS
	@Query(nativeQuery = true, value= "SELECT B.* FROM MAE_TABLA A INNER JOIN MAE_TABLA_DET B\r\n"
			+ "		ON A.TIP_TABLA = B.TIP_TABLA\r\n"
			+ "	INNER JOIN SSST_DET_ACCI_CAUSAS C\r\n"
			+ "		ON B.ID = C.COD_DETALLE\r\n"
			+ "WHERE A.TIP_TABLA = :codigo AND C.COD_ACCI = :codacci ")
	public List<MaeTablaDet> findAllByCodigoOutDet(@Param("codigo") String codigo, @Param("codacci") Long codacci);

}
