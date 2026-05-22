package Ejercicio2;
import java.util.*;

public class Ejercicio2 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		double numeros[] = {5.2, 1.7, 3.8, 6.7, 2.2, 9.0};
		double suma = 0;
		
		for(int i = 0; i<numeros.length; i++) {
			double n = numeros[i];
			suma += n;
		}
		System.out.printf("La suma de los numeros es: %.2f%n", suma);
		System.out.printf("La media de los numeros es: %.2f%n", (suma / 6.0));
	}
}
