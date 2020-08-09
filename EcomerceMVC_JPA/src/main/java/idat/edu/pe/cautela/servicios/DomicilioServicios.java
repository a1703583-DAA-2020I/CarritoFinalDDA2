package idat.edu.pe.cautela.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.cautela.modelo.Domicilio;
import idat.edu.pe.cautela.repositorios.DomicilioRepositorio;

@Service
@Transactional
public class DomicilioServicios {

	@Autowired
	private DomicilioRepositorio repositorio;
	
	public DomicilioServicios() {
		
	}
	
	
	public List<Domicilio> listarDomicilio()
	{
		return (List<Domicilio>) repositorio.findAll();
	}
	
	
	public Domicilio crearDomicilio(Domicilio nuevoDomicilio)
	{
		return repositorio.save(nuevoDomicilio);
	}
	
	public Domicilio actualizarDomicilio(Domicilio updateDomicilio)
	{
		Domicilio actualDomicilio = repositorio.findById(updateDomicilio.getIdDomicilio()).get();
		actualDomicilio.setDistrito(updateDomicilio.getDistrito());
		actualDomicilio.setProvincia(updateDomicilio.getProvincia());
		actualDomicilio.setDireccion(updateDomicilio.getDireccion());
		actualDomicilio.setIdDomicilio(updateDomicilio.getIdDomicilio());
		
		Domicilio guarDomicilio = repositorio.save(actualDomicilio);
		
		return guarDomicilio;
	}
	
	
	public Domicilio mostrarDomicilioId(Integer id)
	{
		return repositorio.findById(id).get();
	}
	
	
	public void borrarDomicilioId(Integer id)
	{
		repositorio.deleteById(id);
	}

}
