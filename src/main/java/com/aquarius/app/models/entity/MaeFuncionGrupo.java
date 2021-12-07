package com.aquarius.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mae_funcion_grupo")
public class MaeFuncionGrupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="des_grupo_menu")
	private String desgrupomenu;
	
	@Column(name="des_grupo")
	private String desgrupo;
	 
	/*@OneToMany(mappedBy = "maefunciongrupo", fetch = FetchType.EAGER)
	private List<MaeFuncion> maefuncion;*/
	
	@Column(name="des_icono")
	private String desicono;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesgrupomenu() {
		return desgrupomenu;
	}

	public void setDesgrupomenu(String desgrupomenu) {
		this.desgrupomenu = desgrupomenu;
	}

	public String getDesgrupo() {
		return desgrupo;
	}

	public void setDesgrupo(String desgrupo) {
		this.desgrupo = desgrupo;
	}

	public String getDesicono() {
		return desicono;
	}

	public void setDesicono(String desicono) {
		this.desicono = desicono;
	}
	
}
