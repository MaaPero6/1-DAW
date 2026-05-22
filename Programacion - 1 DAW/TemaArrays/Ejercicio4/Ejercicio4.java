package Ejercicio4;
import java.util.*;

public class Ejercicio4 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int numeros[] = {4, 2, 3, 6, 1, 7, 9, 8, 0, 5};
		
		System.out.print("Introduce un numero: ");
		int n = teclado.nextInt();
		
		int cont = 0;
		for(int i = 0; i<numeros.length; i++) {
			if(n == numeros[i]) {
				System.out.println("Tu numero se encuentra en el array, y esta en la posicion " + (cont + 1));
			} else {
				cont++;
			}
		}
		
		if(cont == 10) {
			System.out.println("Tu numero no se encuentra dentro del array.");
		}
	}
}