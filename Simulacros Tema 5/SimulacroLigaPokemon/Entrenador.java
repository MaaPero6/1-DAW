package SimulacroLigaPokemon;

public abstract class Entrenador implements Evaluable{
	private String id;
	private String nombre;
	private Rango rango;
	private int registroVictorias[][] = new int[5][2]; //Filas(0 a 4) dias de lunes a viernes, columna 0 combates individuales y columna 1 combates dobles
	
	public abstract double calcularPuntuacion();
	
	public Entrenador(String id, String nombre, Rango rango, int registroVictorias[][]) {
		this. id = id;
		this.nombre = nombre;
		this.rango = rango;
		this.registroVictorias = registroVictorias;
	}
	
	public String getId() { return this.id; }
	public String getNombre() { return this.nombre; }
	public Rango getRango() { return this.rango; }
	public int[][] getRegistroVictorias() { return this.registroVictorias; }
	
	public int calcularVictoriasSemanales() {
		int totalSemana = 0;
		for(int i = 0; i<registroVictorias.length; i++) {
			for(int j = 0; j<registroVictorias[0].length; j++) {
				totalSemana += registroVictorias[i][j];
			}
		}
		return totalSemana;
	}
	
	public int calcularVictoriasDia(int dia) {
		int totalDia = 0;
		for(int j = 0; j<registroVictorias[dia].length; j++) {
			totalDia += registroVictorias[dia][j];
		}
		return totalDia;
	}
	
	public void mostrarRegistroCombates() {
	    System.out.println("Registro de combates de la semana:");
	    for(int i = 0; i < registroVictorias.length; i++) {
	        System.out.println("Día " + (i + 1) + ": Individuales: " + registroVictorias[i][0] + " || Dobles: " + registroVictorias[i][1]);
	    }
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + " || Nombre: " + this.nombre + " || Rango: " + this.rango;
	}
}
