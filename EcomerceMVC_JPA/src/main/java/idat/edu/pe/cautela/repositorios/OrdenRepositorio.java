package idat.edu.pe.cautela.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.cautela.modelo.Orden;

@Repository
public interface OrdenRepositorio extends CrudRepository<Orden, Integer> {

}
