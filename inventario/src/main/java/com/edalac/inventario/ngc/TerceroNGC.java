package com.edalac.inventario.ngc;

import java.util.List;

import com.edalac.inventario.dto.TbTercero;
import com.edalac.inventario.dto.TbTipodocumento;
import com.edalac.inventario.dto.TbTipopersona;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

public interface TerceroNGC {

	public void guardarTercero(TbTercero tercero) throws ExcepcionesNGC;
	public List<TbTercero> obtenerTerceroxNit(Long nit) throws ExcepcionesNGC;
	public List<TbTercero> obtenerTerceroxNombre(String nombre) throws ExcepcionesNGC;
	public List<TbTercero> obtenerTerceroxApellido(String apellido) throws ExcepcionesNGC;
	public List<TbTercero> listarTerceros() throws ExcepcionesNGC;

	public List<TbTipodocumento> listarTipoDocumento() throws ExcepcionesNGC;
	public List<TbTipopersona> listarTipoPersona() throws ExcepcionesNGC;
}
