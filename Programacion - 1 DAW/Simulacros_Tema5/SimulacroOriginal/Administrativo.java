package SimulacroOriginal;

public class Administrativo extends Empleado {

	private int documentosTramitados;

	public Administrativo(String id, String nombre, Departamento departamento, double[][] horasTrabajadas,int documentosTramitados) {
		super(id, nombre, departamento, horasTrabajadas);
		this.documentosTramitados = documentosTramitados;
	}

	public int getDocumentosTramitados() {
		return documentosTramitados;
	}

	@Override
	public double calcularProductividad() {
		return calcularHorasTotalesSemana() + documentosTramitados * 0.5;
	}

	@Override
	public boolean mereceReconocimiento() {
		return calcularProductividad() >= 40;
	}

	@Override
	public String toString() {
		return super.toString() + ", Tipo: Administrativo, Documentos tramitados: " + documentosTramitados;
	}
}