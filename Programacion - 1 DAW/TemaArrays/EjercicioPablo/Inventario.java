package EjercicioPablo;
import java.util.Arrays;

public class Inventario {
	private Producto productos[];
	private int contProductos;
	private final int MAX = 10;
	
	public Inventario() {
		productos = new Producto[MAX];
		contProductos = 0;
	}
	
	public void agregarProducto(Producto p) {
		if(contProductos < MAX) {
			productos[contProductos] = p;
			contProductos++;
			System.out.println("Producto añadido con éxito.");
		} else {
			System.out.println("El inventario esta lleno.");
		}
	}
	
	public void listarProductos() {
	    if (contProductos == 0) {
	        System.out.println("El inventario está vacío.");
	        return;
	    }
	    
	    for (int i = 0; i < productos.length; i++) {
	        if(productos[i] != null) {
	            System.out.println("Producto nº" + (i + 1) + ":\n" + productos[i]);
	            System.out.println("-------------------------");
	        }
	    }
	}
	
	public void ordenarPorPrecio() {
	    if (contProductos == 0) {
	        System.out.println("No hay productos para ordenar.");
	        return;
	    }
	    
	    Arrays.sort(productos, 0, contProductos); 
	    //Es una mejor forma de usar el Arrays.sort, ya qu ele indicamos el rango que queremos que ordene, asi si el inventario no esta lleno, nos evitamos que salte una excepcion por llegar a una posicion nula

	    System.out.println("Los productos ordenados por precio (de menor a mayor) son: ");
	    listarProductos(); 
	}
	
	public void productoMasCaro() {
		if(contProductos == 0) {
			System.out.println("No hay productos en el inventario.");
			return;
		}
		
		Producto prodCaro = productos[0];
		for(int i = 1; i<productos.length; i++) {
			if(productos[i] != null) {
				if(productos[i].getPrecio() > prodCaro.getPrecio()) {
					prodCaro = productos[i];
				}
			}
		}
		System.out.println("El producto mas caro es: " + prodCaro);
	}
	
	public void venderProducto(String nombre, int cantidad) throws StockInsuficienteException {
	    for (Producto i : productos) {
	        if (i != null) { 
	            if (i.getNombre().equalsIgnoreCase(nombre)) {
	                if (cantidad <= i.getStock()) {
	                    i.setStock(i.getStock() - cantidad); 
	                    System.out.println("Venta de " + nombre + " realizada.");
	                } else {
	                    throw new StockInsuficienteException("No hay suficiente stock de " + nombre);
	                }
	                return;
	            }
	        }
	    }
	    System.out.println("Error: El producto '" + nombre + "' no existe en el inventario.");
	}
}
