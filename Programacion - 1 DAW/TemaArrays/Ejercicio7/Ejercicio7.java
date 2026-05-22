package Ejercicio7;
import java.util.*;

public class Ejercicio7 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int numeros[] = {1, 2, 3, 4, 5};
		int invertido[] = new int[numeros.length];
		
		for(int i = numeros.length-1; i>=0 ; i--) {
			invertido[numeros.length-i-1] = numeros[i];
		}
		System.out.println(Arrays.toString(invertido));
	}
}