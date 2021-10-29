package promocionesTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import atraccion.Atraccion;
import promociones.PromocionPorcentual;

public class PromocionPorcentualTests {

	@Test
	public void constructor() {
		Atraccion a1 = new Atraccion(1, "Hoth", "AVENTURA", 10, 2, 5);
		Atraccion a2 = new Atraccion(4, "Estrella de la Muerte", "AVENTURA", 25, 3, 4);
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(a1);
		atracciones.add(a2);
		PromocionPorcentual promocionPorcentual = new PromocionPorcentual(1, "AVENTURA", 0.2, atracciones);
		assertEquals("AVENTURA", promocionPorcentual.getTipo());
	}

	@Test
	public void verificarCostoTotal() {
		Atraccion a1 = new Atraccion(1, "Hoth", "AVENTURA", 10, 2, 5);
		Atraccion a2 = new Atraccion(4, "Estrella de la Muerte", "AVENTURA", 25, 3, 4);
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(a1);
		atracciones.add(a2);
		PromocionPorcentual promocionPorcentual = new PromocionPorcentual(1, "AVENTURA", 0.2, atracciones);
		double costoTotal = promocionPorcentual.getCostoTotal()
				- promocionPorcentual.getCostoTotal() * promocionPorcentual.getDescuento();
		assertEquals(costoTotal, promocionPorcentual.getCostoTotal(), 0.0001);
	}

}
