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
@Table(name = "mae_accesos_res")
public class MaeAccesosRes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="cod_usuario")
	private String usuario;
	
	@Column(name = "cod_funcion")
	private Long codfuncion;
	
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_funcion", insertable = false, updatable = false)
    private MaeFuncion maefuncion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getCodfuncion() {
		return codfuncion;
	}

	public void setCodfuncion(Long codfuncion) {
		this.codfuncion = codfuncion;
	}

	public MaeFuncion getMaefuncion() {
		return maefuncion;
	}

	public void setMaefuncion(MaeFuncion maefuncion) {
		this.maefuncion = maefuncion;
	}
	
}
