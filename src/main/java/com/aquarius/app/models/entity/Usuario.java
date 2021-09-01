package com.aquarius.app.models.entity;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name ="MAE_USUARIO")
@SecondaryTable(name = "LICENCIAS_USUARIO_EMPRESA", pkJoinColumns = @PrimaryKeyJoinColumn(name = "COD_USUARIO"))
public class Usuario {
	@Id
	@Column(name ="COD_USUARIO")
	private String codusuario;
	
	@Column(name="COD_PERFIL")
	private Long codperfil;
	
	@Column(name="DES_PASSWORD")
	private String despassword;
	
	@Column(name="IND_BAJA")
	private Boolean indbaja;
	
	@Column(name="NOM_USUARIO")
	private String nomusuario;
	
	@Column(name="COD_CONTRATO", table="LICENCIAS_USUARIO_EMPRESA")
	private Long codcontrato;
	
	@Column(name="COD_EMPRESA", table="LICENCIAS_USUARIO_EMPRESA")
	private Long codempresa;
	

	public String getCodusuario() {
		return codusuario;
	}

	public void setCodusuario(String codusuario) {
		this.codusuario = codusuario;
	}

	public Long getCodperfil() {
		return codperfil;
	}

	public void setCodperfil(Long codperfil) {
		this.codperfil = codperfil;
	}

	public String getDespassword() {
		return despassword;
	}

	public void setDespassword(String despassword) {
		this.despassword = despassword;
	}

	

	public Boolean getIndbaja() {
		return indbaja;
	}

	public void setIndbaja(Boolean indbaja) {
		this.indbaja = indbaja;
	}

	public String getNomusuario() {
		return nomusuario;
	}

	public void setNomusuario(String nomusuario) {
		this.nomusuario = nomusuario;
	}

	public Long getCodcontrato() {
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


	
	

}
