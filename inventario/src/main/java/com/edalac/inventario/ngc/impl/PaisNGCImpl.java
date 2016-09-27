package com.edalac.inventario.ngc.impl;

import java.util.List;

import com.edalac.inventario.dao.PaisDAO;
import com.edalac.inventario.dto.TbPais;
import com.edalac.inventario.ngc.PaisNGC;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

public class PaisNGCImpl implements PaisNGC{

	private ExcepcionesNGC expNgc;
	private PaisDAO paisDao;
	
	public void setPaisDao(PaisDAO paisDao) {
		this.paisDao = paisDao;
	}

	@Override
	public TbPais obtenerPaisxId(Long idPais) throws ExcepcionesNGC {
		TbPais pais = null;
		
		try {
			pais = paisDao.obtenerPaisxId(idPais);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			throw expNgc;
		}
		
		return pais;
	}

	@Override
	public List<TbPais> listarPaises() throws ExcepcionesNGC {
		List<TbPais> lista = null;
		
		try {
			lista = paisDao.listarPaises();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			throw expNgc;
		}
		
		return lista;
	}
}
