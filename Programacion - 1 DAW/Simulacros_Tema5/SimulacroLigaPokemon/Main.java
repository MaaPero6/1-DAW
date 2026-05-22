package SimulacroLigaPokemon;
import java.util.Scanner;

public class Main {
	static Scanner teclado = new Scanner(System.in);
	static Entrenador entrenadores[] = new Entrenador[4];
	
	public static void main(String[] args) {
		int victoriasBrock[][] = { {3,1}, {2,0}, {4,2}, {1,1}, {5,3} };
		entrenadores[0] = new EntrenadorEstratega("01", "Brock", Rango.LIDER_GIMNASIO, victoriasBrock, 1);
		
		int victoriasRed[][] = { {5,7}, {3,4}, {5,3}, {6,7}, {9,6} };
		entrenadores[1] = new EntrenadorEstratega("02", "Red", Rango.CAMPEON, victoriasRed, 8);
		
		int victoriasBlanca[][] = { {3,1}, {2,0}, {4,2}, {1,1}, {5,3} };
		entrenadores[2] = new EntrenadorCriador("11", "Blanca", Rango.NOVATO, victoriasBlanca, 7);
		
		int victoriasLeaf[][] = { {4,2}, {3,1}, {5,3}, {2,3}, {4,4} };
		entrenadores[3] = new EntrenadorCriador("12", "Leaf", Rango.ALTO_MANDO, victoriasLeaf, 10);
		
		mostrarEntrenadores();
		contarTipos();
		calcularMediasCombates();
		mejorCombatienteIndividual();
		
	}
	
	public static void mostrarEntrenadores() {
		System.out.println("FICHAS DE LOS ENTRENADORES: ");
		for(int i = 0; i<entrenadores.length; i++) {
			System.out.println(entrenadores[i]);
			entrenadores[i].mostrarRegistroCombates();
			System.out.println("Victorias semanales: " + entrenadores[i].calcularVictoriasSemanales());
			System.out.println("Puntuacion del entrenador: " + entrenadores[i].calcularPuntuacion());
			if(entrenadores[i].esAptoParaLiga()) {
				System.out.println("Este entrenador es apto para liga");
			} else {
				System.out.println("Este entrenador no es apto para liga");
			}
			System.out.println();
		}
	}
	
	public static void contarTipos() {
		int contEs = 0;
		int contCri = 0;
		for(int i = 0; i<entrenadores.length; i++) {
			if(entrenadores[i] instanceof EntrenadorEstratega) {
				contEs += 1;
			} else if(entrenadores[i] instanceof EntrenadorCriador) {
				contCri += 1;
			}
		}
		System.out.println("\nTIPOS DE ENTRENADORES: ");
		System.out.println("Entrenadores estrategas: " + contEs);
		System.out.println("Entrenadores criadores: " + contCri);
	}
	
	public static void calcularMediasCombates() {
		double sumaIndividuales = 0;
		double sumaDobles = 0;
		
		for (int i = 0; i < entrenadores.length; i++) { //Recorremos a todos los entrenadores
		    for (int dia = 0; dia < 5; dia++) { //Para cada entrenador, recorremos sus 5 días
		        sumaIndividuales += entrenadores[i].getRegistroVictorias()[dia][0]; //Accedemos a la columna 0 (Individuales) de ese entrenador y ese día
		        sumaDobles += entrenadores[i].getRegistroVictorias()[dia][1];
		    }
		}
		double mediaIn = sumaIndividuales / (entrenadores.length * 5); //Calculamos la media de los individuales
		double mediaDob = sumaDobles / (entrenadores.length * 5); //Calculamos la media de los dobles
		System.out.println("\nMEDIAS GENERALES DE LOS COMBATES: ");
		System.out.println("Media general de combates individuales: " + mediaIn);
		System.out.println("Media general de combates dobles: " + mediaDob);
	}
	
	public static void mejorCombatienteIndividual() {
		int maxVictorias = -1;
		String nombreGanador = "";
		
		for (int i = 0; i < entrenadores.length; i++) { //Recorremos a todos los entrenadores
		    for (int dia = 0; dia < 5; dia++) { //Para cada entrenador, recorremos sus 5 días
		        if(entrenadores[i].calcularVictoriasDia(dia) > maxVictorias) {
		        	maxVictorias = entrenadores[i].calcularVictoriasDia(dia);
		        	nombreGanador = entrenadores[i].getNombre();
		        }
		    }
		}
		System.out.println("\nMEJOR DIA INDIVIDUAL: ");
		System.out.println("Nombre del entrenador: " + nombreGanador + " || Numero de victorias: " + maxVictorias);
	}
	
}
