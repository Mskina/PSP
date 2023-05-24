
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Simulo una conversación. El cliente escribe un número y el servidor debe
 * devolver el doble. Ambos escriben por teclado.
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        String host = "localhost";
        int puerto = 60000;

        Socket cliente = new Socket(host, puerto);
        
//        PrintWriter flujIn= new PrintWriter(cliente.getOutputStream(), true);
//        BufferedReader flujOut = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());

        String pregunta = "";
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Escribe tu pregunta");
            pregunta = scan.nextLine();
            flujoSalida.writeUTF(pregunta);
            flujoSalida.flush();

            System.out.println("Respuesta: " + flujoEntrada.readUTF());
        }

    }
}
