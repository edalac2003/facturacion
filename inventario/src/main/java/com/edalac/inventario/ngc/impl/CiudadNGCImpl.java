package com.edalac.inventario.ngc.impl;

import java.util.List;

import com.edalac.inventario.dao.CiudadDAO;
import com.edalac.inventario.dao.DepartamentoDAO;
import com.edalac.inventario.dto.TbCiudad;
import com.edalac.inventario.dto.TbDepartamento;
import com.edalac.inventario.ngc.CiudadNGC;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

public class CiudadNGCImpl implements CiudadNGC {
	
	CiudadDAO ciudadDao;
	DepartamentoDAO departamentoDao;
	ExcepcionesNGC expNgc;

	public void setCiudadDao(CiudadDAO ciudadDao) {
		this.ciudadDao = ciudadDao;
	}
	
	public void setDepartamentoDao(DepartamentoDAO departamentoDao) {
		this.departamentoDao = departamentoDao;
	}


	@Override
	public TbCiudad obtenerCiudadxId(int idCiudad) throws ExcepcionesNGC {
		TbCiudad ciudad = null;
		
		try {
			ciudad = ciudadDao.obtenerCiudadxId(idCiudad);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
		}
		return ciudad;
	}

	@Override
	public List<TbCiudad> obtenerCiudadxNombre(String nombre) throws ExcepcionesNGC {
		List<TbCiudad> lista = null;
		
		try {
			lista = ciudadDao.obtenerCiudadxNombre(nombre);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
		}
		return lista;
	}

	@Override
	public List<TbCiudad> listarCiudadesxDepartamento(String dpto) throws ExcepcionesNGC {
		List<TbCiudad> lista = null;
		List<TbDepartamento> listaDpto = null;
		TbDepartamento departamento = null;
		
		try {
			listaDpto = departamentoDao.obtenerDepartamentoxNombre(dpto);			
			departamento = listaDpto.get(0);
			lista = ciudadDao.listarCiudadesxDepartamento(departamento);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
		}
		
		return lista;
	}

	@Override
	public List<TbCiudad> listarCiudadesxDepartamento(TbDepartamento dpto) throws ExcepcionesNGC {
		List<TbCiudad> lista = null;
		
		try {
			lista = ciudadDao.listarCiudadesxDepartamento(dpto);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
		}
		
		return lista;
	}

	
}
