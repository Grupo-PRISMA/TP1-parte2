package promociones;

import java.util.ArrayList;

import atraccion.Atraccion;
import atraccion.TipoDeAtraccion;

public class PromocionAxB extends Promocion {
	private Atraccion atraccionGratis;

	public PromocionAxB(TipoDeAtraccion tipo, Atraccion atraccionGratis, ArrayList<Atraccion> atracciones) {
		super(tipo, atracciones);
		this.atraccionGratis = atraccionGratis;
	}

	public double getDescuento() {
		return 0;
	}

	public double getDuracionTotal() {
		return super.getDuracionTotal() + this.atraccionGratis.getDuracion();
	}

	@Override
	public String toString() {
		return "[" + atracciones.get(0).getNombre() + ", " + atracciones.get(1).getNombre() + "]" + "\n-Duración: "
				+ this.getDuracionTotal() + " horas" + "\n-Precio: $" + super.getCostoTotal() + "\n-Atracción Gratis: "
				+ this.atraccionGratis.getNombre();

	}

	@Override
	public boolean hayCupo() {
		return super.hayCupo() && this.atraccionGratis.hayCupo();
	}

	public Atraccion getAtraccionGratis() {
		return this.atraccionGratis;
	}

	public String getNombreAtraccionGratis() {
		return this.atraccionGratis.getNombre();
	}
}