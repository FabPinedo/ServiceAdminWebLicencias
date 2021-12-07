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
@Table(name = "mae_perfil_grupo_funcion")
public class MaePerfilGrupoFuncion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name="cod_grupo")
	private Long codgrupo;
	
	@Column(name="cod_perfil")
	private Long codperfil;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_grupo", insertable = false, updatable = false)
    private MaeFuncionGrupo funciongrupo;

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

	public Long getCodperfil() {
		return codperfil;
	}

	public void setCodperfil(Long codperfil) {
		this.codperfil = codperfil;
	}

	public MaeFuncionGrupo getFunciongrupo() {
		return funciongrupo;
	}

	public void setFunciongrupo(MaeFuncionGrupo funciongrupo) {
		this.funciongrupo = funciongrupo;
	}
	
}
