package com.aquarius.app.db2.InfoUser.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.aquarius.app.db2.InfoUser.entity.InfoUser;
import com.aquarius.app.models.entity.face.IInfoChartBarra;
import com.aquarius.app.models.entity.face.IInfoChartTorta;
import com.aquarius.app.models.entity.face.IInfoCharts;



public interface InfoUserDao extends JpaRepository<InfoUser, Long>{
	//cantidad de inventariado 
	
	@Query(nativeQuery = true, value= "select count(bar_nue)nro  from Inventario_final where condicionAbierto=0")
	public List<IInfoCharts> CantidadInventariado();
	
	/*@Query(nativeQuery = true, value= "select count_conci, count(bar_nue)nro \r\n"
			+ "from Inventario_final\r\n"
			+ "group by count_conci")
	public List<> NoseQuery();*/
	
	@Query(nativeQuery = true, value= " SELECT \r\n"
			+ "    (SELECT T2C2 FROM T2 WHERE T2=SUBSTRING(Inventario_final.T4,1,2))FAMILIA, COUNT(BAR_NUE)NRO_ACTIVOS\r\n"
			+ " from Inventario_final\r\n"
			+ " where condicionAbierto=0\r\n"
			+ " GROUP BY SUBSTRING(Inventario_final.T4,1,2)")
	public List<IInfoChartTorta> InfoGraficoTorta();
	
	@Query(nativeQuery = true, value= "  SELECT \r\n"
			+ " [LOCAL] , COUNT(BAR_NUE)NRO_ACTIVOS\r\n"
			+ " from Inventario_final \r\n"
			+ " INNER JOIN UBICACION ON UBICACION.M1=Inventario_final.M1 \r\n"
			+ "  where condicionAbierto=0\r\n"
			+ " GROUP BY  [LOCAL] ")
	public List<IInfoChartBarra> InfoGraficoBarra();
}
