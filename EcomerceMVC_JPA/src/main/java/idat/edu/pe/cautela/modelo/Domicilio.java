package idat.edu.pe.cautela.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="domicilio")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Domicilio.findAll", query = "SELECT d FROM Domicilio d")
     ,@NamedQuery(name = "Domicilio.findByIdDomicilio", query = " SELECT d FROM Domicilio d WHERE  d.idDomicilio=:idDomicilio")
	,@NamedQuery(name = "Domicilio.findByDireccion", query = " SELECT d FROM Domicilio d WHERE  d.direccion=:direccion")
	,@NamedQuery(name = "Domicilio.findByDepartamento", query = " SELECT d FROM Domicilio d WHERE  d.Departamento=:Departamento")
	,@NamedQuery(name = "Domicilio.findByProvincia", query = " SELECT d FROM Domicilio d WHERE  d.provincia=:provincia")
	,@NamedQuery(name = "Domicilio.findByDistrito", query = " SELECT d FROM Domicilio d WHERE  d.distrito=:distrito")})
public class Domicilio implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column(name="idDomicilio")
	private Integer idDomicilio;
	
	@JoinColumn(name="fk_idUsuarioDomicilio", referencedColumnName="idUsuario")
	@ManyToOne(optional=false)
	private Usuario fk_idUsuarioDomicilio;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="Departamento")
	private String Departamento;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="distrito")
	private String distrito;
	
	
	public Domicilio() {
		
	}

	public Domicilio(Integer idDomicilio)
	{
		this.idDomicilio=idDomicilio;
	}
	
	

	public Domicilio(Integer idDomicilio, String direccion, String departamento, String provincia, String distrito) {
		super();
		this.idDomicilio = idDomicilio;
		this.direccion = direccion;
		Departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
	}

	public Domicilio(Integer idDomicilio, Usuario fk_idUsuarioDomicilio, String direccion, String departamento,
			String provincia, String distrito) {
		super();
		this.idDomicilio = idDomicilio;
		this.fk_idUsuarioDomicilio = fk_idUsuarioDomicilio;
		this.direccion = direccion;
		Departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
	}


	public Integer getIdDomicilio() {
		return idDomicilio;
	}


	public void setIdDomicilio(Integer idDomicilio) {
		this.idDomicilio = idDomicilio;
	}


	public Usuario getFk_idUsuarioDomicilio() {
		return fk_idUsuarioDomicilio;
	}


	public void setFk_idUsuarioDomicilio(Usuario fk_idUsuarioDomicilio) {
		this.fk_idUsuarioDomicilio = fk_idUsuarioDomicilio;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDepartamento() {
		return Departamento;
	}


	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	
	
	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idDomicilio != null ? idDomicilio.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Domicilio)) {
	            return false;
	        }
	        Domicilio other = (Domicilio) object;
	        if ((this.idDomicilio == null && other.idDomicilio != null) || (this.idDomicilio != null && !this.idDomicilio.equals(other.idDomicilio))) {
	            return false;
	        }
	        return true;
	    }
	
	
	

	@Override
	public String toString() {
		return "idat.edu.pe.cautela.modelo.Domicilio[ idDomicilio=" + idDomicilio + " ]";
	}
	
	
	

}
