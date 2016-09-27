package com.edalac.inventario.ngc;

import java.util.List;

import com.edalac.inventario.dto.TbDepartamento;
import com.edalac.inventario.dto.TbPais;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

public interface DepartamentoNGC {

	public TbDepartamento obtenerDepartamentoxId(Long idDpto) throws ExcepcionesNGC;
	public List<TbDepartamento> obtenerDepartamentoxNombre(String nombre) throws ExcepcionesNGC;
	public List<TbDepartamento> listarDepartamentosxPais(Long idPais) throws ExcepcionesNGC;
	public List<TbDepartamento> listarDepartamentosxPais(TbPais idPais) throws ExcepcionesNGC;
	
}
