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
@Table(name = "LICENCIA_CONEXION_SERVIDOR")
public class ConexionServidor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="bd_serv_instancia")
	private String bdservinstancia;
	
	@Column(name="bd_nombre")
	private String bdnombre;
	
	@Column(name="bd_tipo")
	private String bdtipo;
	
	@Column(name="bd_usuario")
	private String bdusuario;
	
	@Column(name="bd_contra")
	private String bdcontra;
	
	@Column(name="tomcat_puerto")
	private String tomcatpuerto;
	
	@Column(name="tomcat_usuario")
	private String tomcatusuario;
	
	@Column(name="tomcat_contra")
	private String tomcatcontra;
	
	@Column(name="web_url")
	private String weburl;
	
	
	@Column(name="cod_empresa")
	private Long codempresa;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_empresa", referencedColumnName="id", insertable = false, updatable = false)
    private Empresa empresa;
	
	public Long getId() {
		return id;
	}

	public Long getCodempresa() {
		return codempresa;
	}

	public void setCodempresa(Long codempresa) {
		this.codempresa = codempresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBdservinstancia() {
		return bdservinstancia;
	}

	public void setBdservinstancia(String bdservinstancia) {
		this.bdservinstancia = bdservinstancia;
	}

	public String getBdnombre() {
		return bdnombre;
	}

	public void setBdnombre(String bdnombre) {
		this.bdnombre = bdnombre;
	}

	public String getBdtipo() {
		return bdtipo;
	}

	public void setBdtipo(String bdtipo) {
		this.bdtipo = bdtipo;
	}

	public String getBdusuario() {
		return bdusuario;
	}

	public void setBdusuario(String bdusuario) {
		this.bdusuario = bdusuario;
	}

	public String getBdcontra() {
		return bdcontra;
	}

	public void setBdcontra(String bdcontra) {
		this.bdcontra = bdcontra;
	}

	public String getTomcatpuerto() {
		return tomcatpuerto;
	}

	public void setTomcatpuerto(String tomcatpuerto) {
		this.tomcatpuerto = tomcatpuerto;
	}

	public String getTomcatusuario() {
		return tomcatusuario;
	}

	public void setTomcatusuario(String tomcatusuario) {
		this.tomcatusuario = tomcatusuario;
	}

	public String getTomcatcontra() {
		return tomcatcontra;
	}

	public void setTomcatcontra(String tomcatcontra) {
		this.tomcatcontra = tomcatcontra;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}
	
}
