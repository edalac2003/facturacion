package com.edalac.inventario.util.exceptions;

public class ExcepcionesDAO extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private Exception origen;
	
	public ExcepcionesDAO() {
		super();
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}

	public Exception getOrigen() {
		return origen;
	}

	public void setOrigen(Exception origen) {
		this.origen = origen;
	}	
}
