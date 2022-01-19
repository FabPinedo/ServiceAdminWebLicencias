package com.aquarius.app.models.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "AFI_UBIGEO")
public class Ubigeo {
	
	
	@Id
	@Column(name = "COD_UBIGEO")
	private String codubigeo ;
	
	@Column(name="COD_COMPANIA")
	private String codcompania;
	
	@Column(name="ESTADO")
	private boolean estado;
	
	@Column(name="DES_UBIGEO")
	private String desubigeo;
	@Column(name="DES_UBIGEO_CAPITAL")
	private String desubigeocapital;
	@Column(name="COD_UBIGEOP")
	private String codubigeop;
	
	@Column(name="COD_UBIGEO_RENIEC")
	private String codubigeoreniec;
	
	@Column(name="NUM_VER_UBIGEO")
	private String numverubigeo;
	
	@Column(name="NUM_NIVEL_ESTRUC")
	private int numnivelestruc;
	@Column(name="IND_ULTIMO_NIVEL")
	private String indultimonivel;
	@Column(name="NUM_VER_UBIGEO_SUPERIOR")
	private String numverubigeosuperior;
	@Column(name="COD_UBIGEO_SUPERIOR")
	private String codubigeosuperior;
	
	@Column(name="FEC_CREACION")
	private Date feccreacion;
	
	@Column(name="COD_USUARIO_CREACION")
	private String codusuariocreacion;

	public String getCodubigeo() {
		return codubigeo;
	}

	public void setCodubigeo(String codubigeo) {
		this.codubigeo = codubigeo;
	}

	public String getCodcompania() {
		return codcompania;
	}

	public void setCodcompania(String codcompania) {
		this.codcompania = codcompania;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getDesubigeo() {
		return desubigeo;
	}

	public void setDesubigeo(String desubigeo) {
		this.desubigeo = desubigeo;
	}

	public String getDesubigeocapital() {
		return desubigeocapital;
	}

	public void setDesubigeocapital(String desubigeocapital) {
		this.desubigeocapital = desubigeocapital;
	}

	public String getCodubigeop() {
		return codubigeop;
	}

	public void setCodubigeop(String codubigeop) {
		this.codubigeop = codubigeop;
	}

	public String getCodubigeoreniec() {
		return codubigeoreniec;
	}

	public void setCodubigeoreniec(String codubigeoreniec) {
		this.codubigeoreniec = codubigeoreniec;
	}

	public String getNumverubigeo() {
		return numverubigeo;
	}

	public void setNumverubigeo(String numverubigeo) {
		this.numverubigeo = numverubigeo;
	}

	public int getNumnivelestruc() {
		return numnivelestruc;
	}

	public void setNumnivelestruc(int numnivelestruc) {
		this.numnivelestruc = numnivelestruc;
	}

	public String getIndultimonivel() {
		return indultimonivel;
	}

	public void setIndultimonivel(String indultimonivel) {
		this.indultimonivel = indultimonivel;
	}

	public String getNumverubigeosuperior() {
		return numverubigeosuperior;
	}

	public void setNumverubigeosuperior(String numverubigeosuperior) {
		this.numverubigeosuperior = numverubigeosuperior;
	}

	public String getCodubigeosuperior() {
		return codubigeosuperior;
	}

	public void setCodubigeosuperior(String codubigeosuperior) {
		this.codubigeosuperior = codubigeosuperior;
	}

	public Date getFeccreacion() {
		return feccreacion;
	}

	public void setFeccreacion(Date feccreacion) {
		this.feccreacion = feccreacion;
	}

	public String getCodusuariocreacion() {
		return codusuariocreacion;
	}

	public void setCodusuariocreacion(String codusuariocreacion) {
		this.codusuariocreacion = codusuariocreacion;
	}
	

}
	
	
	
		      
