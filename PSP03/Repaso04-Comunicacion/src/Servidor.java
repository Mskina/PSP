
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Simulo una conversación. El cliente escribe un número y el servidor debe
 * devolver el doble. Ambos escriben por teclado.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        ServerSocket socket = new ServerSocket(60000);
        Socket servidor = socket.accept();

        ObjectOutputStream flujoSalida = new ObjectOutputStream(servidor.getOutputStream());
        ObjectInputStream flujoEntrada = new ObjectInputStream(servidor.getInputStream());

        String respuesta = "";
        while (true) {
            System.out.println("La pregunta es: " + flujoEntrada.readUTF());

            Scanner scan = new Scanner(System.in);
            System.out.println("Escribe tu respuesta");
            respuesta = scan.nextLine();
            flujoSalida.writeUTF(respuesta);
            flujoSalida.flush();

        }
    }
}
