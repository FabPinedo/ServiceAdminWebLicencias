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
@Table(name = "mae_funcion")
public class MaeFuncion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="cod_grupo")
	private Long codgrupo;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_grupo", referencedColumnName="id", insertable = false, updatable = false)
    private MaeFuncionGrupo grupo;
	
	@Column(name="cod_funcion_sup")
	private Long codfuncionsup;
	
	@Column(name="cod_proceso")
	private Long codproceso;
	
	@Column(name="num_nivel")
	private Double numnivel;
	
	@Column(name="des_funcion")
	private String desfuncion;
	
	@Column(name="ind_detalle")
	private String inddetalle;
	
	@Column(name="des_url")
	private String desurl;
	
	@Column(name="ind_baja")
	private Boolean estado;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_proceso", insertable = false, updatable = false)
    private MaeProceso proceso;
	
	
    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_grupo", insertable = false, updatable = false)
    private MaeFuncionGrupo maefunciongrupo;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodgrupo() {
		return codgrupo;
	}

	public void setCodgrupo(Long codgrupo) {
		this.codgrupo = codgrupo;
	}

	public Long getCodfuncionsup() {
		return codfuncionsup;
	}

	public void setCodfuncionsup(Long codfuncionsup) {
		this.codfuncionsup = codfuncionsup;
	}

	public Double getNumnivel() {
		return numnivel;
	}

	public void setNumnivel(Double numnivel) {
		this.numnivel = numnivel;
	}

	public String getDesfuncion() {
		return desfuncion;
	}

	public void setDesfuncion(String desfuncion) {
		this.desfuncion = desfuncion;
	}

	public String getInddetalle() {
		return inddetalle;
	}

	public void setInddetalle(String inddetalle) {
		this.inddetalle = inddetalle;
	}

	public String getDesurl() {
		return desurl;
	}

	public void setDesurl(String desurl) {
		this.desurl = desurl;
	}

	public Long getCodproceso() {
		return codproceso;
	}

	public void setCodproceso(Long codproceso) {
		this.codproceso = codproceso;
	}

	public MaeProceso getProceso() {
		return proceso;
	}

	public void setProceso(MaeProceso proceso) {
		this.proceso = proceso;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public MaeFuncionGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(MaeFuncionGrupo grupo) {
		this.grupo = grupo;
	}
	
	
	
}
