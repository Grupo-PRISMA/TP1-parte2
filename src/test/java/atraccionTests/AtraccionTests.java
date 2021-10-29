package atraccionTests;

import static org.junit.Assert.*;

import org.junit.Test;

import atraccion.Atraccion;

public class AtraccionTests {

	@Test
	public void crearElconstructorDeAtracciones() {
		Atraccion atraccion = new Atraccion(1, "Hoth", "AVENTURA", 10, 2, 6);
		assertEquals("AVENTURA", atraccion.getTipo());
		assertEquals("Hoth", atraccion.getNombre());
	}

	@Test
	public void quitarCupos() {
		Atraccion atraccion = new Atraccion(1, "Hoth", "AVENTURA", 10, 2, 6);
		assertTrue(atraccion.hayCupo());
		for (int i = 0; i < 6; i++) {
			atraccion.bajarCupo();
		}
		assertFalse(atraccion.hayCupo());
	}

}
