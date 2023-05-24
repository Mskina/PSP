
import java.net.ServerSocket;
import java.net.Socket;

/**
 * El programa creará un stream socket y aguardará conexiones. Cuando llegue una
 * conexión, leerá los mensajes recibidos, comprobando que se trate de una
 * pregunta (deberá contener en primera y última posición los caracteres ASCII
 * "¿" y "?", respectivamente). Cuando esto ocurra, contestará con un mensaje.
 *
 * El contenido del mensaje dependerá de la frase recibida.
 *
 * Si la frase es "¿Cómo te llamas?", responderá con la cadena "Me llamo
 * Servidor del Ejercicio 1".
 *
 * Si la frase es "¿Cuántas líneas de código tienes?", responderá con el número
 * de líneas de código que tenga.
 *
 * Si la frase es cualquier otra cosa, responderá "No he entendido la pregunta".
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println("-- Servidor maestro iniciado --");
        int puerto = 60000;
        ServerSocket servidor = new ServerSocket(puerto);

        while (true) {
            Socket socket = servidor.accept();
            Hilo hilo = new Hilo(socket);
            hilo.start();
        }
    }
}
