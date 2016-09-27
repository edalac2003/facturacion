package com.edalac.inventario.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.edalac.inventario.dao.TerceroDAO;
import com.edalac.inventario.dto.TbTercero;
import com.edalac.inventario.dto.TbTipodocumento;
import com.edalac.inventario.dto.TbTipopersona;
import com.edalac.inventario.util.exceptions.ExcepcionesDAO;

public class TerceroDAOHIbernate extends HibernateDaoSupport implements TerceroDAO {

	Session session = null;
	Criteria criteria = null;
	ExcepcionesDAO expDao;

	@Override
	public void guardarTercero(TbTercero tercero) throws ExcepcionesDAO {
		try{
			
		}catch(HibernateException e){
			
		}finally {
			session.close();
		}
	}

	@Override
	public List<TbTercero> obtenerTerceroxNit(Long nit) throws ExcepcionesDAO {
		List<TbTercero> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbTercero.class).add(Restrictions.like("nbNit", "%"+nit+"%"));
			lista = criteria.list();
		}catch(HibernateException ex){
			
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public List<TbTercero> obtenerTerceroxNombre(String nombre) throws ExcepcionesDAO {
		List<TbTercero> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbTercero.class).add(Restrictions.like("nbNit", "%"+nombre+"%"));
			lista = criteria.list();
		}catch(HibernateException ex){
			
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public List<TbTercero> obtenerTerceroxApellido(String apellido) throws ExcepcionesDAO {
		List<TbTercero> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbTercero.class).add(Restrictions.like("nbNit", "%"+apellido+"%"));
			lista = criteria.list();
		}catch(HibernateException ex){
			
		}finally{
			session.close();
		}
		return lista;
	}

	@Override
	public List<TbTercero> listarTerceros() throws ExcepcionesDAO {
		List<TbTercero> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbTercero.class);
			lista = criteria.list();
		}catch(HibernateException ex){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(ex.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al intentar obtener el listado de los Terceros.");
			expDao.setOrigen(ex);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}

	@Override
	public List<TbTipodocumento> listarTipoDocumento() throws ExcepcionesDAO {
		List<TbTipodocumento> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbTipodocumento.class);
			lista = criteria.list();
		}catch(HibernateException ex){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(ex.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al intentar obtener listado de Tipo Documento.");
			expDao.setOrigen(ex);
			throw expDao;
		}finally {
			session.close();
		}
		return lista;
	}

	@Override
	public List<TbTipopersona> listarTipoPersona() throws ExcepcionesDAO {
		List<TbTipopersona> lista = null;
		
		try{
			session = getSession();
			criteria = session.createCriteria(TbTipopersona.class);
			lista = criteria.list();
		}catch(HibernateException ex){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(ex.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al intentar obtener listado de Tipo Persona.");
			expDao.setOrigen(ex);
			throw expDao;
		}finally {
			session.close();
		}
		return lista;
	}
	
	

}
