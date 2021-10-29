package atraccionTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import atraccion.Atraccion;




public class AtraccionTests {

	@Test
	public void crearElconstructorDeAtracciones() {
		Atraccion atraccion = new Atraccion(1, "Hoth", "AVENTURA", 10, 2, 6);
		assertEquals("AVENTURA", atraccion.getTipo());
		assertEquals("Hoth", atraccion.getNombre());
	}

/*	@Test
	public void cantidadDeAtraccion8() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();
		ArrayList<Atraccion> atraccion = manejadorArchivos.getAtracciones();
		assertEquals(8, atraccion.size());
	}*/
	
	@Test
	public void quitarCupos() {
		Atraccion atraccion = new Atraccion(1, "Hoth", "AVENTURA", 10, 2, 6);
		assertTrue(atraccion.hayCupo());
		for (int i = 0; i < 6; i++) {
			atraccion.bajarCupo();
		}
		assertFalse(atraccion.hayCupo());

	}

	/*@Test
	public void atraccionMayorCosto() {
		Atraccion atraccion = new Atraccion(1, "Hoth", "AVENTURA", 10, 2, 6);
		Atraccion atraccion2 = new Atraccion(2, "Tatooine", "PAISAJE", 5, 2.5, 25);
		assertEquals(-1, atraccion.compareTo(atraccion2));
	}*/


}
