package com.aquarius.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "mae_usuario")
@SecondaryTable(name = "LICENCIAS_USUARIO_EMPRESA", pkJoinColumns = @PrimaryKeyJoinColumn(name = "COD_USUARIO"))
public class MaeUsuario {
	
	@Id
	@Column(name = "cod_usuario")
	private String usuario;
	
	@Column(name="cod_perfil")
	private Long perfil;
	
	@Column(name="nom_usuario")
	private String nombre;
	
	@Column(name="des_password")
	private String password;
	
	@Column(name="ind_baja")
	private Boolean estado;
	
	@Column(name="sync_ccostos")
	private Boolean syncccostos;
	
	@Column(name="sync_tip_planilla")
	private Boolean synctiplanilla;
	
	@Column(name="sync_areas")
	private Boolean syncareas;
	/*
	@Column(name="COD_EMPRESA", table="LICENCIAS_USUARIO_EMPRESA")
	private Long codempresa;

	@Column(name="COD_CONTRATO", table="LICENCIAS_USUARIO_EMPRESA")
	private Long codcontrato;*/
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPerfil() {
		return perfil;
	}

	public void setPerfil(Long perfil) {
		this.perfil = perfil;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean getSyncccostos() {
		return syncccostos;
	}

	public void setSyncccostos(Boolean syncccostos) {
		this.syncccostos = syncccostos;
	}

	public Boolean getSynctiplanilla() {
		return synctiplanilla;
	}

	public void setSynctiplanilla(Boolean synctiplanilla) {
		this.synctiplanilla = synctiplanilla;
	}

	public Boolean getSyncareas() {
		return syncareas;
	}

	public void setSyncareas(Boolean syncareas) {
		this.syncareas = syncareas;
	}

	/*public Long getCodcontrato() {
		return codcontrato;
	}

	public void setCodcontrato(Long codcontrato) {
		this.codcontrato = codcontrato;
	}

	public Long getCodempresa() {
		return codempresa;
	}

	public void setCodempresa(Long codempresa) {
		this.codempresa = codempresa;
	}
	*/
}
