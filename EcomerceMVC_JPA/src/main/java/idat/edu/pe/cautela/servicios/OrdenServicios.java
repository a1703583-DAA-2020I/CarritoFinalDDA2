package idat.edu.pe.cautela.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.cautela.modelo.Orden;
import idat.edu.pe.cautela.repositorios.OrdenRepositorio;

@Service
@Transactional
public class OrdenServicios {

	@Autowired
	private OrdenRepositorio repositorio;
	
	public OrdenServicios() {
		
	}

	
	public List<Orden> listarTodoOrden()
	{
		return (List<Orden>) repositorio.findAll();
	}
	
	
	public Orden crearOrden(Orden nuevaOrden)
	{
		return repositorio.save(nuevaOrden);
	}
	
	
	public Orden actualizarOrden (Orden updateOrden)
	{
		Orden ordenActual = repositorio.findById(updateOrden.getIdOrden()).get();
		ordenActual.setIdDomicilio(updateOrden.getIdDomicilio());
		ordenActual.setMetodoPagoOrden(updateOrden.getMetodoPagoOrden());
		
		Orden ordenGuardar = repositorio.save(ordenActual);

		return ordenGuardar;
	}
	
	
	public Orden encontrarPorId(Integer id)
	{
		return repositorio.findById(id).get();
	}
	
	
	public void borrarOrden(Integer eliminarOrden)
	{
		repositorio.deleteById(eliminarOrden);
	}
	
}
