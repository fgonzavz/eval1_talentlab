package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRepository;

@Service
public class ProductoService {
	

	
	//ACA VA LA LOGICA DE NEGOCIO O EMPRESARIAL
	
	//AGREGA LA  DEPENDENCIA DE EMPLEADOSERVICE A EMPLEADOREPOSITORY
	private final ProductoRepository  pr;
	public ProductoService(ProductoRepository productoRepository) {
		this.pr = productoRepository;
	}
	public void crearProducto(@Valid Producto producto) {
		
		pr.save(producto);
		
	}
	public List<Producto> findAll() {
		
		return pr.findAll();
	}
	
	public void eliminarProducto(Long id) {
		pr.deleteById(id);
	}
	
	public Producto buscarProducto(Long id) {

		Optional<Producto> oProducto= pr.findById(id);
		
		if(oProducto.isPresent()) {
			return oProducto.get();
		}
		
		return null;
	}
	public void modificarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		pr.save(producto);
	}

}
