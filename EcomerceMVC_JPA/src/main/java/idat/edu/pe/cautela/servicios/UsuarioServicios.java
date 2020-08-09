

package idat.edu.pe.cautela.servicios;

import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.cautela.modelo.Usuario;
import idat.edu.pe.cautela.repositorios.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioServicios {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	
	public UsuarioServicios() {
		
	}
	
	
	public List<Usuario> buscarTodoLosUsuarios()
	{
		
		return (List<Usuario>) repositorio.findAll();
	}
	
	
	public Usuario crearUsuario(Usuario nuevoUsuario)
	{
		
		return repositorio.save(nuevoUsuario);
		
	}
	
	
	public Usuario ActualizarUser(Usuario usuarioActualizar)
	{
		Usuario actualUsuario = repositorio.findById(usuarioActualizar.getIdUsuario()).get();
		actualUsuario.setEmail(usuarioActualizar.getEmail());
		actualUsuario.setPass(usuarioActualizar.getPass());
		actualUsuario.setNombres(usuarioActualizar.getNombres());
		actualUsuario.setApellidos(usuarioActualizar.getApellidos());
		
		Usuario actualizadoUsuario = repositorio.save(actualUsuario);
		return actualizadoUsuario;
	}
	
	
	public Usuario buscarPorId(Integer id)
	{
		
		return repositorio.findById(id).get();
		
	}
	
	
	
	public void borrarPorId(Integer idUser)
	{
		
		repositorio.deleteById(idUser);
	}

}
