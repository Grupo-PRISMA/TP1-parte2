package atraccion;

public class Atraccion implements Comparable<Atraccion> {
	private String nombre;
	private TipoDeAtraccion tipo;
	private double costo;
	private double duracionHs;
	private int cupoPersonas;

	public Atraccion(String nombre, TipoDeAtraccion tipo, double costo, double horas, int cupoPersonas) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.duracionHs = horas;
		this.cupoPersonas = cupoPersonas;
	}

	public String getNombre() {
		return this.nombre;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	public double getCosto() {
		return this.costo;
	}

	public double getDuracion() {
		return this.duracionHs;
	}

	public int getCupoPersonas() {
		return this.cupoPersonas;
	}

	public boolean hayCupo() {
		return this.cupoPersonas > 0;
	}

	
	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Tipo = " + tipo + ", Costo = " + costo + ", Duracion en Horas = " + duracionHs
				+ ", Cupo Personas = " + cupoPersonas + "\n";
	}

	@Override
	public int compareTo(Atraccion otraAtraccion) {
		int resultado = 0;

		if (this.getCosto() > otraAtraccion.getCosto()) {
			resultado = -1;
		} else if (this.getCosto() < otraAtraccion.getCosto()) {
			resultado = 1;
		} else {
			if (this.getDuracion() > otraAtraccion.getDuracion()) {
				resultado = -1;
			} else if (this.getDuracion() < otraAtraccion.getDuracion()) {
				resultado = 1;
			} else {
				resultado = 0;
			}
		}

		return resultado;
	}

	public void bajarCupo() {
		this.cupoPersonas--;
	}
}
