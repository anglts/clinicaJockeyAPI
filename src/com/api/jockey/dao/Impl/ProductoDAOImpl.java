package com.api.jockey.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.api.jockey.dao.ProductoDAO;
import com.api.jockey.domain.Producto;
import com.api.jockey.domain.ProductoHistorico;
import com.api.jockey.entity.ProductoEntity;

@Repository
@Component
public class ProductoDAOImpl implements ProductoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@PersistenceContext
	@Qualifier("transactionManager")
    private EntityManager entityManager;

	@Override
	public boolean saveProducto(Producto producto) {
		boolean saveFlag = true;
		ProductoEntity prodEntity = new ProductoEntity();
		prodEntity.setCodProducto(producto.getCodProducto());
		prodEntity.setCodGarante(producto.getCodGarante());
		prodEntity.setNombre(producto.getNombre());
		prodEntity.setSiglas(producto.getSiglas());
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(prodEntity);
			// currentSession.saveOrUpdate(accountEntity);createQuery(
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

	@Override
	public List<Producto> getProductos() {
		List<Producto> list = new ArrayList<Producto>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("From ProductoEntity");
			List<?> productos = query.list();
			for (int i = 0; i < productos.size(); i++) {
				ProductoEntity productoEntity = (ProductoEntity) productos.get(i);
				Producto producto = new Producto();
				producto.setCodProducto(productoEntity.getCodProducto());
				producto.setCodGarante(productoEntity.getCodGarante());
				producto.setNombre(productoEntity.getNombre());
				producto.setSiglas(productoEntity.getSiglas());
				list.add(producto);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return list;
	}

	@Override
	public Producto getProducto(String codProducto) {
		Producto producto = new Producto();
		try {
			Session session = sessionFactory.getCurrentSession();
			ProductoEntity productoEntity = (ProductoEntity) session.get(ProductoEntity.class, codProducto);
			if (productoEntity == null) {
				return null;
			}
			producto.setCodProducto(productoEntity.getCodProducto());
			producto.setCodGarante(productoEntity.getCodGarante());
			producto.setNombre(productoEntity.getNombre());
			producto.setSiglas(productoEntity.getSiglas());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return producto;
	}

	@Override
	public boolean deleteProducto(String codProducto) {
		boolean deleteFlag = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			ProductoEntity productoEntity = (ProductoEntity) session.load(ProductoEntity.class, codProducto);
			session.delete(productoEntity);
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			deleteFlag = false;
		}
		return deleteFlag;
	}

	@Override
	public boolean saveProductoHistorico(ProductoHistorico prodHistorico) {
		
		try {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_PRODUCTO.SP_REGISTRAR_PRODUCTO")
					.registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(5, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(6, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(7, Date.class, ParameterMode.IN)
					.registerStoredProcedureParameter(8, Date.class, ParameterMode.IN)
					.registerStoredProcedureParameter(9, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(10, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(11, String.class, ParameterMode.IN)
					.registerStoredProcedureParameter(12, String.class, ParameterMode.IN)
					.setParameter(1, prodHistorico.getCodGarante())
					.setParameter(2, prodHistorico.getCodProducto())
					.setParameter(3, prodHistorico.getNombre())
					.setParameter(4, prodHistorico.getSiglas())
					.setParameter(5, prodHistorico.getCodGaranteAlterno())
					.setParameter(6, prodHistorico.getCodProductoAlterno())
					.setParameter(7, prodHistorico.getFechaInicio())
					.setParameter(8, prodHistorico.getFechaFin())
					.setParameter(9, prodHistorico.getCodGaranteReferente())
					.setParameter(10, prodHistorico.getCodProductoReferente())
					.setParameter(11, prodHistorico.getCondicionesPropias())
					.setParameter(12, prodHistorico.getEstado());

			query.execute();

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}		

		return true;
	}

}
