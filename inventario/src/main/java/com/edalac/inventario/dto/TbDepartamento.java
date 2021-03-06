package com.edalac.inventario.dto;
// default package
// Generated 29-jun-2016 21:10:30 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TbDepartamento generated by hbm2java
 */
public class TbDepartamento implements java.io.Serializable {

	private long nbIddepartamento;
	private TbPais tbPais;
	private String vrNombre;
	private Set tbCiudads = new HashSet(0);

	public TbDepartamento() {
	}

	public TbDepartamento(long nbIddepartamento, TbPais tbPais, String vrNombre) {
		this.nbIddepartamento = nbIddepartamento;
		this.tbPais = tbPais;
		this.vrNombre = vrNombre;
	}

	public TbDepartamento(long nbIddepartamento, TbPais tbPais, String vrNombre, Set tbCiudads) {
		this.nbIddepartamento = nbIddepartamento;
		this.tbPais = tbPais;
		this.vrNombre = vrNombre;
		this.tbCiudads = tbCiudads;
	}

	public long getNbIddepartamento() {
		return this.nbIddepartamento;
	}

	public void setNbIddepartamento(long nbIddepartamento) {
		this.nbIddepartamento = nbIddepartamento;
	}

	public TbPais getTbPais() {
		return this.tbPais;
	}

	public void setTbPais(TbPais tbPais) {
		this.tbPais = tbPais;
	}

	public String getVrNombre() {
		return this.vrNombre;
	}

	public void setVrNombre(String vrNombre) {
		this.vrNombre = vrNombre;
	}

	public Set getTbCiudads() {
		return this.tbCiudads;
	}

	public void setTbCiudads(Set tbCiudads) {
		this.tbCiudads = tbCiudads;
	}

}
