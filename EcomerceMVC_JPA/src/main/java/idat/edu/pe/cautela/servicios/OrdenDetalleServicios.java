package idat.edu.pe.cautela.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.cautela.modelo.OrdenDetalle;
import idat.edu.pe.cautela.repositorios.OrdenDetalleRepositorio;

@Service
@Transactional
public class OrdenDetalleServicios {

	@Autowired
	private OrdenDetalleRepositorio repositorio;
	
	public OrdenDetalleServicios() {

	}

	
	
	public List<OrdenDetalle> listarTodoOrdenD()
	{
			
		
		return (List<OrdenDetalle>) repositorio.findAll();
	}
	
	
	public OrdenDetalle crearOrdenDet(OrdenDetalle nuevadetalleOrden)
	{
		
		return repositorio.save(nuevadetalleOrden);
	}
	
	
	public OrdenDetalle actualizarOrden(OrdenDetalle updateOrdenD)
	{
		OrdenDetalle ordenActual = repositorio.findById(updateOrdenD.getIdordenDetalle()).get();
		ordenActual.setCantidad(updateOrdenD.getCantidad());
		ordenActual.setPrecio(updateOrdenD.getPrecio());
		
		OrdenDetalle guardarDetalleOrden = repositorio.save(ordenActual);
	
		return guardarDetalleOrden;
	}
	
	
	public OrdenDetalle buscarPorIdDetalleO(Integer id)
	{
		return repositorio.findById(id).get();
	}
	
	
	public void borrarDetalleOrden(Integer id)
	{
		
		repositorio.deleteById(id);
	}
	
}
