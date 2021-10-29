package promocionesTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import atraccion.Atraccion;
import promociones.PromocionAbsoluta;

public class PromocionAbsolutaTest {

	@Test
	public void constructor() {
		Atraccion a1 = new Atraccion(3, "Coruscant", "DEGUSTACION", 3, 6.5, 150);
		Atraccion a2 = new Atraccion(6, "Geonosis", "DEGUSTACION", 35, 1, 30);
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(a1);
		atracciones.add(a2);
		PromocionAbsoluta promocionAbsoluta = new PromocionAbsoluta(1, "ABSOLUTA", 5, atracciones);
		assertEquals("ABSOLUTA", promocionAbsoluta.getTipo());

	}

	@Test
	public void verificarCostoTotal() {
		Atraccion a1 = new Atraccion(3, "Coruscant", "DEGUSTACION", 3, 6.5, 150);
		Atraccion a2 = new Atraccion(6, "Geonosis", "DEGUSTACION", 35, 1, 30);
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(a1);
		atracciones.add(a2);
		PromocionAbsoluta promocionAbsoluta = new PromocionAbsoluta(1, "DEGUSTACION", 3, atracciones);
		double costoTotalSinDescuento = 0;
		for (Atraccion atraccion : atracciones) {
			costoTotalSinDescuento += atraccion.getCosto();
		}
		double constoTotal = costoTotalSinDescuento - promocionAbsoluta.getDescuento();
		assertEquals(constoTotal, promocionAbsoluta.getCostoTotal(), 0.0001);
	}

	@Test
	public void descuentoEs3() {
		Atraccion a1 = new Atraccion(3, "Coruscant", "DEGUSTACION", 3, 6.5, 150);
		Atraccion a2 = new Atraccion(6, "Geonosis", "DEGUSTACION", 35, 1, 30);
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(a1);
		atracciones.add(a2);
		PromocionAbsoluta promocionAbsoluta = new PromocionAbsoluta(1, "ABSOLUTA", 3, atracciones);
		assertEquals(3, promocionAbsoluta.getDescuento(), 0.0001);
	}

	@Test
	public void descuentoEs5() {
		Atraccion a1 = new Atraccion(3, "Coruscant", "DEGUSTACION", 3, 6.5, 150);
		Atraccion a2 = new Atraccion(6, "Geonosis", "DEGUSTACION", 35, 1, 30);
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(a1);
		atracciones.add(a2);
		PromocionAbsoluta promocionAbsoluta = new PromocionAbsoluta(1, "ABSOLUTA", 5, atracciones);
		assertEquals(5, promocionAbsoluta.getDescuento(), 0.0001);
	}

}
