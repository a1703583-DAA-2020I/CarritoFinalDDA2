package idat.edu.pe.cautela.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import idat.edu.pe.cautela.modelo.Carrito;
import idat.edu.pe.cautela.repositorios.CarritoRepositorio;

@Service
@Transactional
public class CarritoServicios {

	
	private CarritoRepositorio repositorio;
	
	public CarritoServicios() {
		
	}

	
	public List<Carrito> listarTodoCarrito()
	{
		return (List<Carrito>) repositorio.findAll();
	}
	
	
	public Carrito crearCarrito(Carrito nuevoCarrito)
	{
		
		return repositorio.save(nuevoCarrito);
		
	}
	
	
	public Carrito actualizarCarrito(Carrito updateCarrito)
	{
		Carrito actualCarrito = repositorio.findById(updateCarrito.getIdCarrito()).get();
		actualCarrito.setCantidad(updateCarrito.getCantidad());
		
		Carrito carritoActualizado = repositorio.save(actualCarrito);
		
		return carritoActualizado;
	}
	
	
	public Carrito buscarIdCarrito(Integer id)
	{
		return repositorio.findById(id).get();
	}
	
	
	public void borrarCarrito(Integer id)
	{
		repositorio.deleteById(id);
		
	}
	
}
