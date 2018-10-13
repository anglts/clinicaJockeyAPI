package com.api.jockey.domain;

import java.util.Date;

public class ProductoHistorico extends Producto {

	private String version;
	private String codGaranteAlterno;
	private String codProductoAlterno;
	private String condicionesPropias;
	private String codGaranteReferente;
	private String codProductoReferente;
	private Date fechaInicio;
	private Date fechaFin;
	private String estado;
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCodGaranteAlterno() {
		return codGaranteAlterno;
	}
	public void setCodGaranteAlterno(String codGaranteAlterno) {
		this.codGaranteAlterno = codGaranteAlterno;
	}
	public String getCodProductoAlterno() {
		return codProductoAlterno;
	}
	public void setCodProductoAlterno(String codProductoAlterno) {
		this.codProductoAlterno = codProductoAlterno;
	}
	public String getCondicionesPropias() {
		return condicionesPropias;
	}
	public void setCondicionesPropias(String condicionesPropias) {
		this.condicionesPropias = condicionesPropias;
	}
	public String getCodGaranteReferente() {
		return codGaranteReferente;
	}
	public void setCodGaranteReferente(String codGaranteReferente) {
		this.codGaranteReferente = codGaranteReferente;
	}
	public String getCodProductoReferente() {
		return codProductoReferente;
	}
	public void setCodProductoReferente(String codProductoReferente) {
		this.codProductoReferente = codProductoReferente;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
