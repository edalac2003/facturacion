package com.edalac.inventario.dto;
// default package
// Generated 29-jun-2016 21:10:30 by Hibernate Tools 4.3.1.Final

/**
 * TbUsuario generated by hbm2java
 */
public class TbUsuario implements java.io.Serializable {

	private long nbIdusuario;
	private TbRol tbRol;
	private String vrUsuario;
	private String vrPasswd;
	private Long nbEmpresa;

	public TbUsuario() {
	}

	public TbUsuario(long nbIdusuario) {
		this.nbIdusuario = nbIdusuario;
	}

	public TbUsuario(long nbIdusuario, TbRol tbRol, String vrUsuario, String vrPasswd, Long nbEmpresa) {
		this.nbIdusuario = nbIdusuario;
		this.tbRol = tbRol;
		this.vrUsuario = vrUsuario;
		this.vrPasswd = vrPasswd;
		this.nbEmpresa = nbEmpresa;
	}

	public long getNbIdusuario() {
		return this.nbIdusuario;
	}

	public void setNbIdusuario(long nbIdusuario) {
		this.nbIdusuario = nbIdusuario;
	}

	public TbRol getTbRol() {
		return this.tbRol;
	}

	public void setTbRol(TbRol tbRol) {
		this.tbRol = tbRol;
	}

	public String getVrUsuario() {
		return this.vrUsuario;
	}

	public void setVrUsuario(String vrUsuario) {
		this.vrUsuario = vrUsuario;
	}

	public String getVrPasswd() {
		return this.vrPasswd;
	}

	public void setVrPasswd(String vrPasswd) {
		this.vrPasswd = vrPasswd;
	}

	public Long getNbEmpresa() {
		return this.nbEmpresa;
	}

	public void setNbEmpresa(Long nbEmpresa) {
		this.nbEmpresa = nbEmpresa;
	}

}
