package com.aquarius.app.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AFI_UBICACIONES")
public class MaestroUbicacion {
	
	@Id
	@Column(name = "COD_UBICACION")
	private String codubicacion;
	@Column(name="MM1")
	private String mm1;
	@Column(name="DESC_UBICACION")
	private String descubicacion;
	@Column(name="DIRECCION")
	private String direccion;
	@Column(name="COD_PAIS")
	private String codpais;
	@Column(name="ESTADO")
	private boolean estado;
	@Column(name="PISO")
	private String piso;
	@Column(name="COD_TIPO_UBICACION")
	private String codtipoubicacion;
	@Column(name="COD_COMPANIA")
	private int codcompania;
	@Column(name="INV")
	private String inv;
	@Column(name="FEC_CREACION")
	private Date feccreacion;
	@Column(name="COD_ZONA")
	private String codzona;
	@Column(name="TSYSTEM")
	private String tsystem;
	@Column(name="TNONSYSTEM")
	private String tnonsystem;
	@Column(name="SITE")
	private String site;
	@Column(name="GRUPO")
	private String grupo;
	@Column(name="GRUPOREPAS")
	private String gruporepas;
	@Column(name="SINACCESO")
	private String sinacceso;
	@Column(name="OBSERVACIONES")
	private String observaciones;
	@Column(name="ID_CLASIF_UBI")
	private String idclasifubi;
	@Column(name="FEC_ONAIR")
	private Date feconair;
	@Column(name="COD_GRUPO_TORRE")
	private String codgrupotorre;
	@Column(name="COD_TIPO_TORRE")
	private String codtipotorre;
	@Column(name="CODIGO2_MIXTO")
	private String codigo2mixto;
	@Column(name="FLAG_PENDIENTE_INVENTARIO")
	private String flagpendienteinvetario;
	@Column(name="OBSERVACIONES_PENDIENTE")
	private String observacionespendiente;
	@Column(name="PREFIJO_UBICACION")
	private String prefrijoubicacione;
	@Column(name="CORRELATIVO_UBICACION")
	private String correlativoubicacion;
	@Column(name="ESTADO_SITE")
	private String estadosite;
	
	
	@Column(name="COD_DPTO")
	private String coddpto;
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_DPTO", referencedColumnName="COD_UBIGEO", insertable = false, updatable = false)
    private Ubigeo departamento;
	
	@Column(name="COD_PROV")
	private String codprov;
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_DIST", referencedColumnName="COD_UBIGEO", insertable = false, updatable = false)
    private Ubigeo provincia;
	
	
	@Column(name="COD_DIST")
	private String coddist;
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_DIST", referencedColumnName="COD_UBIGEO", insertable = false, updatable = false)
    private Ubigeo distrito;
	
	
	@Column(name="GEO_POSICION")
	private String geoposicion;
	@Column(name="REF_DIRECCION")
	private String refdireccion;
	@Column(name="PROPIETARIO")
	private String propietario;
	@Column(name="COD_SEDE")
	private String codsede;
	public String getCodubicacion() {
		return codubicacion;
	}
	public void setCodubicacion(String codubicacion) {
		this.codubicacion = codubicacion;
	}
	public String getMm1() {
		return mm1;
	}
	public void setMm1(String mm1) {
		this.mm1 = mm1;
	}
	public String getDescubicacion() {
		return descubicacion;
	}
	public void setDescubicacion(String descubicacion) {
		this.descubicacion = descubicacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodpais() {
		return codpais;
	}
	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getCodtipoubicacion() {
		return codtipoubicacion;
	}
	public void setCodtipoubicacion(String codtipoubicacion) {
		this.codtipoubicacion = codtipoubicacion;
	}
	public int getCodcompania() {
		return codcompania;
	}
	public void setCodcompania(int codcompania) {
		this.codcompania = codcompania;
	}
	public String getInv() {
		return inv;
	}
	public void setInv(String inv) {
		this.inv = inv;
	}
	public Date getFeccreacion() {
		return feccreacion;
	}
	public void setFeccreacion(Date feccreacion) {
		this.feccreacion = feccreacion;
	}
	public String getCodzona() {
		return codzona;
	}
	public void setCodzona(String codzona) {
		this.codzona = codzona;
	}
	public String getTsystem() {
		return tsystem;
	}
	public void setTsystem(String tsystem) {
		this.tsystem = tsystem;
	}
	public String getTnonsystem() {
		return tnonsystem;
	}
	public void setTnonsystem(String tnonsystem) {
		this.tnonsystem = tnonsystem;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getGruporepas() {
		return gruporepas;
	}
	public void setGruporepas(String gruporepas) {
		this.gruporepas = gruporepas;
	}
	public String getSinacceso() {
		return sinacceso;
	}
	public void setSinacceso(String sinacceso) {
		this.sinacceso = sinacceso;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getIdclasifubi() {
		return idclasifubi;
	}
	public void setIdclasifubi(String idclasifubi) {
		this.idclasifubi = idclasifubi;
	}
	public Date getFeconair() {
		return feconair;
	}
	public void setFeconair(Date feconair) {
		this.feconair = feconair;
	}
	public String getCodgrupotorre() {
		return codgrupotorre;
	}
	public void setCodgrupotorre(String codgrupotorre) {
		this.codgrupotorre = codgrupotorre;
	}
	public String getCodtipotorre() {
		return codtipotorre;
	}
	public void setCodtipotorre(String codtipotorre) {
		this.codtipotorre = codtipotorre;
	}
	public String getCodigo2mixto() {
		return codigo2mixto;
	}
	public void setCodigo2mixto(String codigo2mixto) {
		this.codigo2mixto = codigo2mixto;
	}
	public String getFlagpendienteinvetario() {
		return flagpendienteinvetario;
	}
	public void setFlagpendienteinvetario(String flagpendienteinvetario) {
		this.flagpendienteinvetario = flagpendienteinvetario;
	}
	public String getObservacionespendiente() {
		return observacionespendiente;
	}
	public void setObservacionespendiente(String observacionespendiente) {
		this.observacionespendiente = observacionespendiente;
	}
	public String getPrefrijoubicacione() {
		return prefrijoubicacione;
	}
	public void setPrefrijoubicacione(String prefrijoubicacione) {
		this.prefrijoubicacione = prefrijoubicacione;
	}
	public String getCorrelativoubicacion() {
		return correlativoubicacion;
	}
	public void setCorrelativoubicacion(String correlativoubicacion) {
		this.correlativoubicacion = correlativoubicacion;
	}
	public String getEstadosite() {
		return estadosite;
	}
	public void setEstadosite(String estadosite) {
		this.estadosite = estadosite;
	}
	public String getCoddpto() {
		return coddpto;
	}
	public void setCoddpto(String coddpto) {
		this.coddpto = coddpto;
	}
	public String getCodprov() {
		return codprov;
	}
	public void setCodprov(String codprov) {
		this.codprov = codprov;
	}
	public String getCoddist() {
		return coddist;
	}
	public void setCoddist(String coddist) {
		this.coddist = coddist;
	}
	public String getGeoposicion() {
		return geoposicion;
	}
	public void setGeoposicion(String geoposicion) {
		this.geoposicion = geoposicion;
	}
	public String getRefdireccion() {
		return refdireccion;
	}
	public void setRefdireccion(String refdireccion) {
		this.refdireccion = refdireccion;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public String getCodsede() {
		return codsede;
	}
	public void setCodsede(String codsede) {
		this.codsede = codsede;
	}
	public Ubigeo getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Ubigeo departamento) {
		this.departamento = departamento;
	}
	public Ubigeo getProvincia() {
		return provincia;
	}
	public void setProvincia(Ubigeo provincia) {
		this.provincia = provincia;
	}
	public Ubigeo getDistrito() {
		return distrito;
	}
	public void setDistrito(Ubigeo distrito) {
		this.distrito = distrito;
	}
	
	
	
	
	

	
		      
}
