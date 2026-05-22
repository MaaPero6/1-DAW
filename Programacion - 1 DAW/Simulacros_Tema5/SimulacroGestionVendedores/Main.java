package SimulacroGestionVendedores;
import java.util.*;

public class Main {
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		Vendedor vendedores[] = new Vendedor[3];
	
		double ventasLuis[] = {100.5, 200.0, 50.0, 0.0, 300.0, 450.0, 150.0};
		vendedores[0] = new VendedorFisico("01", "Luis", Categoria.JUNIOR, ventasLuis, 100);
	
		double ventasJuan[] = {90.5, 0.0, 55.5, 110.0, 200.0, 0.5, 155.0};
		vendedores[1] = new VendedorOnline("11", "Juan", Categoria.SENIOR, ventasJuan, 15);
	
		double ventasMiguel[] = {115.0, 235.5, 155.5, 100.5, 290.0, 575.5, 255.0};
		vendedores[2] = new VendedorFisico("02", "Miguel", Categoria.EXPERTO, ventasMiguel, 350);
		
		System.out.println("Datos de los empleados: ");
		for(int i = 0; i<vendedores.length; i++) {
			System.out.println(vendedores[i]);
		}
		
		System.out.println("\nTotal de ventas semanales de cada empleado: ");
		for(Vendedor i : vendedores) {
			String nombre = i.getNombre();
			double totalVentas = i.calcularTotalVentas();
			double totalComision = i.calcularComision();
			
			boolean ascenso = i.mereceAscenso();
			String a = "";
			if(ascenso) {
				a = "Si";
			} else {
				a = "No";
			}
			
			System.out.println("Empleado: " + nombre + " || Total de ventas semanal: " + totalVentas + " || Comision calculada: " + totalComision + "|| ¿Merece un ascenso? " + a);
		}
		
		System.out.print("\nTotal de ventas de toda la tienda: ");
		double total = 0;
		for(Vendedor i : vendedores) {
			total += i.calcularTotalVentas();
		}
		System.out.println(total);
		
		System.out.print("\nTotal de empleados online: ");
		int cont = 0;
		for(int i = 0; i<vendedores.length; i++) {
			if(vendedores[i] instanceof VendedorOnline) {
				cont += 1;
			}
		}
		System.out.println(cont);
	}
}
