
import java.io.Serializable;


/**
 * Crea una clase Java llamada Numeros que defina 3 atributos,
 * uno de ellos entero y otros dos de tipo long.
 * Define un constructor con parámetros y otro sin parámetros.
 * Define los métodos get y set de los atributos.
 *
 * @author Iván Estévez Sabucedo
 */
public class Numeros implements Serializable {

    private int numero;
    private long cuadrado;
    private long cubo;

    public Numeros() {
    }

    public Numeros(int numero, long cuadrado, long cubo) {
        this.numero = numero;
        this.cuadrado = cuadrado;
        this.cubo = cubo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public long getCuadrado() {
        return cuadrado;
    }

    public void setCuadrado(long cuadrado) {
        this.cuadrado = cuadrado;
    }

    public long getCubo() {
        return cubo;
    }

    public void setCubo(long cubo) {
        this.cubo = cubo;
    }

    @Override
    public String toString() {
        return "Numeros{" + "numero=" + numero + ", cuadrado=" + cuadrado + ", cubo=" + cubo + '}';
    }
    
    

}
