package EjerciciosAlumnos;

public class Alumno implements Comparable<Alumno>{
	private String nombre;
	private double nota;
	
	public Alumno(String nombre, double nota) {
		this.nombre = nombre;
		this.nota = nota;
	}
	
	
	public String getNombres() {
		return this.nombre;
	}
	
	public void setNotas(double nota) {
		this.nota = nota;
	}
	
	public double getNotas() {
		return this.nota;
	}
	
	public String toString() {
		return "Nombre del alumno: " + this.nombre + "\nNota del alumno: " + this.nota;
	}
	
	@Override
	public int compareTo(Alumno a) {
		if (this.nota < a.getNotas()) {
	        return -1; 
	    } else if (this.nota > a.getNotas()) {
	        return 1;  
	    } else {
	        return 0;  
	    }
	}
}
