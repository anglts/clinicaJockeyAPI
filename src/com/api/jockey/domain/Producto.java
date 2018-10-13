package com.api.jockey.domain;

public class Producto {
	
	private String codProducto;
	private String codGarante;
	private String nombre;
	private String siglas;
	
	public Producto() {
		
	}
	
	public Producto(String codProducto, String codGarante, String nombre, String siglas) {
		super();
		this.codProducto = codProducto;
		this.codGarante = codGarante;
		this.nombre = nombre;
		this.siglas = siglas;
	}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codGarante == null) ? 0 : codGarante.hashCode());
		result = prime * result + ((codProducto == null) ? 0 : codProducto.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((siglas == null) ? 0 : siglas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (codGarante == null) {
			if (other.codGarante != null)
				return false;
		} else if (!codGarante.equals(other.codGarante))
			return false;
		if (codProducto == null) {
			if (other.codProducto != null)
				return false;
		} else if (!codProducto.equals(other.codProducto))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (siglas == null) {
			if (other.siglas != null)
				return false;
		} else if (!siglas.equals(other.siglas))
			return false;
		return true;
	}	

	
}
