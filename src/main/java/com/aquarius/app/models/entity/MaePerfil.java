package com.aquarius.app.models.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "mae_perfil")
public class MaePerfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="des_perfil")
	private String desperfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesperfil() {
		return desperfil;
	}

	public void setDesperfil(String desperfil) {
		this.desperfil = desperfil;
	}
	
}
