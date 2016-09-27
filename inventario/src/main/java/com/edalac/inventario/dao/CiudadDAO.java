package com.edalac.inventario.dao;

import java.util.List;

import com.edalac.inventario.dto.TbCiudad;
import com.edalac.inventario.dto.TbDepartamento;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;

public interface CiudadDAO {

	public TbCiudad obtenerCiudadxId(int idCiudad) throws ExcepcionesDAO;
	public List<TbCiudad> obtenerCiudadxNombre(String nombre) throws ExcepcionesDAO;
	public List<TbCiudad> listarCiudadesxDepartamento(TbDepartamento dpto) throws ExcepcionesDAO;
	
}
