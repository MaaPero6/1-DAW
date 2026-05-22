package EjercicioPablo;

import java.util.Scanner;

public class MainTienda {
    static Scanner teclado = new Scanner(System.in); 
    
    public static void main(String[] args) {
        Inventario miTienda = new Inventario(); 
        boolean b = false;
        String opc, nombre;
        double precio;
        int stock;

        do {
            System.out.print("¿Quieres introducir algo al inventario? (s/n): ");
            opc = teclado.nextLine();
            
            if(opc.equalsIgnoreCase("n")) {
                b = true;
            } else if(opc.equalsIgnoreCase("s")) {
                
                boolean c = false;
                do {
                    try {
                        System.out.print("Introduce el nombre del articulo que vas a añadir: ");
                        nombre = teclado.nextLine();
                        System.out.print("Introduce su precio: ");
                        precio = teclado.nextDouble();
                        teclado.nextLine(); 
                        System.out.print("Introduce de cuanto stock dispone: ");
                        stock = teclado.nextInt();
                        teclado.nextLine();
                        
                        Producto producto = new Producto(nombre, precio, stock);
                        miTienda.agregarProducto(producto); 
                        c = true;
                    } catch(ProductoInvalidoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                } while(!c);
                
            } else {
                System.out.println("Opción no válida.");
            }
        } while(!b);
        
        
        
    }

		
	
	public static void mostrarMenu() {
		System.out.println("------ MENU TIENDA ------");
		System.out.println("1. Añadir producto.");
		System.out.println("2. Listar productos.");
		System.out.println("3. Ordenar por precio.");
		System.out.println("4. Mostrar mas caro.");
		System.out.println("5. Vender producto.");
		System.out.println("6. Salir.");
		System.out.println("-------------------------");
		System.out.print("Elige una opcion: ");
	}
}
