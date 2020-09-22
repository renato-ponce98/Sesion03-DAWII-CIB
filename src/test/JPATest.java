package test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entidades.Departamento;
import entidades.Empleado;
import entidades.Estacionamiento;
import entidades.Proyecto;

public class JPATest {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_03");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Departamento departamento = new Departamento();
		departamento.setNombre("Sistemas");
		manager.persist(departamento);
		
		Estacionamiento estacionamiento = new Estacionamiento(123, "Z01");
		manager.persist(estacionamiento);
		
		Proyecto proyecto1 = new Proyecto("Proyecto01");
		manager.persist(proyecto1);
		
		Proyecto proyecto2 = new Proyecto("Proyecto01");
		manager.persist(proyecto2);
		
		List<Proyecto> proyectos = Arrays.asList(proyecto1,proyecto2);
		
		Empleado empleado = new Empleado("Dany", new BigDecimal(930), new Date(), departamento, estacionamiento, proyectos);
		manager.persist(empleado);
		
		tx.commit();
	}
}
