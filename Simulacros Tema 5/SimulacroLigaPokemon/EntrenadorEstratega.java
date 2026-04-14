package SimulacroLigaPokemon;

public class EntrenadorEstratega extends Entrenador{
	private int medallasConseguidas;
	
	public EntrenadorEstratega(String id, String nombre, Rango rango, int registroVictorias[][], int medallasConseguidas) {
		super(id, nombre, rango, registroVictorias);
		this.medallasConseguidas = medallasConseguidas;
	}
	
	@Override
	public double calcularPuntuacion() {
		double puntuacion = (calcularVictoriasSemanales() * 1.5) + (medallasConseguidas * 10);
		return puntuacion;
	}
	
	@Override
	public boolean esAptoParaLiga() {
		double puntos = calcularPuntuacion();
		if(puntos >= 100) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " || Medallas conseguidas: " + this.medallasConseguidas;
	}
}
