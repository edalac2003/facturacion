package com.edalac.inventario.dto;
// default package
// Generated 29-jun-2016 21:10:30 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TbRol generated by hbm2java
 */
public class TbRol implements java.io.Serializable {

	private long nbIdRol;
	private String vrDescripcion;
	private String vrAlias;
	private Set tbUsuarios = new HashSet(0);

	public TbRol() {
	}

	public TbRol(long nbIdRol) {
		this.nbIdRol = nbIdRol;
	}

	public TbRol(long nbIdRol, String vrDescripcion, String vrAlias, Set tbUsuarios) {
		this.nbIdRol = nbIdRol;
		this.vrDescripcion = vrDescripcion;
		this.vrAlias = vrAlias;
		this.tbUsuarios = tbUsuarios;
	}

	public long getNbIdRol() {
		return this.nbIdRol;
	}

	public void setNbIdRol(long nbIdRol) {
		this.nbIdRol = nbIdRol;
	}

	public String getVrDescripcion() {
		return this.vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
	}

	public String getVrAlias() {
		return this.vrAlias;
	}

	public void setVrAlias(String vrAlias) {
		this.vrAlias = vrAlias;
	}

	public Set getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(Set tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

}
