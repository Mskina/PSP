
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Realiza un programa servidor que escuche en el puerto 12345. Cada vez que se
 * conecte un cliente, se creará un nuevo hilo para atenderlo. Se mostrará en la
 * consola del servidor la dirección IP y el puerto remoto del cliente que se
 * conecta. Se deberá notificar también cuando un cliente se desconecte.
 * En el hilo que atiende al cliente, se reciben cadenas de caracteres que,
 * mientras sean distintas de "*", se devolverán al cliente transformadas
 * en mayúsculas.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("-- Servidor iniciado --");
        
        while (true) {
            Socket cliente = servidor.accept();
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();
        }
    }
}
