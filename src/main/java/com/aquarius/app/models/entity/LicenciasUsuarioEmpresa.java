package com.aquarius.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_empresa", referencedColumnName="id", insertable = false, updatable = false)
    private Empresa empresa;
	@Column(name="COD_CONTRATO")
	private Long codcontrato;
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_CONTRATO", referencedColumnName="id", insertable = false, updatable = false)
    private ContratoLicencia contrato;
	
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
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public ContratoLicencia getContrato() {
		return contrato;
	}
	public void setContrato(ContratoLicencia contrato) {
		this.contrato = contrato;
	}
	
	
	
	
	
}
