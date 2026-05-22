package Ejercicio5;
import java.util.*;

public class Ejercicio5 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int numeros[] = {1, 2, 3, -10, 45, 131, 12, 5, 67, 102};
		int mayor = -100;
		
		for(int i = 0; i<numeros.length; i++) {
			if(numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		System.out.println("El mayor numero del array es: " + mayor);
	}
}