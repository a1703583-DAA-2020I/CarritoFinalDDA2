package idat.edu.pe.cautela;

import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import idat.edu.pe.cautela.modelo.Usuario;
import idat.edu.pe.cautela.servicios.UsuarioServicios;

@SpringBootApplication
public class EcomerceMvcJpaApplication {

	
	public static void main(String[] args) {
	
		
	ConfigurableApplicationContext ctx =	SpringApplication.run(EcomerceMvcJpaApplication.class, args);
	
	 //testCrearUsuario(ctx);
	// testBorrarUsuario(ctx);
	   testActualizarUsuario(ctx);
	
	}
	
	
	private static void testCrearUsuario(ConfigurableApplicationContext ctx) {
		// TODO Auto-generated method stub
		
		UsuarioServicios servicio = ctx.getBean(UsuarioServicios.class);
		
		Usuario usuario = new Usuario();
		
		usuario.setEmail("LesterK@gmail.com");
		usuario.setPass("pas457");
		usuario.setFecha(new Date());
		usuario.setNombres("Lester");
		usuario.setApellidos("kimovich kasparov");
		
		servicio.crearUsuario(usuario);
	}
	
	
	private static void testBuscarUsuario(ConfigurableApplicationContext ctx)
	{
		
		UsuarioServicios servicio = ctx.getBean(UsuarioServicios.class);
		List<Usuario> listaUsuarios= servicio.buscarTodoLosUsuarios();
		System.out.println("Lista de Usuarios encontrada en BD");
		System.out.println(listaUsuarios);
	}
	
	
	private static void testActualizarUsuario(ConfigurableApplicationContext ctx)
	{
		UsuarioServicios servicio = ctx.getBean(UsuarioServicios.class);
		Usuario usuarioActualizar = new Usuario(12,"LesterK@gmail.com","pas457","Herveyt","kimovich kasparov");
		servicio.ActualizarUser(usuarioActualizar);
			
	}
	
	private static void testBorrarUsuario(ConfigurableApplicationContext ctx)
	{
		
		UsuarioServicios servicio = ctx.getBean(UsuarioServicios.class);
		servicio.borrarPorId(11);
	}

}
