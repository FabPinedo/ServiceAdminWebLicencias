package com.aquarius.app.models.entity;

public class ContratoLicenciaEncrypt {
	
	private String id;
	private String codempresa;
	
    private Empresa empresa;
	
	private String codsistema;
	
    private Sistema sistema;
	
	private String codconexion;
	
    private ConexionServidor conexion;
	
	private String fechainicontrato;
	
	private String fechafincontrato;
	
	private String estado;
	
	private String token;
	
	private String cantactivos;
	
	private String cantusuarios;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodempresa() {
		return codempresa;
	}

	public void setCodempresa(String codempresa) {
		this.codempresa = codempresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getCodsistema() {
		return codsistema;
	}

	public void setCodsistema(String codsistema) {
		this.codsistema = codsistema;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	public String getCodconexion() {
		return codconexion;
	}

	public void setCodconexion(String codconexion) {
		this.codconexion = codconexion;
	}

	public ConexionServidor getConexion() {
		return conexion;
	}

	public void setConexion(ConexionServidor conexion) {
		this.conexion = conexion;
	}

	public String getFechainicontrato() {
		return fechainicontrato;
	}

	public void setFechainicontrato(String fechainicontrato) {
		this.fechainicontrato = fechainicontrato;
	}

	public String getFechafincontrato() {
		return fechafincontrato;
	}

	public void setFechafincontrato(String fechafincontrato) {
		this.fechafincontrato = fechafincontrato;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCantactivos() {
		return cantactivos;
	}

	public void setCantactivos(String cantactivos) {
		this.cantactivos = cantactivos;
	}

	public String getCantusuarios() {
		return cantusuarios;
	}

	public void setCantusuarios(String cantusuarios) {
		this.cantusuarios = cantusuarios;
	}

}
