package com.edalac.inventario.dao;

import java.util.List;

import com.edalac.inventario.dto.TbTercero;
import com.edalac.inventario.dto.TbTipodocumento;
import com.edalac.inventario.dto.TbTipopersona;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;

public interface TerceroDAO {

	public void guardarTercero(TbTercero tercero) throws ExcepcionesDAO;
	public List<TbTercero> obtenerTerceroxNit(Long nit) throws ExcepcionesDAO;
	public List<TbTercero> obtenerTerceroxNombre(String nombre) throws ExcepcionesDAO;
	public List<TbTercero> obtenerTerceroxApellido(String apellido) throws ExcepcionesDAO;
	public List<TbTercero> listarTerceros() throws ExcepcionesDAO;
	
	public List<TbTipodocumento> listarTipoDocumento() throws ExcepcionesDAO;
	public List<TbTipopersona> listarTipoPersona() throws ExcepcionesDAO;
}
