package com.api.jockey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.jockey.domain.Producto;
import com.api.jockey.domain.ProductoHistorico;
import com.api.jockey.service.ProductoService;

@RestController
@RequestMapping(value = "/producto", produces= MediaType.APPLICATION_JSON_VALUE)
public class ProductoController {
	
	@Autowired
	private ProductoService productoServicio;

	// @ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Producto> getProducto(@RequestBody Producto prod) {
		System.out.println("Requested cod de producto." + prod.getCodProducto());
		Producto producto = productoServicio.getProducto(prod.getCodProducto());
		if (producto == null) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getProductos", method = RequestMethod.GET)
	public ResponseEntity<List<Producto>> getProductos() {
		System.out.println("Requested list of productos.");
		List<Producto> productos = productoServicio.getProductos();
		if (productos == null) {
			return new ResponseEntity<List<Producto>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.FOUND);
	}
	
	@RequestMapping(value="/getProducto/{codProducto}", method = RequestMethod.GET)
	public ResponseEntity<Producto> getProducto(@PathVariable String codProducto) {
		System.out.println("Requested cod de producto: " + codProducto);
		Producto producto = productoServicio.getProducto(codProducto);
		if (producto == null) {
			return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Producto>(producto, HttpStatus.FOUND);
	}
	
	@RequestMapping(value="/crearProducto", method = RequestMethod.POST)
	public ResponseEntity<ProductoHistorico> createProductoHistorico(@RequestBody ProductoHistorico productoHistorico) {
		System.out.println("Create producto historico: " + productoHistorico.getCodProducto());
		boolean saveFlag = productoServicio.saveProductoHistorico(productoHistorico);
		if (!saveFlag) {
			return new ResponseEntity<ProductoHistorico>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ProductoHistorico>(productoHistorico, HttpStatus.CREATED);
	}
}
