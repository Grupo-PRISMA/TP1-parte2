package promociones;

import java.util.ArrayList;

import atraccion.Atraccion;

public class PromocionAbsoluta extends Promocion {
	private double descuento;

	public PromocionAbsoluta(int id, String tipo, double descuento, ArrayList<Atraccion> atracciones) {
		super(id, tipo, atracciones);
		this.descuento = descuento;
	}

	public double getDescuento() {
		return this.descuento;
	}

	@Override
	public String toString() {
		return "[" + atracciones.get(0).getNombre() + ", " + atracciones.get(1).getNombre() + "]\n-Duración: "
				+ this.getDuracionTotal() + " horas" + "\n-Precio original: $" + super.getCostoSinDescuento()
				+ "\n-Precio con descuento: $" + this.getCostoTotal();
	}
}