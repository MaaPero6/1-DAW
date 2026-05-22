package Ejercicio12;
import java.util.*;

public class Ejercicio12 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int numeros[] = {1, 2, 3, 4, 5};
		System.out.println("El array original es: " + Arrays.toString(numeros));
		
		System.out.print("El array multiplicado por dos es: [");
		multiplicarPorDos(numeros);
		System.out.println("]");
		
		System.out.println("Sin embargo, el aray original sigue siendo: " + Arrays.toString(numeros));
		
		System.out.println("\nCon el for clásico, la i es un índice que nos permite acceder a la dirección de memoria de cada celda del array y modificarla. Con el for-each, la i es una variable local que " + 
		"\nrecibe una copia del valor de cada celda; podemos leerla y operar con ella, pero no podemos volver atrás y cambiar el valor original en el array.");
	}
	
	public static void multiplicarPorDos(int numeros[]) {
		for(int i : numeros) {
			System.out.print(i*2);
			if(i<5) {
				System.out.print(", ");
			}
		}
	}
}
