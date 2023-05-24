
import java.io.Serializable;

/**
 * Clase empleada para almacenar nombre, cargo y salario. Únicamente cuenta con
 * los métodos necesarios para el correcto uso en este supuesto.
 *
 * @author Iván Estévez Sabucedo
 */
public class Cargo implements Serializable {

    private static final String[] TIPO_CARGO = {"Operario", "Comercial", "Técnico", "Especialista"};
    private String nombre;
    private int tipo;
    private int salario;

    public Cargo(String nombre, int tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "EMPLEADO: " + nombre + "\n"
                + "CARGO: " + TIPO_CARGO[tipo - 1] + "\n"
                + "SALARIO: " + salario + "€";
    }

}
