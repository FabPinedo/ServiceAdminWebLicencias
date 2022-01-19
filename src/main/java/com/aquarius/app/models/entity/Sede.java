package com.aquarius.app.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LICENCIA_SEDE")
public class Sede {
	@Id
	@Column(name = "COD_SEDE")
	private String codsede;
	
	@Column(name="COD_EMPRESA")
	private Long codempresa;
	
	@Column(name="DESC_SEDE")
	private String descripcion;
	
	@Column(name="ESTADO")
	private boolean estado;
	
	@Column(name="FEC_CREACION")
	private Date feccreacion;

	public String getCodsede() {
		return codsede;
	}

	public void setCodsede(String codsede) {
		this.codsede = codsede;
	}

	public Long getCodempresa() {
		return codempresa;
	}

	public void setCodempresa(Long codempresa) {
		this.codempresa = codempresa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean getEstado() {
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

	@Override
	public String toString() {
		return "Sede [codsede=" + codsede + ", codempresa=" + codempresa + ", descripcion=" + descripcion + ", estado="
				+ estado + ", feccreacion=" + feccreacion + "]";
	}
	
	
	
}
