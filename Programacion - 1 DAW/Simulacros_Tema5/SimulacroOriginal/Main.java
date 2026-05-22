package SimulacroOriginal;

public class Main {

	public static void main(String[] args) {

		double[][] horas1 = {
				{4, 3},
				{4, 4},
				{5, 3},
				{4, 4},
				{3, 2}
		};

		double[][] horas2 = {
				{3, 3},
				{4, 3},
				{4, 4},
				{4, 3},
				{2, 2}
		};

		double[][] horas3 = {
				{5, 2},
				{5, 2},
				{4, 3},
				{4, 2},
				{3, 3}
		};

		double[][] horas4 = {
				{4, 4},
				{4, 4},
				{4, 4},
				{4, 4},
				{4, 3}
		};

		Empleado[] empleados = new Empleado[4];

		empleados[0] = new Programador("P01", "Ana", Departamento.INFORMATICA, horas1, 8);
		empleados[1] = new Programador("P02", "Luis", Departamento.INFORMATICA, horas2, 5);
		empleados[2] = new Administrativo("A01", "Marta", Departamento.ADMINISTRACION, horas3, 18);
		empleados[3] = new Administrativo("A02", "Carlos", Departamento.RRHH, horas4, 10);

		mostrarEmpleados(empleados);
		mostrarMayorProductividad(empleados);
		contarTipos(empleados);
		calcularMediaTurnos(empleados);
		mostrarEmpleadoMasHorasEnUnDia(empleados);
	}

	private static void mostrarEmpleados(Empleado[] empleados) {
		for (int i = 0; i < empleados.length; i++) {
			System.out.println("====================================");
			System.out.println(empleados[i]);
			empleados[i].mostrarHorario();
			System.out.println("Horas totales semana: " + empleados[i].calcularHorasTotalesSemana());
			System.out.println("Productividad: " + empleados[i].calcularProductividad());

			if (empleados[i].mereceReconocimiento()) {
				System.out.println("Merece reconocimiento: SI");
			} else {
				System.out.println("Merece reconocimiento: NO");
			}
		}
	}

	private static void mostrarMayorProductividad(Empleado[] empleados) {
		Empleado mejor = empleados[0];

		for (int i = 1; i < empleados.length; i++) {
			if (empleados[i].calcularProductividad() > mejor.calcularProductividad()) {
				mejor = empleados[i];
			}
		}

		System.out.println("====================================");
		System.out.println("Empleado con mayor productividad:");
		System.out.println(mejor);
		System.out.println("Productividad: " + mejor.calcularProductividad());
	}

	private static void contarTipos(Empleado[] empleados) {
		int numProgramadores = 0;
		int numAdministrativos = 0;

		for (int i = 0; i < empleados.length; i++) {
			if (empleados[i] instanceof Programador) {
				numProgramadores++;
			}
			if (empleados[i] instanceof Administrativo) {
				numAdministrativos++;
			}
		}

		System.out.println("====================================");
		System.out.println("Número de programadores: " + numProgramadores);
		System.out.println("Número de administrativos: " + numAdministrativos);
	}

	private static void calcularMediaTurnos(Empleado[] empleados) {
		double sumaManana = 0;
		double sumaTarde = 0;
		int totalDias = 0;

		for (int i = 0; i < empleados.length; i++) {
			double[][] horas = empleados[i].getHorasTrabajadas();

			for (int fila = 0; fila < horas.length; fila++) {
				sumaManana += horas[fila][0];
				sumaTarde += horas[fila][1];
				totalDias++;
			}
		}

		System.out.println("====================================");
		System.out.println("Media turno mañana: " + (sumaManana / totalDias));
		System.out.println("Media turno tarde: " + (sumaTarde / totalDias));
	}

	private static void mostrarEmpleadoMasHorasEnUnDia(Empleado[] empleados) {
		Empleado empleadoMax = empleados[0];
		int diaMax = 0;
		double horasMax = empleados[0].calcularHorasDia(0);

		for (int i = 0; i < empleados.length; i++) {
			for (int dia = 0; dia < 5; dia++) {
				if (empleados[i].calcularHorasDia(dia) > horasMax) {
					horasMax = empleados[i].calcularHorasDia(dia);
					empleadoMax = empleados[i];
					diaMax = dia;
				}
			}
		}

		String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

		System.out.println("====================================");
		System.out.println("Empleado que más horas ha trabajado en un solo día:");
		System.out.println(empleadoMax);
		System.out.println("Día: " + dias[diaMax]);
		System.out.println("Horas trabajadas ese día: " + horasMax);
	}
}