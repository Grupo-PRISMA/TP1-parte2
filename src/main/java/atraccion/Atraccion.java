package atraccion;

public class Atraccion {
	private int id;
	private String nombre;
	private String tipo;
	private double costo;
	private double duracionHs;
	private int cupoPersonas;

	public Atraccion(int id, String nombre, String tipo, double costo, double horas, int cupoPersonas) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.duracionHs = horas;
		this.cupoPersonas = cupoPersonas;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getTipo() {
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

	public void bajarCupo() {
		this.cupoPersonas--;
	}
	
	public int getId() {
		return this.id;
	}
}
