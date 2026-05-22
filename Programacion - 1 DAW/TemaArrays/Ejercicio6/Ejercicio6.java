package Ejercicio6;
import java.util.*;

public class Ejercicio6 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int numeros[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 116, 17};
		
		int pares = 0;
		int impares = 0;
		for(int i = 0; i<numeros.length; i++) {
			if(numeros[i] % 2 == 0) {
				pares++;
			} else {
				impares++;
			}
		}
		System.out.println("Hay " + pares + " pares, y " + impares + " impares.");
	}
}