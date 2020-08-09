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
@Table(name="carrito")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name ="Carrito.findAll", query = "SELECT c FROM Carrito c")
	,@NamedQuery(name ="Carrito.findByIdCarrito", query ="SELECT c FROM Carrito c WHERE c.idCarrito= :idCarrito")
	,@NamedQuery(name ="Carrito.findByCantidad", query ="SELECT c FROM Carrito c WHERE c.cantidad= :cantidad")})
public class Carrito implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional=false)
	@Column(name="idCarrito")
	private Integer idCarrito;
	
	@JoinColumn(name="fk_idUsuarioCarrito" , referencedColumnName="idUsuario")
	@ManyToOne(optional=false)
	private Usuario fk_idUsuarioCarrito;
	
	@JoinColumn(name="fk_idProductoCarrito", referencedColumnName="idProducto")
	@ManyToOne(optional=false)
	private Producto fk_idProductoCarrito;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	
	public Carrito() {
		
	}


	public Carrito(Integer idCarrito, Usuario fk_idUsuarioCarrito, Producto fk_idProductoCarrito, Integer cantidad) {
		super();
		this.idCarrito = idCarrito;
		this.fk_idUsuarioCarrito = fk_idUsuarioCarrito;
		this.fk_idProductoCarrito = fk_idProductoCarrito;
		this.cantidad = cantidad;
	}


	public Integer getIdCarrito() {
		return idCarrito;
	}


	public void setIdCarrito(Integer idCarrito) {
		this.idCarrito = idCarrito;
	}


	public Usuario getFk_idUsuarioCarrito() {
		return fk_idUsuarioCarrito;
	}


	public void setFk_idUsuarioCarrito(Usuario fk_idUsuarioCarrito) {
		this.fk_idUsuarioCarrito = fk_idUsuarioCarrito;
	}


	public Producto getFk_idProductoCarrito() {
		return fk_idProductoCarrito;
	}


	public void setFk_idProductoCarrito(Producto fk_idProductoCarrito) {
		this.fk_idProductoCarrito = fk_idProductoCarrito;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	
	 @Override
	    public int hashCode() {
	        int hash = 0;
	        hash += (idCarrito != null ? idCarrito.hashCode() : 0);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Carrito)) {
	            return false;
	        }
	        Carrito other = (Carrito) object;
	        if ((this.idCarrito == null && other.idCarrito != null) || (this.idCarrito != null && !this.idCarrito.equals(other.idCarrito))) {
	            return false;
	        }
	        return true;
	    }
	
	
	
	
	@Override
	public String toString() {
		return "idat.edu.pe.cautela.modelo.Carrito[ idCarrito=" + idCarrito + " ]";
	}
	
	

}
