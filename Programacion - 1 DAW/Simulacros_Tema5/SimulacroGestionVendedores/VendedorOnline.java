package SimulacroGestionVendedores;

public class VendedorOnline extends Vendedor{
private int cuponesUsados; //Atributo propio de la clase VendedorFisico
	
	// --- Constructor de la subclase, que recibe como parametros los valores de los atributos ---
	public VendedorOnline(String id, String nombre, Categoria categoria, double ventasSemanales[], int cuponesUsados) {
		super(id, nombre, categoria, ventasSemanales); // Pasamos los parametros correspondientes a la clase padre usando super
		this.cuponesUsados = cuponesUsados; 
	}
	// -------------------------------------------------------------------------------------------
	
	public double calcularComision() {
		double total = calcularTotalVentas();
		double totalConComision = total * 0.08 - (2 * this.cuponesUsados);
		return totalConComision;
	}
	
	@Override
	public boolean mereceAscenso() {
		double total = calcularComision();
		if(total > 150.0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
