package com.edalac.inventario.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edalac.inventario.dao.CiudadDAO;
import com.edalac.inventario.dto.TbCiudad;
import com.edalac.inventario.dto.TbDepartamento;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;

public class CiudadDAOHibernate extends HibernateDaoSupport implements CiudadDAO {

	Session session = null;
	Criteria criteria = null;
	ExcepcionesDAO expDao;
	
	@Override
	public TbCiudad obtenerCiudadxId(int idCiudad) throws ExcepcionesDAO {
		TbCiudad ciudad = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbCiudad.class).add(Restrictions.eq("nbIdciudad", idCiudad));
			ciudad = (TbCiudad)criteria.uniqueResult();
		}catch(HibernateException ex){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeUsuario("");
			throw expDao;
		}finally{
			session.close();
		}
		return ciudad;
	}

	@Override
	public List<TbCiudad> obtenerCiudadxNombre(String nombre) throws ExcepcionesDAO {
		List<TbCiudad> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbCiudad.class).add(Restrictions.like("vrNombre", "%"+nombre+"%"));
			lista = criteria.list();
		}catch(HibernateException ex){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeUsuario("");
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}

	@Override
	public List<TbCiudad> listarCiudadesxDepartamento(TbDepartamento dpto) throws ExcepcionesDAO {
		List<TbCiudad> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbCiudad.class).add(Restrictions.eq("tbDepartamento", dpto));
			lista = criteria.list();
		}catch(HibernateException ex){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeUsuario("");
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}

}
