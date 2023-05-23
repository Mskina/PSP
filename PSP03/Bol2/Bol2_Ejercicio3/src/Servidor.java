
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Crea un programa servidor que reciba un objeto Numeros. Debe calcular el
 * cuadrado y el cubo del atributo numero y debe enviar el objeto al cliente con
 * los cálculos realizados, el cuadrado y el cubo en sus atributos respectivos.
 * El cliente recibirá el objeto y visualizará el cuadrado y el cubo del número
 * introducido por teclado. El programa servidor finalizará cuando el número
 * recibido en el objeto Numeros sea menor o igual que 0.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("-- Iniciando servidor... --");

        int puerto = 60001;
        ServerSocket servidor = new ServerSocket(puerto);

        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept(); // Aceptamos la conexión cuando nos llege

        ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

        Numeros numeroRecibido = (Numeros) flujoEntrada.readObject();
        int num = numeroRecibido.getNumero();
        System.out.println("Recibido el número: " + num);

        while (num > 0) {
            // Calculo cuadrado y cubo
            numeroRecibido.setCuadrado((long) Math.pow(num, 2));
            numeroRecibido.setCubo((long) Math.pow(num, 3));

            flujoSalida.writeObject(numeroRecibido);
            System.out.println("Enviado el objeto con los datos recalculados :)");

            numeroRecibido = (Numeros) flujoEntrada.readObject();
            num = numeroRecibido.getNumero();
            System.out.println("Recibido el número: " + num);
        }
        
        cliente.close();
        servidor.close();
    }
}
