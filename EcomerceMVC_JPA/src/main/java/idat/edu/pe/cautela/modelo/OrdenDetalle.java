package idat.edu.pe.cautela.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ordendetalle")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="OrdenDetalle.findAll", query = "SELECT d FROM OrdenDetalle d")
	,@NamedQuery(name="OrdenDetalle.findByIdordenDetalle", query = "SELECT d FROM OrdenDetalle d WHERE d.idordenDetalle= :idordenDetalle")
	,@NamedQuery(name="OrdenDetalle.findByCantidad", query = "SELECT d FROM OrdenDetalle d WHERE d.cantidad= :cantidad")
	,@NamedQuery(name="OrdenDetalle.findByPrecio", query = "SELECT d FROM OrdenDetalle d WHERE d.precio= :precio")
})
public class OrdenDetalle implements Serializable {

	
	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column(name="idordenDetalle")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idordenDetalle;
	
	@JoinColumn(name="fk_idOrden", referencedColumnName="idOrden")
	@ManyToOne(optional=false)
	private Orden fk_idOrden;
	
	@JoinColumn(name="fk_idProductoDetalle", referencedColumnName="idProducto")
	@ManyToOne(optional=false)
	private Producto fk_idProductoDetalle;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="precio")
	private Double precio;
	
	
	public OrdenDetalle() {
		
	}
	
	public OrdenDetalle(Integer idordenDetalle)
	{
		this.idordenDetalle=idordenDetalle;
	}
	

	public OrdenDetalle(Integer idordenDetalle, Integer cantidad, Double precio) {
		super();
		this.idordenDetalle = idordenDetalle;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public OrdenDetalle(Orden fk_idOrden, Producto fk_idProductoDetalle, Integer cantidad, Double precio) {
		super();
		this.fk_idOrden = fk_idOrden;
		this.fk_idProductoDetalle = fk_idProductoDetalle;
		this.cantidad = cantidad;
		this.precio = precio;
	}


	public Integer getIdordenDetalle() {
		return idordenDetalle;
	}


	public void setIdordenDetalle(Integer idordenDetalle) {
		this.idordenDetalle = idordenDetalle;
	}


	public Orden getFk_idOrden() {
		return fk_idOrden;
	}


	public void setFk_idOrden(Orden fk_idOrden) {
		this.fk_idOrden = fk_idOrden;
	}


	public Producto getFk_idProductoDetalle() {
		return fk_idProductoDetalle;
	}


	public void setFk_idProductoDetalle(Producto fk_idProductoDetalle) {
		this.fk_idProductoDetalle = fk_idProductoDetalle;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	
	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idordenDetalle != null ? idordenDetalle.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof OrdenDetalle)) {
	            return false;
	        }
	        OrdenDetalle other = (OrdenDetalle) object;
	        if ((this.idordenDetalle == null && other.idordenDetalle != null) || (this.idordenDetalle != null && !this.idordenDetalle.equals(other.idordenDetalle))) {
	            return false;
	        }
	        return true;
	    }
	
	
	@Override
	public String toString() {
		return "idat.edu.pe.cautela.modelo.OrdenDetalle[ idordenDetalle=" + idordenDetalle + " ]";
	}
	
	
	

}
