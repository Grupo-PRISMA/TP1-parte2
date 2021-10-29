package visitanteTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import visitante.Visitante;

public class VisitanteTests {

	@Test
	public void constructor_1() {
		Visitante visitante = new Visitante(1, "Luke Skywalker", "AVENTURA", 100, 8);
		assertEquals(1, visitante.getId());
		assertEquals("AVENTURA", visitante.getPreferencia());
		assertEquals("Luke Skywalker", visitante.getNombre());
		assertEquals(100, visitante.getPresupuesto(), 0.0001);
		assertEquals(8, visitante.getTiempoDisponibleHs(), 0.0001);
	}

	@Test
	public void constructor_2() {
		Visitante visitante = new Visitante(3, "Han Solo", "DEGUSTACION", 36, 8);
		assertEquals(3, visitante.getId());
		assertEquals("DEGUSTACION", visitante.getPreferencia());
		assertEquals("Han Solo", visitante.getNombre());
		assertEquals(36, visitante.getPresupuesto(), 0.0001);
		assertEquals(8, visitante.getTiempoDisponibleHs(), 0.0001);
	}

	@Test
	public void constructor_3() {
		Visitante visitante = new Visitante(4, "Chewbacca", "PAISAJE", 120, 2);
		assertEquals(4, visitante.getId());
		assertEquals("PAISAJE", visitante.getPreferencia());
		assertEquals("Chewbacca", visitante.getNombre());
		assertEquals(120, visitante.getPresupuesto(), 0.0001);
		assertEquals(2, visitante.getTiempoDisponibleHs(), 0.0001);
	}

}
