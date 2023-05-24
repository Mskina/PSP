
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
        ServerSocket socket = new ServerSocket(60000);

        while (true) {
            Socket cliente = socket.accept();
            Hilo hilo = new Hilo(cliente);
            hilo.start();
        }
    }
}
