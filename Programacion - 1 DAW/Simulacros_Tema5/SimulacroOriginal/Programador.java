package SimulacroOriginal;

public class Programador extends Empleado {

	private int incidenciasResueltas;

	public Programador(String id, String nombre, Departamento departamento, double[][] horasTrabajadas, int incidenciasResueltas) {
		super(id, nombre, departamento, horasTrabajadas);
		this.incidenciasResueltas = incidenciasResueltas;
	}

	public int getIncidenciasResueltas() {
		return incidenciasResueltas;
	}

	@Override
	public double calcularProductividad() {
		return calcularHorasTotalesSemana() + incidenciasResueltas * 2;
	}

	@Override
	public boolean mereceReconocimiento() {
		return calcularProductividad() >= 45;
	}

	@Override
	public String toString() {
		return super.toString() + ", Tipo: Programador, Incidencias resueltas: " + incidenciasResueltas;
	}
}