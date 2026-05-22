package EjerciciosAlumnos;
import java.util.*;

public class MainAlumno { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		// ------ Ejercicio 13 ------
		Alumno alumnos[] = new Alumno[3];
		alumnos[0] = new Alumno("Miguel", 6);
		alumnos[1] = new Alumno("Lucia", 9);
		alumnos[2] = new Alumno("Dani", 3);
		
		for(int i = 0; i<alumnos.length; i++) {
			System.out.println(alumnos[i] + "\n");
		}
		// -------------------------
		
		// ------ Ejercicio 14 ------
		String m = "";
		double n = 0;
		for (Alumno i : alumnos) {
			if(i.getNotas() > n) {
				n = i.getNotas();
				m = i.getNombres();
			}
        }
		System.out.println("El alumno con la nota mas alta es " + m + " con un " + n);
		// --------------------------
		
		// ------ Ejercicio 15 ------
		for (Alumno i : alumnos) {
			i.setNotas(i.getNotas() + 1);
        }
		
		System.out.println("\nTras modificar las notas y sumarles 1 a cada una: ");
		for(int i = 0; i<alumnos.length; i++) {
			System.out.println(alumnos[i] + "\n");
		}
		// --------------------------
		
		// ------ Ejercicio 16 ------
		Arrays.sort(alumnos);
		System.out.println("Los alumnos ordenados por notas (de menor a mayor) son: ");
		for(int i = 0; i<alumnos.length; i++) {
			System.out.println(alumnos[i] + "\n");
		}
		// -------------------------
	}
}

