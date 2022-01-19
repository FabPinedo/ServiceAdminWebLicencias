package com.aquarius.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarius.app.models.entity.Pais;
import com.aquarius.app.models.entity.Sede;

public interface IPaisesDao extends JpaRepository<Pais,String> {

}
