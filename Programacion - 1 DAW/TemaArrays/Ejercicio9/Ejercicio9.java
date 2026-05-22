package Ejercicio9;
import java.util.*;

public class Ejercicio9 { 
	static Scanner teclado = new Scanner(System.in);  
	
	public static void main(String[] args) {
		int n1[] = {1, 2, 3, 4, 5};
		int n2[] = {1, 2, 3, 4, 5};
		
		System.out.println("Usando equals: ");
		if(n1.equals(n2)) {
			System.out.println("Los dos arrays son iguales.");
		} else {
			System.out.println("Los arrays son distintos.");
		}
		
		System.out.println("Usando Array.equals: ");
		if(Arrays.equals(n1,  n2)) {
			System.out.println("Los dos arrays son iguales.");
		} else {
			System.out.println("Los arrays son distintos.");
		}
	}
}
