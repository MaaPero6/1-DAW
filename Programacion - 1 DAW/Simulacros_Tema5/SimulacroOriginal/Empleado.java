package SimulacroOriginal;

public abstract class Empleado implements Reconocible {

	private String id;
	private String nombre;
	private Departamento departamento;
	private double[][] horasTrabajadas; // 5 x 2

	public Empleado(String id, String nombre, Departamento departamento, double[][] horasTrabajadas) {
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.horasTrabajadas = horasTrabajadas;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public double[][] getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public double calcularHorasTotalesSemana() {
		double suma = 0;

		for (int i = 0; i < horasTrabajadas.length; i++) {
			for (int j = 0; j < horasTrabajadas[i].length; j++) {
				suma += horasTrabajadas[i][j];
			}
		}

		return suma;
	}

	public double calcularHorasDia(int dia) {
		double suma = 0;

		for (int j = 0; j < horasTrabajadas[dia].length; j++) {
			suma += horasTrabajadas[dia][j];
		}

		return suma;
	}

	public void mostrarHorario() {
		String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

		System.out.println("Horario de " + nombre + ":");
		for (int i = 0; i < horasTrabajadas.length; i++) {
			System.out.println(dias[i] + " -> Mañana: " + horasTrabajadas[i][0] 
					+ " | Tarde: " + horasTrabajadas[i][1]);
		}
	}

	public abstract double calcularProductividad();

	@Override
	public String toString() {
		return "ID: " + id + ", Nombre: " + nombre + ", Departamento: " + departamento;
	}
}