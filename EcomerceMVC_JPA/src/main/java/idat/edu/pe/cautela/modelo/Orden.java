package idat.edu.pe.cautela.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="orden")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name= "Orden.findAll", query = "SELECT o FROM  Orden o")
	,@NamedQuery(name= "Orden.findByIdOrden", query = "SELECT o FROM  Orden o  WHERE o.idOrden = :idOrden")
	,@NamedQuery(name= "Orden.findByMetodoPagoOrden", query = "SELECT o FROM  Orden o  WHERE o.MetodoPagoOrden = :MetodoPagoOrden")
	,@NamedQuery(name= "Orden.findByTotal", query = "SELECT o FROM  Orden o  WHERE o.total = :total")
	,@NamedQuery(name= "Orden.findByIdDomicilio", query = "SELECT o FROM  Orden o  WHERE o.idDomicilio = :idDomicilio")})
public class Orden implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column(name="idOrden")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrden;
	
	@JoinColumn(name="fk_idUsuarioOrden", referencedColumnName="idUsuario")
	@ManyToOne(optional=false)
	private Usuario fk_idUsuarioOrden;
	
	@Column(name="MetodoPagoOrden")
	private String MetodoPagoOrden;
	
	@Column(name="total")
	private Double total;
	
	@Column(name="idDomicilio")
	private int idDomicilio;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy = "fk_idOrden")
	private List<OrdenDetalle> OrdenDetalleList;
	
	
	public Orden() {
		
	}

	public Orden(Integer idOrden)
	{
		this.idOrden=idOrden;
	}
	

	public Orden(Integer idOrden, String metodoPagoOrden, Double total, int idDomicilio) {
		super();
		this.idOrden = idOrden;
		MetodoPagoOrden = metodoPagoOrden;
		this.total = total;
		this.idDomicilio = idDomicilio;
	}

	public Orden(Usuario fk_idUsuarioOrden, String metodoPagoOrden, Double total, int idDomicilio,
			List<OrdenDetalle> ordenDetalleList) {
		super();
		this.fk_idUsuarioOrden = fk_idUsuarioOrden;
		MetodoPagoOrden = metodoPagoOrden;
		this.total = total;
		this.idDomicilio = idDomicilio;
		OrdenDetalleList = ordenDetalleList;
	}


	public Integer getIdOrden() {
		return idOrden;
	}


	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}


	public Usuario getFk_idUsuarioOrden() {
		return fk_idUsuarioOrden;
	}


	public void setFk_idUsuarioOrden(Usuario fk_idUsuarioOrden) {
		this.fk_idUsuarioOrden = fk_idUsuarioOrden;
	}


	public String getMetodoPagoOrden() {
		return MetodoPagoOrden;
	}


	public void setMetodoPagoOrden(String metodoPagoOrden) {
		MetodoPagoOrden = metodoPagoOrden;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public int getIdDomicilio() {
		return idDomicilio;
	}


	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	@XmlTransient
	public List<OrdenDetalle> getOrdenDetalleList() {
		return OrdenDetalleList;
	}


	public void setOrdenDetalleList(List<OrdenDetalle> ordenDetalleList) {
		OrdenDetalleList = ordenDetalleList;
	}

	
	
	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idOrden != null ? idOrden.hashCode() : 0);
	        return hash;
	    }
	
	
	 
	 
	 @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Orden)) {
	            return false;
	        }
	        Orden other = (Orden) object;
	        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
	            return false;
	        }
	        return true;
	    }
	

	

	@Override
	public String toString() {
		return "idat.edu.pe.cautela.modelo.Orden[ idOrden=" + idOrden + " ]";
	}


	
	
}
