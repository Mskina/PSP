
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * El programa recogerá de teclado las preguntas y se las enviará al servidor
 * para que las conteste. A continuación, leerá la respuesta del servidor y la
 * mostrará por pantalla. El cliente finalizará cuando el usuario introduzca la
 * cadena "FIN".
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    private static final String RESPUESTA_DEFAULT = "No he entendido la pregunta";

    private static final String FIN = "FIN";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Bienvenido a AKINATOR. Tú preguntas, yo respondo.");
        System.out.println("Para finalizar, escribe FIN.\n");

        String host = "localhost";
        int puerto = 60000;

        try (
                Socket socket = new Socket(host, puerto); // Socket
                 ObjectOutputStream flujoSalida = new ObjectOutputStream(socket.getOutputStream()); // Flujo de salida
                 ObjectInputStream flujoEntrada = new ObjectInputStream(socket.getInputStream()); // Flujo de entrada
                 Scanner scan = new Scanner(System.in); // Entrada por teclado
                ) {

            System.out.print("Escribe tu pregunta: ");
            String enviado = scan.nextLine();
            String recibido = "";

            while (!enviado.equals(FIN)) {

                flujoSalida.writeUTF(enviado);
                flujoSalida.flush();

                recibido = flujoEntrada.readUTF();
                System.out.println(recibido);
                if (recibido.equals(RESPUESTA_DEFAULT)) {
                    System.out.println("\tRecuerda emplear los interrogantes de apertura (¿) y cierre (?) ;)");
                }

                System.out.print("Escribe tu pregunta: ");
                enviado = scan.nextLine();
            }
            flujoSalida.writeUTF(enviado);
            flujoSalida.flush();

        } catch (Exception e) {
            System.out.println("Ha ocurrido una excepción en este cliente. Sentimos las molestias.");
            e.printStackTrace();
        }

    }
}
