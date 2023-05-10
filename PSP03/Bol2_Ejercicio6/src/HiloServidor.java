
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class HiloServidor extends Thread {

    private Socket socket;
    private BufferedReader fEntrada;
    private PrintWriter fSalida;
    private final String FIN = "*";

    public HiloServidor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String cadenaRecibida = "";

        try {
            fSalida = new PrintWriter(this.socket.getOutputStream(), true);
            fEntrada = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            while (!cadenaRecibida.trim().equals(FIN)) {
                cadenaRecibida = fEntrada.readLine(); // Recibo línea
                System.out.println(Thread.currentThread().getName() + " está recibiendo información de: " + this.socket.toString());
                fSalida.println(cadenaRecibida.trim().toUpperCase()); // Devuelvo en mayúsculas

            }
            System.out.println("Fin de la interacción entre " + Thread.currentThread().getName() + " y " + this.socket.toString());

            fSalida.close();
            fEntrada.close();
            this.socket.close();
        } catch (IOException e) {
            System.out.println("Excepción. Fin de la interacción entre " + Thread.currentThread().getName() + " y " + this.socket.toString());
        }
    }

}
