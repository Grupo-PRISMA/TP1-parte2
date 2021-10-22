package visitante;

import java.util.Scanner;

import atraccion.TipoDeAtraccion;
import sugerencia.Sugerencia;

public class Visitante {
	private String nombre;
	private double presupuesto;
	private double tiempoDisponibleHs;
	private TipoDeAtraccion preferencia;

	public Visitante(String nombre, TipoDeAtraccion preferencia, double presupuesto, double tiempoDisponibleHs) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponibleHs = tiempoDisponibleHs;
		this.preferencia = preferencia;
		//this.itinerario = new ArrayList<Sugerencia>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoDeAtraccion getPreferencia() {
		return this.preferencia;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public double getTiempoDisponibleHs() {
		return this.tiempoDisponibleHs;
	}
	
	public boolean decidirSugerencia(Sugerencia sugerencia) {	
		char respuesta;
		Scanner entrada = new Scanner(System.in);	
		
		do {
			System.out.println("Acepta sugerencia? Ingrese S o N");
			String ingreso = entrada.nextLine();
			if (ingreso.length() > 0) {
				respuesta = Character.toUpperCase(ingreso.charAt(0));
			}else {
				respuesta = ' ';
			}
			
		} while (respuesta != 'S' && respuesta != 'N' && entrada.hasNextLine());

		if(respuesta == 'S') {
			this.presupuesto -= sugerencia.getCosto();
			this.tiempoDisponibleHs -= sugerencia.getDuracion();
		}
		
		return respuesta == 'S';

	}
	
	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Presupuesto = " + presupuesto + ", Tiempo Disponible Hs = "
				+ tiempoDisponibleHs + ", Preferencia = " + preferencia + "\n";
	}

}
