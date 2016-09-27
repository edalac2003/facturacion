package com.edalac.inventario.ngc.impl;

import java.util.List;

import com.edalac.inventario.dao.TerceroDAO;
import com.edalac.inventario.dto.TbTercero;
import com.edalac.inventario.dto.TbTipodocumento;
import com.edalac.inventario.dto.TbTipopersona;
import com.edalac.inventario.ngc.TerceroNGC;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

public class TerceroNGCImpl implements TerceroNGC {
	
	TerceroDAO terceroDao;	
	ExcepcionesNGC expNgc;

	public void setTerceroDao(TerceroDAO terceroDao) {
		this.terceroDao = terceroDao;
	}

	@Override
	public void guardarTercero(TbTercero tercero) throws ExcepcionesNGC {
		if(tercero != null){
			try {
				terceroDao.guardarTercero(tercero);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible Guardar el registro.");
		}
	}

	@Override
	public List<TbTercero> obtenerTerceroxNit(Long nit) throws ExcepcionesNGC {
		List<TbTercero> lista = null;
		
		if(nit > 0){
			try {
				lista = terceroDao.obtenerTerceroxNit(nit);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
			}
		}
		return lista;
	}

	@Override
	public List<TbTercero> obtenerTerceroxNombre(String nombre) throws ExcepcionesNGC {
		List<TbTercero> lista = null;
		
		if(nombre != null && !nombre.isEmpty()){
			try {
				lista = terceroDao.obtenerTerceroxNombre(nombre);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
			}
		}
		
		return lista;
	}

	@Override
	public List<TbTercero> obtenerTerceroxApellido(String apellido) throws ExcepcionesNGC {
		List<TbTercero> lista = null;
		
		if(apellido != null && !apellido.isEmpty()){
			try {
				lista = terceroDao.obtenerTerceroxApellido(apellido);
				
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
			}
		}
		
		return lista;
	}
	

	@Override
	public List<TbTercero> listarTerceros() throws ExcepcionesNGC {
		List<TbTercero> listaTerceros = null;
		
		try {
			listaTerceros = terceroDao.listarTerceros();
			if(listaTerceros == null || listaTerceros.isEmpty()){
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("No se encontraron registros de Terceros.");
				throw expNgc;
			}
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			throw expNgc;
		}
		
		return listaTerceros;
	}

	@Override
	public List<TbTipodocumento> listarTipoDocumento() throws ExcepcionesNGC {
		List<TbTipodocumento> lista = null;
		
		try {
			lista = terceroDao.listarTipoDocumento();
			if(lista == null || lista.isEmpty()){
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("No se Encontraron Registros de Tipo Documento.");
				throw expNgc;
			}
				
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			throw expNgc;
		}
		
		return lista;
	}

	@Override
	public List<TbTipopersona> listarTipoPersona() throws ExcepcionesNGC {
		List<TbTipopersona> lista = null;
		
		try {
			lista = terceroDao.listarTipoPersona();
			if(lista == null || lista.isEmpty()){
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("No se Encontraron Registros de Tipo Persona.");
				throw expNgc;
			}
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			throw expNgc;
		}
		return lista;
	}
}
