package EjercicioPablo;

public class Producto implements Comparable<Producto>{
	private String nombre;
	private double precio;
	private int stock;
	
	public Producto() {}
	
	public Producto(String nombre, double precio, int stock) throws ProductoInvalidoException {
		if(nombre.isEmpty()) {
			throw new ProductoInvalidoException();
		} else {
			this.nombre = nombre;
		}
		
		if(precio <= 0) {
			throw new ProductoInvalidoException();
		} else {
			this.precio = precio;
		}
		
		if(stock < 0) {
			throw new ProductoInvalidoException();
		} else {
			this.stock = stock;
		}
	}
	
	public void setNombre(String nombre) throws ProductoInvalidoException { 
		if(nombre.isEmpty()) {
			throw new ProductoInvalidoException();
		} else {
			this.nombre = nombre;
		}
	}
	
	public String getNombre() { return this.nombre; }
	
	public void setPrecio(double precio) throws ProductoInvalidoException {
		if(precio <= 0) {
			throw new ProductoInvalidoException();
		} else {
			this.precio = precio;
		}
	}
	
	public double getPrecio() { return this.precio; }
	
	public void setStock(int stock) throws ProductoInvalidoException {
		if(stock < 0) {
			throw new ProductoInvalidoException();
		} else {
			this.stock = stock;
		}
	}
	
	public int getStock() { return this.stock; }
	
	public String toString() { return "- Nombre del producto: " + this.nombre + "\n- Precio del producto: " + this.precio + "\n- Stock del producto: " + this.stock; }
	
	@Override
	public int compareTo(Producto p) {
		if (this.precio < p.getPrecio()) {
	        return -1; 
	    } else if (this.precio > p.getPrecio()) {
	        return 1;  
	    } else {
	        return 0;  
	    }
	}
}
