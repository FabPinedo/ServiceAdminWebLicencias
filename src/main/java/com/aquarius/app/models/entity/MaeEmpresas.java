package com.aquarius.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mae_empresas")
public class MaeEmpresas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_empresa")
	private String codempresa;
	
	@Column(name="des_razon_social")
	private String desrazonsocial;
	
	@Column(name="num_ruc_empresa")
	private String numrucempresa;
	
	@Column(name="des_direccion")
	private String desdireccion;

	public String getCodempresa() {
		return codempresa;
	}

	public void setCodempresa(String codempresa) {
		this.codempresa = codempresa;
	}

	public String getDesrazonsocial() {
		return desrazonsocial;
	}

	public void setDesrazonsocial(String desrazonsocial) {
		this.desrazonsocial = desrazonsocial;
	}

	public String getNumrucempresa() {
		return numrucempresa;
	}

	public void setNumrucempresa(String numrucempresa) {
		this.numrucempresa = numrucempresa;
	}

	public String getDesdireccion() {
		return desdireccion;
	}

	public void setDesdireccion(String desdireccion) {
		this.desdireccion = desdireccion;
	}
}
