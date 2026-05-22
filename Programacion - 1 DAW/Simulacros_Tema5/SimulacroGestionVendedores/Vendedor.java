package SimulacroGestionVendedores;

public abstract class Vendedor implements Promocionable{ //Creamos la clase abstracta Vendedor, que implementa la interfaz Promocionable
	// --- Atributos de la clase Abstacta ---
	private String id;
	private String nombre;
	private Categoria categoria;
	private double ventasSemanales[] = new double [7];
	// --------------------------------------
	
	public abstract double calcularComision(); //Metodo abstracto
	
	// --- Constructor de la clase, que recibe como parametros los valores de los atributos ---
	public Vendedor(String id, String nombre, Categoria categoria, double ventasSemanales[]) {
		this.id= id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.ventasSemanales = ventasSemanales;
	}
	// ----------------------------------------------------------------------------------------
	
	// --- Getters de todos los atribuos ---
	public String getId() { return this.id; }
	public String getNombre() { return this.nombre; }
	public Categoria getCategoria() { return this.categoria; }
	public double[] getVentasSemanales() { return this.ventasSemanales; }
	// --------------------------------------
	
	public double calcularTotalVentas() {
		double totalVentas = 0; //Creamos una variable inicializada a 0 en la que iremos sumando los valores del array ventasSemanales para calcular el total de una semana
		
		for(int i = 0; i<ventasSemanales.length; i++) { //Bucle for para recorrer el array ventasSemanales
			totalVentas += ventasSemanales[i]; //Vamos sumando a la variable totalVentas el valor de la posicion i del array
		}
		
		return totalVentas; //Cuando ya hayamos sumado todo y tengamos el valor final, retornamos ese valor
	}
	
	@Override
	public String toString() { //Sobreescribimos el metodo toString para que devuelva lo que queremos mostrar por pantalla
		return "Id del Vendedor: " + this.id + " || Nombre del Vendedor: " + this.nombre + " || Categoria del vendedor: " + this.categoria;
	}
}
