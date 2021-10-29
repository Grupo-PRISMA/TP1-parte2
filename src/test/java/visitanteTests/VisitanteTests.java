package visitanteTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import atraccion.Atraccion;
import visitante.Visitante;

public class VisitanteTests {
	
	
	@Test
	public void constructor_1() {
		Visitante visitante = new Visitante(1, "Luke Skywalker", "AVENTURA", 100, 8);
		assertEquals("AVENTURA", visitante.getPreferencia());
		assertEquals("Luke Skywalker", visitante.getNombre());
		assertEquals(100, visitante.getPresupuesto(),0.0001);
		assertEquals(8, visitante.getTiempoDisponibleHs(),0.0001);
	}
	
	@Test
	public void constructor_2() {
		Visitante visitante = new Visitante(3, "Han Solo", "DEGUSTACION", 36, 8);
		assertEquals("DEGUSTACION", visitante.getPreferencia());
		assertEquals("Han Solo", visitante.getNombre());
		assertEquals(36, visitante.getPresupuesto(),0.0001);
		assertEquals(8, visitante.getTiempoDisponibleHs(),0.0001);
	}
/*
	@Test
	public void construccionDeVisitantePriemraLineaDelArchivo() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();
		ArrayList<Visitante> visitante = manejadorArchivos.getVisitantes();
		Visitante visitante1 = new Visitante("Luke Skywalker", TipoDeAtraccion.AVENTURA, 100, 8);
		assertEquals(visitante1.getNombre(), visitante.get(0).getNombre());
		assertEquals(visitante1.getPreferencia(), visitante.get(0).getPreferencia());
		assertEquals(visitante1.getPresupuesto(), visitante.get(0).getPresupuesto(), 0.0001);
		assertEquals(visitante1.getTiempoDisponibleHs(), visitante.get(0).getTiempoDisponibleHs(), 0.0001);
	}
	
	@Test
	public void construccionDeVisitanteUltimaLineaDelArchivo() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();
		ArrayList<Visitante> visitante = manejadorArchivos.getVisitantes();
		Visitante visitante1 = new Visitante("Chewbacca", TipoDeAtraccion.PAISAJE, 120, 2);
		assertEquals(visitante1.getNombre(), visitante.get(3).getNombre());
		assertEquals(visitante1.getPreferencia(), visitante.get(3).getPreferencia());
		assertEquals(visitante1.getPresupuesto(), visitante.get(3).getPresupuesto(), 0.0001);
		assertEquals(visitante1.getTiempoDisponibleHs(), visitante.get(3).getTiempoDisponibleHs(), 0.0001);
	}*/
	
}
