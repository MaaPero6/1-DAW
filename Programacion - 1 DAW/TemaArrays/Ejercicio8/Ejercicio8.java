package Ejercicio8;
import java.util.*;

public class Ejercicio8 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int numeros[] = {1, 2, 3, 4, 5};
		int numerosClonado[] = new int[numeros.length];
		
		for(int i = 0; i<numeros.length ; i++) {
			numerosClonado[i] = numeros[i];
		}
		System.out.println("Array original: " + Arrays.toString(numeros));
		System.out.println("Array clonado: " + Arrays.toString(numerosClonado));
	}
}