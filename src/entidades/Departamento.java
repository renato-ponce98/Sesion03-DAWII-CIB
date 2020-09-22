package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEP_ID")
	private Long id;
	
	private String nombre;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.PERSIST)
	private List<Empleado> empleados = new ArrayList<Empleado>();

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

	public Departamento(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Departamento() {}
}
