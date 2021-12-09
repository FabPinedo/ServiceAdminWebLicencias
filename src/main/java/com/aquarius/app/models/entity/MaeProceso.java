package com.aquarius.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mae_proceso")
public class MaeProceso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "des_proceso")
	private String desproceso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesproceso() {
		return desproceso;
	}

	public void setDesproceso(String desproceso) {
		this.desproceso = desproceso;
	}
	
}
