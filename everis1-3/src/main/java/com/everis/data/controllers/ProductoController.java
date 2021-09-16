package com.everis.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;



@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	private final ProductoService ps;

	public ProductoController(ProductoService productoService) {
		this.ps = productoService;
	}

	
	
	@RequestMapping("")
	public String index(@ModelAttribute("producto") Producto producto, Model model) {
		
		List<Producto> lista_productos = ps.findAll();
		model.addAttribute("lista_productos", lista_productos);
		return "producto.jsp";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("producto") Producto producto, RedirectAttributes redAtt) {
		System.out.println("crear" + producto);
		
		
		if (producto.getNombre().isBlank() || producto.getNombre().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "El nombre del producto  esta vacio");
			return "redirect:/producto";
			
		} else {
			if (producto.getNombre().length() < 3 || producto.getNombre().length() > 20) {

				redAtt.addFlashAttribute("mensaje", " el nombre del producto esta fuera del rango");
				return "redirect:/producto";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente el producto");
			}
		}
		if (producto.getCodigo().isBlank() || producto.getCodigo().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "El codigo  esta vacio");
			return "redirect:/producto";
		} else {
			if (producto.getCodigo().length() < 3 || producto.getCodigo().length() > 20) {

				redAtt.addFlashAttribute("mensaje", "el codigo del producto esta fuera del rango");
				return "redirect:/producto";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

			}
		}
		if (producto.getPrecio().isBlank() || producto.getPrecio().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "El precio del producto  esta vacio");
			return "redirect:/producto";
		} else {
			if (producto.getPrecio().length() < 0) {

				redAtt.addFlashAttribute("mensaje", "precio del producto esta  fuera del rango");
				return "redirect:/producto";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

			}
		}
		if ( producto.getStock().isBlank() || producto.getStock().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "el stock del producto  esta vacio");
			return "redirect:/producto";
		} else {
			if (producto.getStock().length() < 0) {

				redAtt.addFlashAttribute("mensaje", "el stock esta fuera  del rango");
				return "redirect:/producto";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

			}
		}

		
		ps.crearProducto(producto);
		
		return "redirect:/producto";
	}

	//METODO ACTUALIZAR	
		@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
		public String actualizar(@PathVariable("id") Long id, Model model) {
			System.out.println("actualizar id: "+ id);
			
			Producto producto = ps.buscarProducto(id);
			
			model.addAttribute("producto", producto);
			return "editar_producto.jsp";
		}

	// METODO DE MODIFICAR
		@RequestMapping(value="/modificar",method= RequestMethod.PUT)
		public String modificar(@Valid @ModelAttribute("producto") Producto producto, RedirectAttributes redAtt) {
			
			System.out.println("el Id a modificar es: "+producto.getId());
			
			
			
			if (producto.getNombre().isBlank() || producto.getNombre().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "El nombre del producto  esta vacio");
				return "redirect:/producto";
				
			} else {
				if (producto.getNombre().length() < 3 || producto.getNombre().length() > 20) {

					redAtt.addFlashAttribute("mensaje", " el nombre del producto esta fuera del rango");
					return "redirect:/producto";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente el producto");
				}
			}
			if (producto.getCodigo().isBlank() || producto.getCodigo().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "El codigo  esta vacio");
				return "redirect:/producto";
			} else {
				if (producto.getCodigo().length() < 3 || producto.getCodigo().length() > 20) {

					redAtt.addFlashAttribute("mensaje", "el codigo del producto esta fuera del rango");
					return "redirect:/producto";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

				}
			}
			if (producto.getPrecio().isBlank() || producto.getPrecio().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "El precio del producto  esta vacio");
				return "redirect:/producto";
			} else {
				if (producto.getPrecio().length() < 0) {

					redAtt.addFlashAttribute("mensaje", "precio del producto esta  fuera del rango");
					return "redirect:/producto";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

				}
			}
			if ( producto.getStock().isBlank() || producto.getStock().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "el stock del producto  esta vacio");
				return "redirect:/producto";
			} else {
				if (producto.getStock().length() < 0) {

					redAtt.addFlashAttribute("mensaje", "el stock esta fuera  del rango");
					return "redirect:/producto";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

				}
			}
			
			
			ps.modificarProducto(producto);
			
			return "redirect:/producto";
		}


	@RequestMapping(value = "/eliminar2/{id}", method = RequestMethod.DELETE)
	public String eliminar2(@PathVariable("id") Long id) {
		System.out.println("eliminar" + id);
		ps.eliminarProducto(id);
		return "redirect:/producto";
	}

	@RequestMapping("/buscar")
	public String buscar() {
		return "producto.jsp";
	}

}
