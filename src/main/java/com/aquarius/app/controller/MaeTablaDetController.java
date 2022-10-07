package com.aquarius.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aquarius.app.models.entity.Empresa;
import com.aquarius.app.models.entity.MaeTablaDet;
import com.aquarius.app.models.service.IMaeTablaDetService;

@RestController
//@CrossOrigin(origins="http://localhost:4200" )
@RequestMapping("/tabladet")
public class MaeTablaDetController {
	@Autowired
	private IMaeTablaDetService tablaService; 
	/*
	//VACUNACION
	
	@GetMapping("list/agentcausante")
	public List<MaeTablaDet> findAllAgenteCausante(){
		return tablaService.findAllByCodigo(Parametros.COD_AGENTE_CAUSANTE);
	}
	
	@GetMapping("list/cie")
	public List<MaeTablaDet> findAllCie(){
		return tablaService.findAllByCodigo(Parametros.COD_CIE);
	}
	
	@GetMapping("list/gravacci")
	public List<MaeTablaDet> findAllGreavedaAccidente() {
		return tablaService.findAllByCodigo(Parametros.COD_GRAVEDAD_ACCIDENTE);
	}
	
	@GetMapping("list/partafect")
	public List<MaeTablaDet> findAllParteAfectada() {
		return tablaService.findAllByCodigo(Parametros.COD_PARTE_AFECTADO);
	}
	
	@GetMapping("list/tipacci")
	public List<MaeTablaDet> findAllTipoAccidente() {
		return tablaService.findAllByCodigo(Parametros.COD_TIPO_ACCIDENTE);
	}
	
	@GetMapping("list/tipless")
	public List<MaeTablaDet> findAllTipoLesion() {
		return tablaService.findAllByCodigo(Parametros.COD_TIPO_LESION);
	}
	
	@GetMapping("list/estadoacc")
	public List<MaeTablaDet> findAllEstadoAcc() {
		return tablaService.findAllByCodigo(Parametros.COD_ESTADO);
	}
	
	@GetMapping("list/mes")
	public List<MaeTablaDet> findAllMes() {
		return tablaService.findAllByCodigo(Parametros.COD_MES);
	}
	
	@GetMapping("list/tipovacuna")
	public List<MaeTablaDet> findAllTipoVacuna() {
		return tablaService.findAllByCodigo(Parametros.COD_TIPO_VACUNA);
	}
	
	@GetMapping("list/vacunador")
	public List<MaeTablaDet> findAllVacunador() {
		return tablaService.findAllByCodigo(Parametros.COD_VACUNADOR);
	}
	
	@GetMapping("list/zonavacu")
	public List<MaeTablaDet> findAllZonaVacunacion() {
		return tablaService.findAllByCodigo(Parametros.COD_ZONA_VACUNACION);
	}
	
	@GetMapping("list/grupoareas")
	public List<MaeTablaDet> findAllGrupoAreas() {
		return tablaService.findAllByCodigo(Parametros.COD_GRUPO_AREA);
	}
	
	//EMO
	
	@GetMapping("list/proveedor")
	public List<MaeTablaDet> findAllProveedor() {
		return tablaService.findAllByCodigo(Parametros.COD_PROVEEDOR);
	}
	
	@GetMapping("list/estdproemo")
	public List<MaeTablaDet> findAllEstadoProEmo() {
		return tablaService.findAllByCodigo(Parametros.COD_EST_PROGRAM_EMO);
	}
	
	@GetMapping("list/tpevaluacion")
	public List<MaeTablaDet> findAllTipoEvaluacionEmo() {
		return tablaService.findAllByCodigo(Parametros.COD_TIPO_EVA);
	}
	
	@GetMapping("list/grupofact")
	public List<MaeTablaDet> findAllGrupoFactor() {
		return tablaService.findAllByCodigo(Parametros.EMO_COD_GRUPO_FACTOR);
	}
	
	@GetMapping("list/psis")
	public List<MaeTablaDet> findAllPresionSistolica() {
		return tablaService.findAllByCodigo(Parametros.EMO_COD_PRESION_SISTOLICA);
	}
	
	@GetMapping("list/psdi")
	public List<MaeTablaDet> findAllPresionDiastolica() {
		return tablaService.findAllByCodigo(Parametros.EMO_COD_PRESION_DIASTOLICA);
	}
	
	@GetMapping("list/enut")
	public List<MaeTablaDet> findAllEstadoNutricional() {
		return tablaService.findAllByCodigo(Parametros.EMO_COD_ESTD_NUTRICIONAL);
	}
	
	@GetMapping("list/apti")
	public List<MaeTablaDet> findAllAptitudMedica() {
		return tablaService.findAllByCodigo(Parametros.EMO_COD_APTITUP_MEDICA);
	}
	
	@GetMapping("list/moti")
	public List<MaeTablaDet> findAllMotivoCapacitacion() {
		return tablaService.findAllByCodigo(Parametros.COD_MOTIVO_CAP);
	}
	
	@GetMapping("list/tcap")
	public List<MaeTablaDet> findAllTipoCapacitacion() {
		return tablaService.findAllByCodigo(Parametros.COD_TIPO_CAP);
	}
	
	@GetMapping("list/tema")
	public List<MaeTablaDet> findAllTemaCapacitacion() {
		return tablaService.findAllByCodigo(Parametros.COD_TEMA_CAP);
	}
	
	@GetMapping("list/actoin")
	public List<MaeTablaDet> findAllActoInSeg() {
		return tablaService.findAllByCodigo(Parametros.COD_ACT_INSE);
	}
	
	@GetMapping("list/actoin/acci/{codacci}")
	public List<MaeTablaDet> findAllActoInSegPara(@PathVariable Long codacci) {
		return tablaService.findAllByCodigoOutDet(Parametros.COD_ACT_INSE, codacci);
	}
	
	@GetMapping("list/condin")
	public List<MaeTablaDet> findAllCondInSeg() {
		return tablaService.findAllByCodigo(Parametros.COD_COND_INSE);
	}
	
	@GetMapping("list/condin/acci/{condin}")
	public List<MaeTablaDet> findAllCondInSegPara(@PathVariable Long codin) {
		return tablaService.findAllByCodigoOutDet(Parametros.COD_COND_INSE, codin);
	}
	
	@GetMapping("list/fala")
	public List<MaeTablaDet> findAllFalabo() {
		return tablaService.findAllByCodigo(Parametros.COD_FACT_LABO);
	}
	
	@GetMapping("list/fala/acci/{codfala}")
	public List<MaeTablaDet> findAllFalaboPara(@PathVariable Long codfala) {
		return tablaService.findAllByCodigoOutDet(Parametros.COD_FACT_LABO, codfala);
	}
	
	@GetMapping("list/fape")
	public List<MaeTablaDet> findAllFaPers() {
		return tablaService.findAllByCodigo(Parametros.COD_FACT_PERS);
	}
	
	@GetMapping("list/fala/acci/{codfape}")
	public List<MaeTablaDet> findAllFaPersPara(@PathVariable Long codfape) {
		return tablaService.findAllByCodigoOutDet(Parametros.COD_FACT_PERS, codfape);
	}
	
	//MEDIDA CORRECTIVA
	
	@GetMapping("list/medida/estado")
	public List<MaeTablaDet> findAllEstadosMedidaCorrectiva() {
		return tablaService.findAllByCodigo(Parametros.COD_EST_MED);
	}
	
	@GetMapping("list/leva/estado")
	public List<MaeTablaDet> findAllEstadosLevantamientoMed() {
		return tablaService.findAllByCodigo(Parametros.COD_EST_LEV);
	}
	
	@GetMapping("list/capa/notas")
	public List<MaeTablaDet> findAllCapaNotas() {
		return tablaService.findAllByCodigo(Parametros.COD_CAPA_NOTA);
	}
	
	@GetMapping("list/comi/cargos")
	public List<MaeTablaDet> findAllComiteCargos() {
		return tablaService.findAllByCodigo(Parametros.COD_COMI_CARGOS);
	}*/
	
	//ALL
	
	@GetMapping("find/id/{id}")
	public MaeTablaDet findById(@PathVariable Long id) {
		return tablaService.findById(id);
	}
	
	@PostMapping("save")
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody MaeTablaDet maetabladet) {
		MaeTablaDet tabladet= null;
		Map<String,Object> respuesta= new HashMap<>();
		try {
			int count = tablaService.findByTipTablaAndDescorta(maetabladet.getTiptabla(), maetabladet.getDescorta());
			if(count > 0 && maetabladet.getId() == null) {
				maetabladet.setRevision(false);
				maetabladet.setEstado(true);
				return null;
			}else {
				maetabladet.setRevision(false);
				maetabladet.setEstado(true);
			}
			tabladet=tablaService.save(maetabladet);
		} catch (DataAccessException e) {
			// TODO: handle exception
			respuesta.put("Mensaje","Error al realizar el insert en base de datos");
			respuesta.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respuesta.put("Mensaje","Se ha creado con Exito la nueva empresa");
		respuesta.put("tabladet", tabladet);
		
		return new ResponseEntity<Map<String,Object >>(respuesta,HttpStatus.CREATED);
		}
		
	

	@GetMapping("delete/id/{id}")
	public Long deleteById(@PathVariable Long id) {
		tablaService.deleteById(id);
		return 1L;
	}
	
	@GetMapping("list/tabcod/{codigo}")
	public List<MaeTablaDet> findAllByTablaCodigo(@PathVariable String codigo) {
		return tablaService.findAllByCodigo(codigo);
	}
	/*
	@GetMapping("list/tipdoc")
	public List<MaeTablaDet> findAllTipoDoc() {
		return tablaService.findAllByCodigo(Parametros.COD_TIPO_DOCUMENTO);
	}
	
	@GetMapping("list/tipsexo")
	public List<MaeTablaDet> findAllTipoSexo() {
		return tablaService.findAllByCodigo(Parametros.COD_TIPO_SEXO);
	}*/
}
