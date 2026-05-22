package SimulacroLigaPokemon;

public class EntrenadorCriador extends Entrenador{
	private int huevosEclosionados;
	
	public EntrenadorCriador(String id, String nombre, Rango rango, int registroVictorias[][], int huevosEclosionados) {
		super(id, nombre, rango, registroVictorias);
		this.huevosEclosionados = huevosEclosionados;
	}
	
	@Override
	public double calcularPuntuacion() {
		double puntuacion = (calcularVictoriasSemanales() * 1.0) + (huevosEclosionados * 5);
		return puntuacion;
	}
	
	@Override
	public boolean esAptoParaLiga() {
		double puntos = calcularPuntuacion();
		if(puntos >= 80) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + " || Huevos eclosionados: " + this.huevosEclosionados;
	}
	
}
