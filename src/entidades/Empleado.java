package entidades;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private Long id;
	
	@Column(name = "EMP_NOMBRE")
	private String nombre;
	
	@Column(name = "EMP_SALARIO", precision = 10, scale = 2)
	private BigDecimal salario;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "EMP_FEC_ING")
	private Date fechaIngreso;
	
	@ManyToOne
	@JoinColumn(name = "DEP_ID")
	private Departamento departamento;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "EST_ID", referencedColumnName = "EST_ID", unique = true)
	private Estacionamiento estacionamiento;
	
	@ManyToMany
	@JoinTable(name = "Empleado_Proyecto", joinColumns = {
			@JoinColumn(name = "EMP_ID")
	},
	inverseJoinColumns = {
			@JoinColumn(name = "PROY_ID")
	})
	private Collection<Proyecto> proyectos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public Estacionamiento getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
	
	public Collection<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Collection<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	public Empleado(String nombre, BigDecimal salario, Date fechaIngreso, Departamento departamento,
			Estacionamiento estacionamiento, Collection<Proyecto> proyectos) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.fechaIngreso = fechaIngreso;
		this.departamento = departamento;
		this.estacionamiento = estacionamiento;
		this.proyectos = proyectos;
	}

	public Empleado() {}
	

}
