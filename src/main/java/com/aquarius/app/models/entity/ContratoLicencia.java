package com.aquarius.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRATO_LICENCIA")
public class ContratoLicencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="cod_empresa")
	private Long codempresa;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_empresa", referencedColumnName="id", insertable = false, updatable = false)
    private Empresa empresa;
	
	@Column(name="cod_sistema")
	private Long codsistema;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_sistema", referencedColumnName="id", insertable = false, updatable = false)
    private Sistema sistema;
	
	@Column(name="cod_conexion")
	private Long codconexion;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_conexion", referencedColumnName="id", insertable = false, updatable = false)
    private ConexionServidor conexion;
	
	@Column(name="fecha_ini_contrato")
	private Date fechainicontrato;
	
	@Column(name="fecha_fin_contrato")
	private Date fechafincontrato;
	
	@Column(name="estado")
	private Boolean estado;
	
	@Column(name="token")
	private String token;
	
	@Column(name="cant_activos")
	private Long cantactivos;
	
	@Column(name="cant_usuarios")
	private Long cantusuarios;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodempresa() {
		return codempresa;
	}

	public void setCodempresa(Long codempresa) {
		this.codempresa = codempresa;
	}

	public Long getCodsistema() {
		return codsistema;
	}

	public void setCodsistema(Long codsistema) {
		this.codsistema = codsistema;
	}

	public Date getFechainicontrato() {
		return fechainicontrato;
	}

	public void setFechainicontrato(Date fechainicontrato) {
		this.fechainicontrato = fechainicontrato;
	}

	public Date getFechafincontrato() {
		return fechafincontrato;
	}

	public void setFechafincontrato(Date fechafincontrato) {
		this.fechafincontrato = fechafincontrato;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public Long getCodconexion() {
		return codconexion;
	}

	public void setCodconexion(Long codconexion) {
		this.codconexion = codconexion;
	}

	public ConexionServidor getConexion() {
		return conexion;
	}

	public void setConexion(ConexionServidor conexion) {
		this.conexion = conexion;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getCantactivos() {
		return cantactivos;
	}

	public void setCantactivos(Long cantactivos) {
		this.cantactivos = cantactivos;
	}

	public Long getCantusuarios() {
		return cantusuarios;
	}

	public void setCantusuarios(Long cantusuarios) {
		this.cantusuarios = cantusuarios;
	}

	
}
