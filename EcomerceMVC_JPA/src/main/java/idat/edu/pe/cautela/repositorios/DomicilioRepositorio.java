package idat.edu.pe.cautela.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.cautela.modelo.Domicilio;


@Repository
public interface DomicilioRepositorio extends CrudRepository<Domicilio, Integer> {

}
