package promocionesTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import atraccion.Atraccion;


import promociones.PromocionPorcentual;

public class PromocionPorcentualTests {

	
	/*@Test
	public void verificarCostoTotal() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();
		ArrayList<Atraccion> atraccion = manejadorArchivos.getAtracciones();
		PromocionPorcentual promocionPorcentual = new PromocionPorcentual(TipoDeAtraccion.AVENTURA, 0.2, atraccion);
		double costoTotalSinDescuento = 0;
		for(Atraccion atraccion2 : atraccion) {
			costoTotalSinDescuento += atraccion2.getCosto();
		}
		double constoTotal = promocionPorcentual.getCostoTotal()-promocionPorcentual.getCostoTotal() * promocionPorcentual.getDescuento();
		assertEquals(constoTotal, promocionPorcentual.getCostoTotal(),0.0001);	
	}*/

}
