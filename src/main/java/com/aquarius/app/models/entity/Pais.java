package com.aquarius.app.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AFI_PAISES")
public class Pais {
	
	@Id
	@Column(name = "COD_PAIS")
	private String codpais ;
	
	@Column(name="NOM_PAIS")
	private String nompais;
	
	@Column(name="ESTADO")
	private boolean estado;
	
	@Column(name="FEC_CREACION")
	private Date feccreacion;
	
	@Column(name="INV")
	private String inv;
	
	@Column(name="ST_ANULADO")
	private String stanulado;

	public String getCodpais() {
		return codpais;
	}

	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}

	public String getNompais() {
		return nompais;
	}

	public void setNompais(String nompais) {
		this.nompais = nompais;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getFeccreacion() {
		return feccreacion;
	}

	public void setFeccreacion(Date feccreacion) {
		this.feccreacion = feccreacion;
	}

	public String getInv() {
		return inv;
	}

	public void setInv(String inv) {
		this.inv = inv;
	}

	public String getStanulado() {
		return stanulado;
	}

	public void setStanulado(String stanulado) {
		this.stanulado = stanulado;
	}

	
	
}
