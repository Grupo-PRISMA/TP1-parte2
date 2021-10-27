package promociones;

import java.sql.SQLException;
import java.util.ArrayList;

import atraccion.Atraccion;
import dao.DAO;

public abstract class Promocion {

	protected int id;
	protected String tipo;
	protected ArrayList<Atraccion> atracciones = new ArrayList<>();

	public Promocion(int id, String tipo, ArrayList<Atraccion> atracciones) {
		this.id = id;
		this.tipo = tipo;
		this.atracciones = atracciones;
	}

	public String getTipo() {
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
			try {
				DAO.getAtraccionDAO().actualizar(atraccion);
			} catch (SQLException e) {
				System.out.println("Error actualizando cupo de promocion " + this.id + ", atraccion " + atraccion.getId());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
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
	
	public int getId() {
		return this.id;
	}
}