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

import com.everis.data.models.Usuario;
import com.everis.data.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final UsuarioService us;

	public UsuarioController(UsuarioService usuarioService) {
		this.us = usuarioService;
	}

	
	
	@RequestMapping("")
	public String index(@ModelAttribute("usuario") Usuario usuario, Model model) {
		
		List<Usuario> lista_usuarios = us.findAll();
		model.addAttribute("lista_usuarios", lista_usuarios);
		return "usuario.jsp";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("usuario") Usuario usuario,RedirectAttributes redAtt) {
		
		
		if (usuario.getNombre().isBlank() || usuario.getNombre().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "El nombre del usuario esta vacio");
			return "redirect:/usuario";
			// persona.getNombre() = "";
		} else {
			if (usuario.getNombre().length() < 3 || usuario.getNombre().length() > 20) {

				redAtt.addFlashAttribute("mensaje", "el nombre del usuario esta fuera del rango");
				return "redirect:/usuario";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");
			}
		}
		if (usuario.getApellido().isBlank() || usuario.getApellido().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "El apellido del usuario esta vacio");
			return "redirect:/usuario";
		} else {
			if (usuario.getApellido().length() < 3 || usuario.getApellido().length() > 20) {

				redAtt.addFlashAttribute("mensaje", "el apellido del usuario esta fuera del rango");
				return "redirect:/usuario";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

			}
		}
		if (usuario.getEdad().isBlank() || usuario.getEdad().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "la edad esta vacio");
			return "redirect:/usuario";
		} else {
			if (usuario.getEdad().length() < 0) {

				redAtt.addFlashAttribute("mensaje", "la edad del usuario  fuera del rango");
				return "redirect:/usuario";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

			}
		}
		if (usuario.getRut().isBlank() || usuario.getRut().isEmpty()) {

			redAtt.addFlashAttribute("mensaje", "El rut del usuario  esta vacio");
			return "redirect:/usuario";
		} else {
			if (usuario.getRut().length() < 0 || usuario.getRut().length() > 9) {

				redAtt.addFlashAttribute("mensaje", "el rut del usuario esta  del rango");
				return "redirect:/usuario";
			} else {
				redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

			}
		}
	
		System.out.println("crear" + usuario);
		
		us.crearUsuario(usuario);
	
		return "redirect:/usuario";
	}

	//METODO ACTUALIZAR	
		@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
		public String actualizar(@PathVariable("id") Long id, Model model) {
			System.out.println("actualizar id: "+ id);
			
			Usuario usuario = us.buscarUsuario(id);
			
			model.addAttribute("usuario", usuario);
			return "editar_usuario.jsp";
		}

	// METODO DE MODIFICAR
		@RequestMapping(value="/modificar",method= RequestMethod.PUT)
		public String modificar(@Valid @ModelAttribute("usuario") Usuario usuario, RedirectAttributes redAtt) {
			
			

			
			if (usuario.getNombre().isBlank() || usuario.getNombre().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "El nombre del usuario esta vacio");
				return "redirect:/usuario";
				// persona.getNombre() = "";
			} else {
				if (usuario.getNombre().length() < 3 || usuario.getNombre().length() > 20) {

					redAtt.addFlashAttribute("mensaje", "el nombre del usuario esta fuera del rango");
					return "redirect:/usuario";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");
				}
			}
			if (usuario.getApellido().isBlank() || usuario.getApellido().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "El apellido del usuario esta vacio");
				return "redirect:/usuario";
			} else {
				if (usuario.getApellido().length() < 3 || usuario.getApellido().length() > 20) {

					redAtt.addFlashAttribute("mensaje", "el apellido del usuario esta fuera del rango");
					return "redirect:/usuario";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

				}
			}
			if (usuario.getEdad().isBlank() || usuario.getEdad().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "la edad esta vacio");
				return "redirect:/usuario";
			} else {
				if (usuario.getEdad().length() < 0) {

					redAtt.addFlashAttribute("mensaje", "la edad del usuario  fuera del rango");
					return "redirect:/usuario";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

				}
			}
			if (usuario.getRut().isBlank() || usuario.getRut().isEmpty()) {

				redAtt.addFlashAttribute("mensaje", "El rut del usuario  esta vacio");
				return "redirect:/usuario";
			} else {
				if (usuario.getRut().length() < 0 || usuario.getRut().length() > 9) {

					redAtt.addFlashAttribute("mensaje", "el rut del usuario esta  del rango");
					return "redirect:/usuario";
				} else {
					redAtt.addFlashAttribute("mensaje", "se agrego correctamente");

				}
			}
			
			System.out.println("el Id a modificar es: "+usuario.getId());
			us.modificarUsuario(usuario);
			
			return "redirect:/usuario";
		}


	@RequestMapping(value = "/eliminar2/{id}", method = RequestMethod.DELETE)
	public String eliminar2(@PathVariable("id") Long id) {
		System.out.println("eliminar" + id);
		us.eliminarUsuario(id);
		return "redirect:/usuario";
	}

	@RequestMapping("/buscar")
	public String buscar() {
		return "usuario.jsp";
	}



}
