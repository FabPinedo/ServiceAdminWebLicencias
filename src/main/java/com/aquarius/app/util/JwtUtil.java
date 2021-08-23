package com.aquarius.app.util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

import com.aquarius.app.models.entity.ContratoLicencia;
import com.aquarius.app.models.entity.ContratoLicenciaEncrypt;

public class JwtUtil {
	
	public ContratoLicencia JwtConvert(ContratoLicencia licencia) {
		
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		ConvertFecha convertFecha = new ConvertFecha();
		
		String bdservinstancia = Jwts.builder().setSubject(licencia.getConexion().getBdservinstancia()).signWith(key).compact();
		String bdnombre = Jwts.builder().setSubject(licencia.getConexion().getBdnombre()).signWith(key).compact();
		String bdtipo = Jwts.builder().setSubject(licencia.getConexion().getBdtipo()).signWith(key).compact();
		String bdusuario = Jwts.builder().setSubject(licencia.getConexion().getBdusuario()).signWith(key).compact();
		String bdcontra = Jwts.builder().setSubject(licencia.getConexion().getBdcontra()).signWith(key).compact();
		String tomcatpuerto = Jwts.builder().setSubject(licencia.getConexion().getTomcatpuerto()).signWith(key).compact();
		String tomcatusuario = Jwts.builder().setSubject(licencia.getConexion().getTomcatusuario()).signWith(key).compact();
		String tomcatcontra = Jwts.builder().setSubject(licencia.getConexion().getTomcatcontra()).signWith(key).compact();
		String weburl = Jwts.builder().setSubject(licencia.getConexion().getWeburl()).signWith(key).compact();
		
		String fechainicontrato = Jwts.builder().setSubject(convertFecha.getConvertFechaToText(licencia.getFechainicontrato())).signWith(key).compact();
		String fechafincontrato = Jwts.builder().setSubject(convertFecha.getConvertFechaToText(licencia.getFechafincontrato())).signWith(key).compact();
		String estado = Jwts.builder().setSubject(licencia.getEstado().toString()).signWith(key).compact();
		
		System.out.println(fechainicontrato);
		System.out.println(fechafincontrato);
		System.out.println(estado);
		
		String token = Jwts.builder().setSubject(licencia.getToken()).signWith(key).compact();

		licencia.getConexion().setBdservinstancia(bdservinstancia);
		licencia.getConexion().setBdnombre(bdnombre);
		licencia.getConexion().setBdtipo(bdtipo);
		licencia.getConexion().setBdusuario(bdusuario);
		licencia.getConexion().setBdcontra(bdcontra);
		licencia.getConexion().setTomcatcontra(tomcatcontra);
		licencia.getConexion().setTomcatpuerto(tomcatpuerto);
		licencia.getConexion().setTomcatusuario(tomcatusuario);
		licencia.getConexion().setWeburl(weburl);
		
		licencia.setFechainicontrato(null);
		licencia.setFechafincontrato(null);
		licencia.setEstado(null);
		
		licencia.setFechainicio(fechainicontrato);
		licencia.setFechafin(fechafincontrato);
		licencia.setEstadoE(estado);
		
		licencia.setToken(token);
		
		return licencia;
	}
	
	public ContratoLicenciaEncrypt parseObject(ContratoLicencia licencia) {
		return null;
	}

}
