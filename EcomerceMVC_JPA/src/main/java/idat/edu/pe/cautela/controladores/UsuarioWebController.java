package idat.edu.pe.cautela.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import idat.edu.pe.cautela.modelo.Usuario;
import idat.edu.pe.cautela.servicios.UsuarioServicios;

@Controller
@RequestMapping("/usuarios")
public class UsuarioWebController {

	@Autowired
	private UsuarioServicios servicios;
	
	@RequestMapping("/listarTodo")
	public String listarUsuario(Model model)
	{
		List<Usuario> listaUsuarios = servicios.buscarTodoLosUsuarios();
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "/moduloUsuarios/listarTodo";
	}
}
