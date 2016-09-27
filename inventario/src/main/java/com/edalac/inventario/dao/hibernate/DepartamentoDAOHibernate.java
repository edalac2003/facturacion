package com.edalac.inventario.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edalac.inventario.dao.DepartamentoDAO;
import com.edalac.inventario.dto.TbDepartamento;
import com.edalac.inventario.dto.TbPais;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;

public class DepartamentoDAOHibernate extends HibernateDaoSupport implements DepartamentoDAO {

	Session session = null;
	Criteria criteria = null;
	ExcepcionesDAO expDao;
	
	@Override
	public TbDepartamento obtenerDepartamentoxId(Long idDpto) throws ExcepcionesDAO {
		TbDepartamento dpto = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbDepartamento.class).add(Restrictions.eq("nbIddepartamento", idDpto));
			dpto = (TbDepartamento)criteria.uniqueResult();
		}catch(HibernateException ex){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeUsuario("");
			throw expDao;
		}finally{
			session.close();
		}
		return dpto;
	}

	@Override
	public List<TbDepartamento> obtenerDepartamentoxNombre(String nombre) throws ExcepcionesDAO {
		List<TbDepartamento> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbDepartamento.class).add(Restrictions.like("vrNombre", "%"+nombre+"%"));
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
	public List<TbDepartamento> listarDepartamentosxPais(TbPais pais) throws ExcepcionesDAO {
		List<TbDepartamento> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbDepartamento.class).add(Restrictions.eq("tbPais", pais));
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
