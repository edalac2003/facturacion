package com.edalac.inventario.ngc;

import java.util.List;

import com.edalac.inventario.dto.TbCiudad;
import com.edalac.inventario.dto.TbDepartamento;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

public interface CiudadNGC {

	public TbCiudad obtenerCiudadxId(int idCiudad) throws ExcepcionesNGC;
	public List<TbCiudad> obtenerCiudadxNombre(String nombre) throws ExcepcionesNGC;
	public List<TbCiudad> listarCiudadesxDepartamento(String dpto) throws ExcepcionesNGC;
	public List<TbCiudad> listarCiudadesxDepartamento(TbDepartamento dpto) throws ExcepcionesNGC;
	
}
