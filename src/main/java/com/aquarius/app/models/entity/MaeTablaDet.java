package com.aquarius.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mae_tabla_det")
public class MaeTablaDet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "tip_tabla")
	private String tiptabla;
	
	@Column(name = "des_corta")
	private String descorta;
	
	@Column(name = "des_larga")
	private String deslarga;
	
	@Column(name = "cod_var")
	private String codvar;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@Transient
	private Boolean revision;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTiptabla() {
		return tiptabla;
	}

	public void setTiptabla(String tiptabla) {
		this.tiptabla = tiptabla;
	}

	public String getDeslarga() {
		return deslarga;
	}

	public void setDeslarga(String deslarga) {
		this.deslarga = deslarga;
	}

	public String getDescorta() {
		return descorta;
	}

	public void setDescorta(String descorta) {
		this.descorta = descorta;
	}

	public Boolean getRevision() {
		return revision;
	}

	public void setRevision(Boolean revision) {
		this.revision = revision;
	}

	public String getCodvar() {
		return codvar;
	}

	public void setCodvar(String codvar) {
		this.codvar = codvar;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
}

