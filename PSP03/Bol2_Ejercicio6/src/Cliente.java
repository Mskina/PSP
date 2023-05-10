
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int puerto = 12345; // puerto remoto

        Socket cliente = new Socket(host, puerto);

        // Flujo de salida hacia el servidor
        PrintWriter flujoSalida = new PrintWriter(cliente.getOutputStream(), true);

        // Flujo de entrada desde el servidor
        BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        // Entrada desde teclado
        Scanner scan = new Scanner(System.in);

        System.out.print("Escribe algo: ");
        String cadena = scan.nextLine();
        String cadenaRecibida = "";

        while (!cadena.trim().equals("*")) {
            flujoSalida.println(cadena);

            cadenaRecibida = flujoEntrada.readLine();
            System.out.println("> Mensaje recibido: " + cadenaRecibida);

            System.out.print("Escribe algo: ");
            cadena = scan.nextLine();
        }
        flujoSalida.println(cadena); // Se le envía "*" para que finalice
        flujoSalida.close();
        flujoEntrada.close();
        scan.close();
        cliente.close();
    }
}
