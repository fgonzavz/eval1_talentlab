package com.everis.data.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.everis.data.models.Venta;
import com.everis.data.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	private final VentaService vs;

	public VentaController(VentaService ventaService) {
		this.vs = ventaService;
	}

	
	
	@RequestMapping("")
	public String index(@ModelAttribute("venta") Venta venta, Model model) {
		
		List<Venta> lista_ventas = vs.findAll();
		model.addAttribute("lista_ventas", lista_ventas);
		return "venta.jsp";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("venta") Venta venta, RedirectAttributes redAtt) {
		
		if (venta.getCodigo().isBlank() || venta.getCodigo().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "El codigo de la venta  esta vacio");
			return "redirect:/venta";
			// persona.getNombre() = "";
		} else {
			if (venta.getCodigo().length() <0) {

				redAtt.addFlashAttribute("mensaje", "codigo de la venta esta fuera  del rango");
				return "redirect:/venta";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");
			}
		}
		if (venta.getCantidad_vendida().isBlank() || venta.getCantidad_vendida().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "la cantidad de la venta  esta vacio");
			return "redirect:/venta";
		} else {
			if (venta.getCantidad_vendida().length() < 0 ) {

				redAtt.addFlashAttribute("mensaje", "la cantidad de la venta esta fuera del rango");
				return "redirect:/venta";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

			}
		}
		if (venta.getPrecio().isBlank() || venta.getPrecio().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "El precio de la venta  esta vacio");
			return "redirect:/persona";
		} else {
			if (venta.getPrecio().length() < 0) {

				redAtt.addFlashAttribute("mensaje", "el precio de la venta esta fuera del rango");
				return "redirect:/venta";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

			}
		}
		
		System.out.println("crear" + venta);
		vs.crearVenta(venta);
	
		return "redirect:/venta";
	}

	//METODO ACTUALIZAR	
		@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
		public String actualizar(@PathVariable("id") Long id, Model model) {
			System.out.println("actualizar id: "+ id);
			
			Venta venta = vs.buscarVenta(id);
			
			model.addAttribute("venta", venta);
			return "editar_venta.jsp";
		}

	// METODO DE MODIFICAR
		@RequestMapping(value="/modificar",method= RequestMethod.PUT)
		public String modificar(@Valid @ModelAttribute("venta") Venta venta, RedirectAttributes redAtt) {
			
			if (venta.getCodigo().isBlank() || venta.getCodigo().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "El codigo de la venta  esta vacio");
				return "redirect:/venta";
				// persona.getNombre() = "";
			} else {
				if (venta.getCodigo().length() <0) {

					redAtt.addFlashAttribute("mensaje", "codigo de la venta esta fuera  del rango");
					return "redirect:/venta";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");
				}
			}
			if (venta.getCantidad_vendida().isBlank() || venta.getCantidad_vendida().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "la cantidad de la venta  esta vacio");
				return "redirect:/venta";
			} else {
				if (venta.getCantidad_vendida().length() < 0 ) {

					redAtt.addFlashAttribute("mensaje", "la cantidad de la venta esta fuera del rango");
					return "redirect:/venta";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

				}
			}
			if (venta.getPrecio().isBlank() || venta.getPrecio().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "El precio de la venta  esta vacio");
				return "redirect:/persona";
			} else {
				if (venta.getPrecio().length() < 0) {

					redAtt.addFlashAttribute("mensaje", "el precio de la venta esta fuera del rango");
					return "redirect:/venta";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

				}
			}
			
			System.out.println("el Id a modificar es: "+venta.getId());
			vs.modificarVenta(venta);
			
			return "redirect:/venta";
		}


	@RequestMapping(value = "/eliminar2/{id}", method = RequestMethod.DELETE)
	public String eliminar2(@PathVariable("id") Long id) {
		System.out.println("eliminar" + id);
		vs.eliminarVenta(id);
		return "redirect:/venta";
	}

	@RequestMapping("/buscar")
	public String buscar() {
		return "venta.jsp";
	}



}
