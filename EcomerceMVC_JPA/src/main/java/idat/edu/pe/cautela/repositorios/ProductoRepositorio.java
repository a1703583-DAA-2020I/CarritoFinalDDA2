package idat.edu.pe.cautela.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.cautela.modelo.Producto;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {

}
