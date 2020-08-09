package idat.edu.pe.cautela.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.cautela.modelo.Usuario;


public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

	@Query(value = "SELECT a FROM Usuarios a WHERE a.nombres= ?1")
	public List<Usuario> buscarUsuarioPorNombre(String nombres);
	
	@Query(value = "SELECT a FROM Usuarios a WHERE a.nombres like CONCAT(?1, '%')")
	public List<Usuario> buscarUsuarioLikeNombre(String nombres);
	
}
