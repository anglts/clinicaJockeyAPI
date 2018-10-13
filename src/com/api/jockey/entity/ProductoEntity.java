package com.api.jockey.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto")
public class ProductoEntity {
	
	@Id
	@Column(name="COD_PRODUCTO")
	private String codProducto;
	
	@Column(name="COD_GARANTE")
	private String codGarante;
	
	@Column(name="PRODUCTO")
	private String nombre;
	
	@Column(name="SIGLAS")
	private String siglas;

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getCodGarante() {
		return codGarante;
	}

	public void setCodGarante(String codGarante) {
		this.codGarante = codGarante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSiglas() {
		return siglas;
	}

	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	
}
