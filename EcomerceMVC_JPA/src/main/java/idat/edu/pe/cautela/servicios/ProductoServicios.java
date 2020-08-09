package idat.edu.pe.cautela.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.cautela.modelo.Producto;
import idat.edu.pe.cautela.repositorios.ProductoRepositorio;

@Service
@Transactional
public class ProductoServicios {

	@Autowired
	private ProductoRepositorio repositorio;
	
	
	public ProductoServicios() {
		
	}
	
	
	public List<Producto> listarTodoLosProductos()
	{
					
		return (List<Producto>) repositorio.findAll();
	}
	
	
	public Producto crearProducto(Producto nuevoProducto)
	{
		return repositorio.save(nuevoProducto);
	}
	
	
	public Producto actualizarProducto(Producto updateProducto)
	{
		Producto productoActual = repositorio.findById(updateProducto.getIdProducto()).get();
		productoActual.setNombre(updateProducto.getNombre());
		productoActual.setPrecio(updateProducto.getPrecio());
		
		Producto guardarProducto= repositorio.save(productoActual);
		
		return guardarProducto;
	}
	
	
	public Producto productoPorId(Integer id)
	{
		return repositorio.findById(id).get();
	}
	
	
	public void borrarProduto(Integer id)
	{
		repositorio.deleteById(id);
	}

}
