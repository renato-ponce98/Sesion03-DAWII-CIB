package entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estacionamiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EST_ID")
	private Long Id;
	
	private Integer numLote;
	
	private String ubicacion;
	
	@OneToOne(mappedBy = "estacionamiento")
	private Empleado empleado;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getNumLote() {
		return numLote;
	}

	public void setNumLote(Integer numLote) {
		this.numLote = numLote;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Estacionamiento(Integer numLote, String ubicacion) {
		super();
		this.numLote = numLote;
		this.ubicacion = ubicacion;
	}
	
	public Estacionamiento() {}
}
