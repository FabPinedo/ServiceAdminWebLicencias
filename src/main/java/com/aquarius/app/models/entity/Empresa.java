package com.aquarius.app.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LICENCIA_EMPRESA")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="codigo_ruc")
	private String codigoruc;
	
	@Column(name="nom_empresa")
	private String nomempresa;
	
	@Column(name="razon_social")
	private String razonsocial;
	
	@Column(name="nom_comercial")
	private String nomcomercial;
	
	@Column(name="ind_baja")
	private Boolean indbaja;
	
	@Column(name="fecha_baja")
	private Date fechabaja;
	
	@Column(name="fec_creacion")
	private Date feccreacion;
	
	@Column(name="principal")
	private Boolean principal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoruc() {
		return codigoruc;
	}

	public void setCodigoruc(String codigoruc) {
		this.codigoruc = codigoruc;
	}

	public String getNomempresa() {
		return nomempresa;
	}

	public void setNomempresa(String nomempresa) {
		this.nomempresa = nomempresa;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getNomcomercial() {
		return nomcomercial;
	}

	public void setNomcomercial(String nomcomercial) {
		this.nomcomercial = nomcomercial;
	}

	public Boolean getIndbaja() {
		return indbaja;
	}

	public void setIndbaja(Boolean indbaja) {
		this.indbaja = indbaja;
	}

	public Date getFechabaja() {
		return fechabaja;
	}

	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}

	public Date getFeccreacion() {
		return feccreacion;
	}

	public void setFeccreacion(Date feccreacion) {
		this.feccreacion = feccreacion;
	}

	public Boolean getPrincipal() {
		return principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	
	
}
