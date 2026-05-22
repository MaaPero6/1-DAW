package Ejercicio10;

import java.util.*;

public class Ejercicio10 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int numeros[] = {1, 2, 3, 4, 5};
		int numerosClonados[] = numeros.clone();
		
		for(int i = numeros.length-1; i>=0 ; i--) {
			numeros[numeros.length-i-1] = numeros[i];
		}
		System.out.println(Arrays.toString(numeros));
		System.out.println(Arrays.toString(numerosClonados));
		
		System.out.println("\nEsto ocurre ya que al crear el clon, se crea un aray con los mismos valores del original pero se almacena en una posicion de memoria diferente, por lo que al modificar posteriormente" +
		"\nal original, esos cambios no afectan a la copia. Se podria decir que le sacas una 'captura de pantalla' al array, por lo que, lo que le hagas despues al original no se va a ver reflejado en el.");
		
	}
}
