package com.edalac.inventario.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edalac.inventario.dao.PaisDAO;
import com.edalac.inventario.dto.TbPais;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;

public class PaisDAOHibernate extends HibernateDaoSupport implements PaisDAO {

	Session session = null;
	Criteria criteria = null;
	ExcepcionesDAO expDao;
	
	@Override
	public TbPais obtenerPaisxId(Long idPais) throws ExcepcionesDAO {
		TbPais pais = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbPais.class).add(Restrictions.eq("nbIdpais", idPais));
			pais = (TbPais)criteria.uniqueResult();
		}catch(HibernateException ex){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeUsuario("");
			throw expDao;
		}finally{
			session.close();
		}
		return pais;
	}
		

	@Override
	public List<TbPais> listarPaises() throws ExcepcionesDAO {
		List<TbPais> lista = null;
		try{
			session = getSession();
			criteria = session.createCriteria(TbPais.class);
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
