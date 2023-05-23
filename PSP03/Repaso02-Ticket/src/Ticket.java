
import java.io.Serializable;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Ticket implements Serializable {

    private static final String[] TIPO_ENTRADA = { "Normal", "Niños", "Carnet joven", "Pensionista" };
    private String nombre;
    private int tipo;
    private int precio;

    public Ticket(String nombre, int tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Ticket{" + "nombre=" + nombre + ", tipo=" + TIPO_ENTRADA[tipo-1] + ", precio=" + precio + "euro(s). }";
    }
    
    

}
