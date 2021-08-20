package com.aquarius.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LICENCIA_SISTEMA")
public class Sistema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="sistema")
	private String sistema;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="num_version")
	private String numversion;
	
	@Column(name="ind_baja")
	private Boolean indbaja;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumversion() {
		return numversion;
	}

	public void setNumversion(String numversion) {
		this.numversion = numversion;
	}

	public Boolean getIndbaja() {
		return indbaja;
	}

	public void setIndbaja(Boolean indbaja) {
		this.indbaja = indbaja;
	}

}
