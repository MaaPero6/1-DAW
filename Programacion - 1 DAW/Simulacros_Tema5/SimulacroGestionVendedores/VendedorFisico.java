package SimulacroGestionVendedores;

public class VendedorFisico extends Vendedor{ //Creamos la clase VendedorFisico e indicamos que extiende(o hereda) de la clase abstracta Vendedor
	private double plusPresencialidad; //Atributo propio de la clase VendedorFisico
	
	// --- Constructor de la subclase, que recibe como parametros los valores de los atributos ---
	public VendedorFisico(String id, String nombre, Categoria categoria, double ventasSemanales[], double plusPresencialidad) {
		super(id, nombre, categoria, ventasSemanales); // Pasamos los parametros correspondientes a la clase padre usando super
		this.plusPresencialidad = plusPresencialidad; 
	}
	// -------------------------------------------------------------------------------------------
	
	@Override
	public double calcularComision() {
		double total = calcularTotalVentas();
		double totalConComision = total * 0.05 + this.plusPresencialidad;
		return totalConComision;
	}
	
	@Override
	public boolean mereceAscenso() {
		double total = calcularTotalVentas();
		if(total > 1200.0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " || Plus de presencialidad del empleado: " + this.plusPresencialidad;
	}
}
