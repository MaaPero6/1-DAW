package Ejercicio11;

import java.util.*;

public class Ejercicio11 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int numeros[] = {1, 2, 3, 4, 5};
		System.out.println("El array original es: " + Arrays.toString(numeros));
		multiplicarPorDos(numeros);
		System.out.println("El array multiplicado por dos es: " + Arrays.toString(numeros));
		
	}
	
	public static void multiplicarPorDos(int numeros[]) {
		for(int i = 0; i<numeros.length; i++) {
			numeros[i] = numeros[i] * 2;
		}
	}
}
