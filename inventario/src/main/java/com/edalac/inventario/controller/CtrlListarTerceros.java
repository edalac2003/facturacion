package com.edalac.inventario.controller;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.edalac.inventario.dto.TbTercero;
import com.edalac.inventario.ngc.TerceroNGC;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

public class CtrlListarTerceros extends GenericForwardComposer {
	private Listbox listadoTerceros;
	
	private TerceroNGC terceroNgc;
		
	
	private void llenarGridTercero(){
		List<TbTercero> listaTerceros = null;		
		try {
			listaTerceros = terceroNgc.listarTerceros();
			Rows rows = new Rows();
			for(TbTercero tercero : listaTerceros){
				final Listitem listaItem = new Listitem();
				Listcell celdaNit = new Listcell(tercero.getNbNit().toString());
				Listcell celdaApellidos = new Listcell(tercero.getVrApellidos());
				Listcell celdaNombres = new Listcell(tercero.getVrNombres());
//				Listcell celdaTipoDoc = new Listcell(tercero.getTbTipodocumento().getVrNombre());
//				Listcell celdaTipoPersona = new Listcell(tercero.getTbTipopersona().getVrDescripcion());
				Listcell celdaEmail= new Listcell(tercero.getVrEmail());
				Listcell celdaCiudad = new Listcell(tercero.getTbCiudad().getVrNombre());
				
				listaItem.appendChild(celdaNit);
				listaItem.appendChild(celdaApellidos);
				listaItem.appendChild(celdaNombres);
//				listaItem.appendChild(celdaTipoDoc);
//				listaItem.appendChild(celdaTipoPersona);
				listaItem.appendChild(celdaEmail);
				listaItem.appendChild(celdaCiudad);
				
				listadoTerceros.appendChild(listaItem);
			}
			
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		
	}
	
	public void onDoubleClick$listadoTerceros(){
		Listitem seleccionado = listadoTerceros.getSelectedItem();
		if(seleccionado != null){
			Messagebox.show("Aviso", "Aviso", Messagebox.OK, Messagebox.ERROR);
		}
	}
	
	private void mostrarInformacionTercero(TbTercero tercero){
		if(tercero != null){
			Messagebox.show("Seleccionó el rgistro "+tercero.getNbNit());
		}
	}
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {		
		super.doAfterCompose(comp);
		llenarGridTercero();
	}

	public void setTerceroNgc(TerceroNGC terceroNgc) {
		this.terceroNgc = terceroNgc;
	}		
}
