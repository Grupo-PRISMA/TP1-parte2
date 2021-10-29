package promocionesTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import atraccion.Atraccion;

import promociones.PromocionAxB;

public class PromocionAxBTests {

	@Test
	public void verificarPromoGratis() {
		Atraccion atraccionGratis = new Atraccion(7, "Naboo", "PAISAJE", 12, 3, 32);
		PromocionAxB promocionAxB = new PromocionAxB(0, null, atraccionGratis, null);
		assertEquals(atraccionGratis, promocionAxB.getAtraccionGratis());
	}

	@Test
	public void tiempoDeDuracionTotal() {
		Atraccion a1 = new Atraccion(5, "Kashyyk", "PAISAJE", 5, 2, 15);
		Atraccion a2 = new Atraccion(2, "Tatooine", "PAISAJE", 5, 2.5, 25);
		ArrayList<Atraccion> atracciones = new ArrayList<>();
		atracciones.add(a1);
		atracciones.add(a2);
		Atraccion atraccionGratis = new Atraccion(7, "Naboo", "PAISAJE", 12, 3, 32);
		PromocionAxB promocionAxB = new PromocionAxB(3, "PAISAJE", atraccionGratis, atracciones);
		double duracionPromoAxB = promocionAxB.getDuracionTotal();
		assertEquals(duracionPromoAxB, promocionAxB.getDuracionTotal(), 0.0001);

	}

}
