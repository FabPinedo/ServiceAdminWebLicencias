package com.aquarius.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarius.app.models.entity.Perfil;

public interface IPerfilDao extends JpaRepository<Perfil,Long> {

}
