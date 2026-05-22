package EjercicioPablo;

public class ProductoInvalidoException extends RuntimeException { 
    public ProductoInvalidoException() {
        super("Ha ocurrido un error creando el producto. Asegurate de que los datos han sido introducidos correctamente.");
    }
}

/*Uso el extends RunTimeException para evitar que salte error en el IDE. Hace que no sea mandatorio usar el try catch, ya que habia metodos en los que sabia con certeza que no iba a ocurrir 
 el caso de que saltara la excepcion, pero aun asi me pedia que usara el try catch. De todas formas, donde sea que haga falta lazar la excepcion, sirve de igual manera. Si se quiere incluso se puede quitar el
 "throws ProductoInvalidoException" de los metodos, aunque yo lo dejo por mejor legibilidad. En terminos tecnicos, diriamos que pasamos a convertirla a una excepcion no verificada(unchecked exception).*/