package com.edalac.inventario.ngc.impl;

import java.util.List;

import com.edalac.inventario.dao.DepartamentoDAO;
import com.edalac.inventario.dao.PaisDAO;
import com.edalac.inventario.dto.TbDepartamento;
import com.edalac.inventario.dto.TbPais;
import com.edalac.inventario.ngc.DepartamentoNGC;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

public class DepartamentoNGCImpl implements DepartamentoNGC {

	private ExcepcionesNGC expNgc;
	private DepartamentoDAO departamentoDao;
	private PaisDAO paisDao;
	
	public void setDepartamentoDao(DepartamentoDAO departamentoDao) {
		this.departamentoDao = departamentoDao;
	}

	public void setPaisDao(PaisDAO paisDao) {
		this.paisDao = paisDao;
	}


	@Override
	public TbDepartamento obtenerDepartamentoxId(Long idDpto) throws ExcepcionesNGC {
		TbDepartamento dpto = null;
		
		try {
			dpto  = departamentoDao.obtenerDepartamentoxId(idDpto);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			throw expNgc;
		}
		
		return dpto;
	}

	@Override
	public List<TbDepartamento> obtenerDepartamentoxNombre(String nombre) throws ExcepcionesNGC {
		List<TbDepartamento> lista = null;
		
		if(nombre != null && !nombre.isEmpty()){
			try {
				lista = departamentoDao.obtenerDepartamentoxNombre(nombre);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				throw expNgc;
			}
		}
		
		return lista;
	}

	@Override
	public List<TbDepartamento> listarDepartamentosxPais(Long idPais) throws ExcepcionesNGC {
		List<TbDepartamento> lista = null;
		TbPais pais = null;
		
		if(idPais > 0){
			try {
				pais = paisDao.obtenerPaisxId(idPais);
				if (pais != null){
					lista = departamentoDao.listarDepartamentosxPais(pais);
				}else{
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeUsuario("El ID del pais no se encuentra en la Base de Datos.");
					throw expNgc;
				}
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				throw expNgc;
			}
		}
		
		return lista;
	}

	@Override
	public List<TbDepartamento> listarDepartamentosxPais(TbPais pais) throws ExcepcionesNGC {
		List<TbDepartamento> lista = null;		
		
		try {
			lista = departamentoDao.listarDepartamentosxPais(pais);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			throw expNgc;
		}	
		
		return lista;
	}

	
}
