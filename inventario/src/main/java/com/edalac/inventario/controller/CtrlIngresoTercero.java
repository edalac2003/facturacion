package com.edalac.inventario.controller;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import com.edalac.inventario.dto.TbCiudad;
import com.edalac.inventario.dto.TbDepartamento;
import com.edalac.inventario.dto.TbPais;
import com.edalac.inventario.dto.TbTercero;
import com.edalac.inventario.dto.TbTipodocumento;
import com.edalac.inventario.dto.TbTipopersona;
import com.edalac.inventario.ngc.CiudadNGC;
import com.edalac.inventario.ngc.DepartamentoNGC;
import com.edalac.inventario.ngc.PaisNGC;
import com.edalac.inventario.ngc.TerceroNGC;
import com.edalac.inventario.util.exceptions.ExcepcionesNGC;

@SuppressWarnings("rawtypes")
public class CtrlIngresoTercero extends GenericForwardComposer{

	private static final long serialVersionUID = 1L;
	private Combobox cmbTipoIdentificacion;
	private Decimalbox nbNumeroId;
	private Decimalbox nbDigitoVerificacion;
	private Textbox txtNombres;
	private Textbox txtApellidos;
	private Textbox txtDireccion;
	private Textbox txtEmail;
	private Decimalbox nbTelefono;
	private Combobox cmbTipoTercero;
	private Combobox cmbPais;
	private Combobox cmbDepartamento;
	private Combobox cmbCiudad;
	private Button btnGuardar;
	
	private PaisNGC paisNgc;
	private DepartamentoNGC dptoNgc;
	private CiudadNGC ciudadNgc;
	private TerceroNGC terceroNgc;
	
	
	public void onClick$btnGuardar(){
		String mensaje = mensajeValidacion();
		TbTercero tercero = null;
		
		if(mensaje == null || mensaje.isEmpty()){
			tercero = new TbTercero();
			tercero.setTbTipodocumento((TbTipodocumento)cmbTipoIdentificacion.getSelectedItem().getValue());
			tercero.setNbIdpersona(nbNumeroId.getValue() != null?nbNumeroId.longValue():0);
			tercero.setNbDigitoverificacion(nbDigitoVerificacion != null?nbDigitoVerificacion.intValue():0);
			tercero.setVrNombres(txtNombres.getValue());
			tercero.setVrApellidos(txtApellidos.getValue());
			tercero.setVrDireccion(txtDireccion.getValue());
			tercero.setVrEmail(txtEmail.getValue());
			tercero.setVrTelefono(nbTelefono.toString());
			tercero.setTbTipopersona((TbTipopersona)cmbTipoTercero.getSelectedItem().getValue());
			tercero.setTbCiudad((TbCiudad)cmbCiudad.getSelectedItem().getValue());
			try {
				terceroNgc.guardarTercero(tercero);
			} catch (ExcepcionesNGC e) {
				Messagebox.show(e.getMensajeUsuario());
			}
		}else{
			Messagebox.show("Debe completar los siguientes campos. \n"+mensaje);
		}
	}
	
	
	public void onSelect$cmbPais(){
		if(cmbPais.getSelectedItem() != null){
			TbPais pais = (TbPais) cmbPais.getSelectedItem().getValue();
			llenarComboDepartamento(pais);
			cmbDepartamento.focus();
			Messagebox.show("En la lista Departamentos hay "+pais.getTbDepartamentos().size());
		}
		
	}	
	public void onSelect$cmbDepartamento(){
		if(cmbPais == null){
			Messagebox.show("Debe seleccionar un Pais.");
			return;
		}
		if(cmbDepartamento.getSelectedItem() != null){
			TbDepartamento dpto = (TbDepartamento) cmbDepartamento.getSelectedItem().getValue();
			llenarComboCiudades(dpto);
			cmbDepartamento.focus();
		}		
	}
	public void onSelect$cmbCiudad(){
		if(cmbDepartamento == null)
			Messagebox.show("Debe seleccionar un Departamento.");
	}



	private void llenarComboPais(){
		List<TbPais> listaPais = new ArrayList<TbPais>();
		cmbPais.getItems().clear();
		try {
			listaPais = paisNgc.listarPaises();
			if(listaPais != null && !listaPais.isEmpty()){
				if(listaPais != null  && !listaPais.isEmpty()){
					for(TbPais pais : listaPais){
						Comboitem item = new Comboitem(pais.getVrNombre());
						item.setValue(pais);	
						cmbPais.appendChild(item);
					}
				}else
					Messagebox.show("No se Encontraron Registros de Paises.");
			}
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}				
	}
	
	private void llenarComboDepartamento(TbPais pais){
		List<TbDepartamento> listaDpto = new ArrayList<TbDepartamento>();
		cmbDepartamento.getItems().clear();
		try {
			listaDpto = dptoNgc.listarDepartamentosxPais(pais);
			if(listaDpto != null){
				for(TbDepartamento dpto : listaDpto){
					Comboitem item = new Comboitem(dpto.getVrNombre());
					item.setValue(dpto);	
					cmbDepartamento.appendChild(item);
				}
			}else
				Messagebox.show("No se Encontraron Registros de Departamentos.");
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}		
	}
	
	private void llenarComboCiudades(TbDepartamento dpto){
		List<TbCiudad> listaCiudad = new ArrayList<TbCiudad>();
		cmbCiudad.getItems().clear();
		try {
			listaCiudad = ciudadNgc.listarCiudadesxDepartamento(dpto);
			if(listaCiudad != null && !listaCiudad.isEmpty()){
				for(TbCiudad ciudad : listaCiudad){
					Comboitem item = new Comboitem(ciudad.getVrNombre());
					item.setValue(ciudad);	
					cmbCiudad.appendChild(item);
				}
			}else
				Messagebox.show("No se Encontraron Registros de Ciudades.");
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
	}
	
	private void llenarComboTipoDocumento(){
		List<TbTipodocumento> listaTipoDoc = new ArrayList<TbTipodocumento>();
		cmbTipoIdentificacion.getItems().clear();
		
		try {
			listaTipoDoc = terceroNgc.listarTipoDocumento();
			for(TbTipodocumento tipodoc : listaTipoDoc){
				Comboitem item = new Comboitem(tipodoc.getVrNombre());
				item.setValue(tipodoc);
				cmbTipoIdentificacion.appendChild(item);
			}
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
	}
	
	private void llenarComboTipoPersona(){
		List<TbTipopersona> listaTipoPersona = new ArrayList<TbTipopersona>();
		cmbTipoTercero.getItems().clear();
		
		try {
			listaTipoPersona = terceroNgc.listarTipoPersona();
			for(TbTipopersona tipoPersona : listaTipoPersona){
				Comboitem item = new Comboitem(tipoPersona.getVrDescripcion());
				item.setValue(tipoPersona);
				cmbTipoTercero.appendChild(item);
			}
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
	}
	
	
	private String mensajeValidacion(){
		StringBuilder sb = new StringBuilder();
		if(cmbTipoIdentificacion.getValue() == null || cmbTipoIdentificacion.getValue().isEmpty())
			sb.append("Tipo de Identificacion. \n");
		if(nbNumeroId.getValue() == null || nbNumeroId.getValue().intValue()<=0)
			sb.append("ID / NIT. \n");
		if(txtNombres.getValue() == null || txtNombres.getValue().isEmpty())
			sb.append("Nombres. \n");
		if(txtApellidos.getValue() == null || txtApellidos.getValue().isEmpty())
			sb.append("Apellidos. \n");
		if(txtEmail.getValue() == null || txtEmail.getValue().isEmpty())
			sb.append("Email. \n");
		if(cmbTipoTercero.getValue() == null || cmbTipoTercero.getValue().isEmpty())
			sb.append("Tipo de Tercero. \n");
		if(cmbCiudad.getValue() == null || cmbCiudad.getValue().isEmpty())
			sb.append("Ciudad. \n");
		
		return sb.toString();
	}
	
	/*
	 * Setters para la inyeccion de Dependencias
	 */
	public void setPaisNgc(PaisNGC paisNgc) {
		this.paisNgc = paisNgc;
	}
	public void setDptoNgc(DepartamentoNGC dptoNgc) {
		this.dptoNgc = dptoNgc;
	}
	public void setCiudadNgc(CiudadNGC ciudadNgc) {
		this.ciudadNgc = ciudadNgc;
	}
	public void setTerceroNgc(TerceroNGC terceroNgc) {
		this.terceroNgc = terceroNgc;
	}
	
	/*
	 * Getters y Setters de los Objetos
	 */
	public Combobox getCmbTipoIdentificacion() {
		return cmbTipoIdentificacion;
	}
	public void setCmbTipoIdentificacion(Combobox cmbTipoIdentificacion) {
		this.cmbTipoIdentificacion = cmbTipoIdentificacion;
	}
	public Decimalbox getNbNumeroId() {
		return nbNumeroId;
	}
	public void setNbNumeroId(Decimalbox nbNumeroId) {
		this.nbNumeroId = nbNumeroId;
	}
	public Decimalbox getNbDigitoVerificacion() {
		return nbDigitoVerificacion;
	}
	public void setNbDigitoVerificacion(Decimalbox nbDigitoVerificacion) {
		this.nbDigitoVerificacion = nbDigitoVerificacion;
	}
	public Textbox getTxtNombres() {
		return txtNombres;
	}
	public void setTxtNombres(Textbox txtNombres) {
		this.txtNombres = txtNombres;
	}
	public Textbox getTxtApellidos() {
		return txtApellidos;
	}
	public void setTxtApellidos(Textbox txtApellidos) {
		this.txtApellidos = txtApellidos;
	}
	public Textbox getTxtDireccion() {
		return txtDireccion;
	}
	public void setTxtDireccion(Textbox txtDireccion) {
		this.txtDireccion = txtDireccion;
	}
	public Textbox getTxtEmail() {
		return txtEmail;
	}
	public void setTxtEmail(Textbox txtEmail) {
		this.txtEmail = txtEmail;
	}
	public Decimalbox getNbTelefono() {
		return nbTelefono;
	}
	public void setNbTelefono(Decimalbox nbTelefono) {
		this.nbTelefono = nbTelefono;
	}
	public Combobox getCmbTipoTercero() {
		return cmbTipoTercero;
	}
	public void setCmbTipoTercero(Combobox cmbTipoTercero) {
		this.cmbTipoTercero = cmbTipoTercero;
	}
	public Combobox getCmbPais() {
		return cmbPais;
	}
	public void setCmbPais(Combobox cmbPais) {
		this.cmbPais = cmbPais;
	}
	public Combobox getCmbDepartamento() {
		return cmbDepartamento;
	}
	public void setCmbDepartamento(Combobox cmbDepartamento) {
		this.cmbDepartamento = cmbDepartamento;
	}
	public Combobox getCmbCiudad() {
		return cmbCiudad;
	}
	public void setCmbCiudad(Combobox cmbCiudad) {
		this.cmbCiudad = cmbCiudad;
	}


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		llenarComboTipoDocumento();
		llenarComboTipoPersona();
		llenarComboPais();
	}
	
	
	
}
