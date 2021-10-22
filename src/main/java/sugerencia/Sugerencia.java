package sugerencia;

import java.util.ArrayList;

import atraccion.Atraccion;
import promociones.Promocion;
import promociones.PromocionAxB;

public class Sugerencia {

	private ArrayList<String> nombresAtracciones;
	private double costo;
	private double duracion;

	public Sugerencia(Promocion promo) {
		this.nombresAtracciones = this.extraerNombre(promo.getAtracciones());
		this.costo = promo.getCostoTotal();
		this.duracion = promo.getDuracionTotal();
		if (promo.getClass().equals(PromocionAxB.class)) {
			this.nombresAtracciones.add(((PromocionAxB) promo).getNombreAtraccionGratis());
		}
	}

	public Sugerencia(Atraccion atraccion) {
		this.nombresAtracciones = new ArrayList<>();
		this.nombresAtracciones.add(atraccion.getNombre());
		this.costo = atraccion.getCosto();
		this.duracion = atraccion.getDuracion();
	}

	private ArrayList<String> extraerNombre(ArrayList<Atraccion> atracciones) {
		ArrayList<String> lista = new ArrayList<String>();

		for (Atraccion atraccion : atracciones) {
			lista.add(atraccion.getNombre());
		}

		return lista;
	}

	public ArrayList<String> getNombresAtracciones() {
		return this.nombresAtracciones;
	}

	public double getCosto() {
		return this.costo;
	}

	public double getDuracion() {
		return this.duracion;
	}

	public boolean estaEn(ArrayList<Sugerencia> sugerencias) {
		for (String nombre : this.nombresAtracciones) {
			for (Sugerencia sugerencia : sugerencias) {
				if (sugerencia.getNombresAtracciones().contains(nombre)) {
					return true;
				}
			}
		}

		return false;
	}
}
