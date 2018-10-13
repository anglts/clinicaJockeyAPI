package com.api.jockey.service;

import java.util.List;

import com.api.jockey.domain.Producto;
import com.api.jockey.domain.ProductoHistorico;

public interface ProductoService {
	
	public boolean saveProducto(Producto producto);
	
	public List<Producto> getProductos();

	public Producto getProducto(String codProducto);

	public boolean deleteProducto(String codProducto);
	
	/**Historico producto
	 * 
	 */
	public boolean saveProductoHistorico(ProductoHistorico productoHistorico);
}
