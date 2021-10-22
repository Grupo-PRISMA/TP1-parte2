package promociones;

import java.util.ArrayList;

import atraccion.Atraccion;
import atraccion.TipoDeAtraccion;

public abstract class Promocion {
	public static String TIPO_ABSOLUTA = "absoluta";
	public static String TIPO_AxB = "AxB";
	public static String TIPO_PORCENTUAL = "porcentual";

	protected TipoDeAtraccion tipo;
	protected ArrayList<Atraccion> atracciones = new ArrayList<>();

	public Promocion(TipoDeAtraccion tipo, ArrayList<Atraccion> atracciones) {
		this.tipo = tipo;
		this.atracciones = atracciones;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return this.atracciones;
	}

	public double getCostoTotal() {
		double costoTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}

		return costoTotal - this.getDescuento();
	}

	public double getCostoSinDescuento() {
		double costoTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			costoTotal += atraccion.getCosto();
		}

		return costoTotal;
	}

	public double getDuracionTotal() {
		double duracionTotal = 0;

		for (Atraccion atraccion : this.atracciones) {
			duracionTotal += atraccion.getDuracion();
		}

		return duracionTotal;
	}

	public abstract double getDescuento();

	public boolean hayCupo() {
		boolean hay = true;

		for (Atraccion atraccion : this.atracciones) {
			hay &= atraccion.hayCupo();
		}

		return hay;
	}

	public void bajarCupo() {
		for (Atraccion atraccion : this.atracciones) {
			atraccion.bajarCupo();
		}
	}

	public ArrayList<String> nombreAtracciones() {
		ArrayList<String> nombres = new ArrayList<String>();

		for (Atraccion atraccion : this.atracciones) {
			nombres.add(atraccion.getNombre());
		}
		return nombres;
	}

	@Override
	public String toString() {
		String texto = this.nombreAtracciones().toString();

		return texto;
	}
}