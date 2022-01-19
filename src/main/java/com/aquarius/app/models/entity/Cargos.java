package com.aquarius.app.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AFI_CARGOS_EMP")
public class Cargos {
	@Id
	@Column(name = "COD_CARGO")
	private String codcargo ;
	
	@Column(name="DESC_CARGO")
	private String descargo;
	
	@Column(name="ESTADO_CARGO")
	private boolean estado;
	
	@Column(name="INV")
	private String inv;
	
	@Column(name="FEC_CREACION")
	private Date feccreacion;
	
	@Column(name="FEC_MODIFICACION")
	private Date fecmodificacion;
	
	@Column(name="COD_USUARIO_CREACION")
	private String codusuariocreacion;
	
	@Column(name="COD_USUARIO_MODIFICACION")
	private String codususariomodificacion;

	public String getCodcargo() {
		return codcargo;
	}

	public void setCodcargo(String codcargo) {
		this.codcargo = codcargo;
	}

	public String getDescargo() {
		return descargo;
	}

	public void setDescargo(String descargo) {
		this.descargo = descargo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
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

	public Date getFecmodificacion() {
		return fecmodificacion;
	}

	public void setFecmodificacion(Date fecmodificacion) {
		this.fecmodificacion = fecmodificacion;
	}

	public String getCodusuariocreacion() {
		return codusuariocreacion;
	}

	public void setCodusuariocreacion(String codusuariocreacion) {
		this.codusuariocreacion = codusuariocreacion;
	}

	public String getCodususariomodificacion() {
		return codususariomodificacion;
	}

	public void setCodususariomodificacion(String codususariomodificacion) {
		this.codususariomodificacion = codususariomodificacion;
	}
	
	
}
