package com.api.jockey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.jockey.dao.ProductoDAO;
import com.api.jockey.domain.Producto;
import com.api.jockey.domain.ProductoHistorico;
import com.api.jockey.service.ProductoService;

@Service
public class ProductoServiceImpl  implements ProductoService {
	
	@Autowired
	private ProductoDAO productoDAO;

	@Override
	@Transactional
	public boolean saveProducto(Producto producto) {
		return productoDAO.saveProducto(producto);
	}

	@Override
	@Transactional
	public List<Producto> getProductos() {
		return productoDAO.getProductos();
	}

	@Override
	@Transactional
	public Producto getProducto(String codProducto) {
		return productoDAO.getProducto(codProducto);
	}

	@Override
	@Transactional
	public boolean deleteProducto(String codProducto) {
		return productoDAO.deleteProducto(codProducto);
	}
	
	@Override
	@Transactional
	public boolean saveProductoHistorico(ProductoHistorico productoHistorico) {
		return productoDAO.saveProductoHistorico(productoHistorico);
	}

}
