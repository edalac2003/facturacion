package com.edalac.inventario.ngc;

import java.util.List;

import com.edalac.inventario.dto.TbPais;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

public interface PaisNGC {

	public TbPais obtenerPaisxId(Long idPais) throws ExcepcionesNGC;
	public List<TbPais> listarPaises() throws ExcepcionesNGC;
}
