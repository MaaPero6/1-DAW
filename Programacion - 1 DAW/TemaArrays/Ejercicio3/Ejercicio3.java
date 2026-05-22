package Ejercicio3;
import java.util.*;

public class Ejercicio3 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int numeros[] = {4, -3, 7, 0, -2, 8};
		int positivos = 0;
		
		for(int i=0; i<numeros.length; i++) {
			if(numeros[i] > 0) {
				positivos++;
			}
		}
		System.out.println("Hay " + positivos + " numeros positivos.");
	}
}