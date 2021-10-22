package plataformaWeb;

import java.util.ArrayList;

import atraccion.Atraccion;
import manejadorDeArchivos.EscrituraSalidaDeArchivos;
import manejadorDeArchivos.LecturaDeArchivos;
import promociones.Promocion;
import sugerencia.Sugerencia;
import visitante.Visitante;

public class PlataformaWeb {
	private ArrayList<Atraccion> atracciones;
	private ArrayList<Visitante> visitantes;
	private ArrayList<Promocion> promociones;

	public PlataformaWeb() {
		LecturaDeArchivos manejadorArchivos = new LecturaDeArchivos();

		this.atracciones = manejadorArchivos.getAtracciones();
		this.visitantes = manejadorArchivos.getVisitantes();
		this.promociones = manejadorArchivos.getPromociones();
	}

	private boolean validaRequisitos(Visitante visitante, boolean cupo, double costo, double duracion) {
		return cupo && visitante.getPresupuesto() >= costo && visitante.getTiempoDisponibleHs() >= duracion;
	}

	private boolean validaRequisitosPromocionPreferencia(Visitante visitante, Promocion promocion) {
		return visitante.getPreferencia() == promocion.getTipo() && this.validaRequisitos(visitante,
				promocion.hayCupo(), promocion.getCostoTotal(), promocion.getDuracionTotal());
	}

	private boolean validaRequisitosAtraccionPreferencia(Visitante visitante, Atraccion atraccion) {
		return atraccion.getTipo() == visitante.getPreferencia()
				&& this.validaRequisitos(visitante, atraccion.hayCupo(), atraccion.getCosto(), atraccion.getDuracion());
	}

	private boolean validaRequisitosPromocion(Visitante visitante, Promocion promocion) {
		return promocion.getTipo() != visitante.getPreferencia() && this.validaRequisitos(visitante,
				promocion.hayCupo(), promocion.getCostoTotal(), promocion.getDuracionTotal());
	}

	private boolean validaRequisitosAtraccion(Visitante visitante, Atraccion atraccion) {
		return atraccion.getTipo() != visitante.getPreferencia()
				&& this.validaRequisitos(visitante, atraccion.hayCupo(), atraccion.getCosto(), atraccion.getDuracion());
	}

	public void sugerir() {
		for (Visitante visitante : this.visitantes) {
			System.out.println("-".repeat(100));
			System.out.println("\n    Bienvenido/a a la Guerra de las Galaxias");
			System.out.println("-".repeat(100));
			System.out.println("\n");
			System.out.println("Nombre de visitante: " + visitante.getNombre().toUpperCase());

			ArrayList<Sugerencia> itinerario = this.crearSugerencias(visitante);
			this.mostrarItinerario(visitante, itinerario);
			this.guardarEnArchivoDeSalida(visitante, itinerario);
			System.out.println("-".repeat(100));
			System.out.println("");
		}
	}

	public void guardarEnArchivoDeSalida(Visitante visitante, ArrayList<Sugerencia> itinerario) {
		EscrituraSalidaDeArchivos.salidaItinerario(visitante.getNombre() + ".txt",
				this.datosItinerario(visitante, itinerario));
	}

	private ArrayList<Sugerencia> crearSugerencias(Visitante visitante) {
		ArrayList<Sugerencia> sugerenciasAceptadas = new ArrayList<Sugerencia>();

		sugerenciasAceptadas = this.crearSugerenciasConPreferencia(visitante, sugerenciasAceptadas);
		sugerenciasAceptadas = this.crearSugerenciasSinPreferencia(visitante, sugerenciasAceptadas);

		return sugerenciasAceptadas;
	}

	private ArrayList<Sugerencia> crearSugerenciasConPreferencia(Visitante visitante,
			ArrayList<Sugerencia> sugerencias) {
		sugerencias = this.crearSugerenciasPromocionesConPreferencias(visitante, sugerencias);
		sugerencias = this.crearSugerenciasAtraccionesConPreferencias(visitante, sugerencias);

		return sugerencias;
	}

	private ArrayList<Sugerencia> crearSugerenciasPromocionesConPreferencias(Visitante visitante,
			ArrayList<Sugerencia> sugerencias) {
		for (Promocion promocion : this.promociones) {
			Sugerencia sugerencia = new Sugerencia(promocion);
			if (!sugerencia.estaEn(sugerencias) && this.validaRequisitosPromocionPreferencia(visitante, promocion)) {
				System.out.println("Promocion pack " + promocion.getTipo() + "\n-Atracciones incluidas: " + promocion);
				System.out.println("");
				if (visitante.decidirSugerencia(sugerencia)) {
					System.out.println("¡Aceptada!");
					sugerencias.add(sugerencia);
					promocion.bajarCupo();
				}
				System.out.println("-".repeat(100));
				System.out.println("");
			}

		}

		return sugerencias;
	}

	private ArrayList<Sugerencia> crearSugerenciasAtraccionesConPreferencias(Visitante visitante,
			ArrayList<Sugerencia> sugerencias) {
		for (Atraccion atraccion : this.atracciones) {
			Sugerencia sugerencia = new Sugerencia(atraccion);

			if (!sugerencia.estaEn(sugerencias) && this.validaRequisitosAtraccionPreferencia(visitante, atraccion)) {
				System.out
						.println("Atracción tipo " + atraccion.getTipo() + "\nNombre: [" + atraccion.getNombre() + "]");
				System.out.println(
						"-Precio: $" + atraccion.getCosto() + "\n-Duración: " + atraccion.getDuracion() + " horas");
				System.out.println("");
				if (visitante.decidirSugerencia(sugerencia)) {
					System.out.println("¡Aceptada!");
					sugerencias.add(sugerencia);
					atraccion.bajarCupo();
				}
				System.out.println("-".repeat(100));
				System.out.println("");
			}
		}
		return sugerencias;
	}

	private ArrayList<Sugerencia> crearSugerenciasSinPreferencia(Visitante visitante,
			ArrayList<Sugerencia> sugerencias) {
		sugerencias = this.crearSugerenciasPromocionesSinPreferencias(visitante, sugerencias);
		sugerencias = this.crearSugerenciasAtraccionesSinPreferencias(visitante, sugerencias);

		return sugerencias;
	}

	private ArrayList<Sugerencia> crearSugerenciasPromocionesSinPreferencias(Visitante visitante,
			ArrayList<Sugerencia> sugerencias) {

		for (Promocion promocion : this.promociones) {
			Sugerencia sugerencia = new Sugerencia(promocion);

			if (!sugerencia.estaEn(sugerencias) && this.validaRequisitosPromocion(visitante, promocion)) {
				System.out.println("Promocion pack " + promocion.getTipo() + "\n-Atracciones incluidas: " + promocion);
				System.out.println("");
				if (visitante.decidirSugerencia(sugerencia)) {
					System.out.println("¡Aceptada!");
					sugerencias.add(sugerencia);
					promocion.bajarCupo();
				}
				System.out.println("-".repeat(100));
				System.out.println("");
			}
		}

		return sugerencias;
	}

	private ArrayList<Sugerencia> crearSugerenciasAtraccionesSinPreferencias(Visitante visitante,
			ArrayList<Sugerencia> sugerencias) {

		for (Atraccion atraccion : this.atracciones) {
			Sugerencia sugerencia = new Sugerencia(atraccion);

			if (!sugerencia.estaEn(sugerencias) && this.validaRequisitosAtraccion(visitante, atraccion)) {
				System.out
						.println("Atracción tipo " + atraccion.getTipo() + "\nNombre: [" + atraccion.getNombre() + "]");
				System.out.println(
						"-Precio: $" + atraccion.getCosto() + "\n-Duración: " + atraccion.getDuracion() + " horas");
				System.out.println("");
				if (visitante.decidirSugerencia(sugerencia)) {
					System.out.println("¡Aceptada!");
					sugerencias.add(sugerencia);
					atraccion.bajarCupo();
				}
				System.out.println("-".repeat(100));
				System.out.println("");
			}
		}

		return sugerencias;
	}

	public String datosItinerario(Visitante visitante, ArrayList<Sugerencia> itinerario) {
		double costoTotal = 0;
		double duracionTotal = 0;
		ArrayList<String> nombres = null;
		String cadenaNombres = "";

		String texto = "TU ITINERARIO\n" + "-".repeat(50);
		texto += "\n¡Hola " + visitante.getNombre() + "!\nBienvenida/o a La Guerra de las Galaxias";
		texto += "\nEsperamos que disfrutes de nuestras atracciones";
		texto += "\n" + "-".repeat(50);
		texto += "\nAtracciones de tu itinerario";
		texto += "\n" + "-".repeat(50);

		for (Sugerencia sugerencia : itinerario) {
			nombres = sugerencia.getNombresAtracciones();
			for (int i = 0; i < nombres.size(); i++) {
				String cadena = nombres.get(i);
				cadenaNombres += "*"+ cadena + "\n";
			}
			costoTotal += sugerencia.getCosto();
			duracionTotal += sugerencia.getDuracion();
		}

		texto += "\n" + cadenaNombres + "\n-Costo total= $ " + costoTotal + "\n-Duración total= " + duracionTotal
				+ " horas";

		texto += "\r\n" + "         _____\r\n" + "       .'/L|__`.\r\n" + "      / =[_]O|` \\\r\n"
				+ "      |\"+_____\":|\r\n" + "    __:='|____`-:__\r\n" + "   ||[] ||====| []||\r\n"
				+ "   ||[] | |=| | []||\r\n" + "   |:||_|=|U| |_||:|\r\n" + "   |:|||]_=_ =[_||:| \r\n"
				+ "   | |||] [_][]C|| |\r\n" + "   | ||-'\"\"\"\"\"`-|| |\r\n" + "   /|\\\\_\\_|_|_/_//|\\\r\n"
				+ "  |___|   /|\\   |___| \r\n" + "  `---'  |___|  `---' \r\n" + "         `---'\r\n";

		return texto;
	}

	public void mostrarItinerario(Visitante visitante, ArrayList<Sugerencia> itinerario) {
		System.out.println(this.datosItinerario(visitante, itinerario));
	}

	@Override
	public String toString() {
		return "Carga:\n" + "Visitantes:\n" + visitantes + "\n" + "Atracciones:\n" + atracciones + "\n"
				+ "Promociones:\n" + promociones + "\n";
	}
}
