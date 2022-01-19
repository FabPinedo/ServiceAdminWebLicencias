package com.aquarius.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "mae_tabla")
public class MaeTabla {
	
	@Id	
	@Column(name = "tip_tabla")
	private String tiptabla;
	
	@Column(name = "des_tabla")
	private String destabla;
	
	@Column(name = "des_observacion")
	private String desobservacion;
	
	@Column(name = "ind_tabla_det_sistema")
	private String indtabladetsistema;
	
	@Transient
	private Boolean isupdate;

	public Boolean getIsupdate() {
		return isupdate;
	}

	public void setIsupdate(Boolean isupdate) {
		this.isupdate = isupdate;
	}

	public String getTiptabla() {
		return tiptabla;
	}

	public void setTiptabla(String tiptabla) {
		this.tiptabla = tiptabla;
	}

	public String getDestabla() {
		return destabla;
	}

	public void setDestabla(String destabla) {
		this.destabla = destabla;
	}

	public String getDesobservacion() {
		return desobservacion;
	}

	public void setDesobservacion(String desobservacion) {
		this.desobservacion = desobservacion;
	}

	public String getIndtabladetsistema() {
		return indtabladetsistema;
	}

	public void setIndtabladetsistema(String indtabladetsistema) {
		this.indtabladetsistema = indtabladetsistema;
	}
}
