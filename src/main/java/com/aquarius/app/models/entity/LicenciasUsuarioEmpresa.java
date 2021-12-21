package com.aquarius.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LICENCIAS_USUARIO_EMPRESA")
public class LicenciasUsuarioEmpresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;	
	@Column(name="COD_USUARIO")
	private String codusuario;
	@Column(name="COD_EMPRESA")
	private Long codempresa;
	@Column(name="COD_CONTRATO")
	private Long codcontrato;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodusuario() {
		return codusuario;
	}
	public void setCodusuario(String codusuario) {
		this.codusuario = codusuario;
	}
	public Long getCodempresa() {
		return codempresa;
	}
	public void setCodempresa(Long codempresa) {
		this.codempresa = codempresa;
	}
	public Long getCodcontrato() {
		return codcontrato;
	}
	public void setCodcontrato(Long codcontrato) {
		this.codcontrato = codcontrato;
	}
	
	
	
}
