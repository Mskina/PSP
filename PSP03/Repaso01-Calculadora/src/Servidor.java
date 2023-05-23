
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Inicio servidor");

        CalculatorThread hilo;

        int puerto = 60000;

        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Creado servidor");
        while (true) {

            Socket socket = servidor.accept();
            System.out.println("Cliente conectado: " + socket.toString());
            hilo = new CalculatorThread(socket);
            hilo.start();
        }
    }
}
