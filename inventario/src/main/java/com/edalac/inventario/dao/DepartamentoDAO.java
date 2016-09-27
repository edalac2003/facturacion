package com.edalac.inventario.dao;

import java.util.List;

import com.edalac.inventario.dto.TbDepartamento;
import com.edalac.inventario.dto.TbPais;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;

public interface DepartamentoDAO {

	public TbDepartamento obtenerDepartamentoxId(Long idDpto) throws ExcepcionesDAO;
	public List<TbDepartamento> obtenerDepartamentoxNombre(String nombre) throws ExcepcionesDAO;
	public List<TbDepartamento> listarDepartamentosxPais(TbPais pais) throws ExcepcionesDAO;
}
