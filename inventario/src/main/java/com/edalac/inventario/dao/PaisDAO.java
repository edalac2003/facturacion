package com.edalac.inventario.dao;

import java.util.List;

import com.edalac.inventario.dto.TbPais;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;

public interface PaisDAO {

	public TbPais obtenerPaisxId(Long idPais) throws ExcepcionesDAO;	
	public List<TbPais> listarPaises() throws ExcepcionesDAO;
	
}
