import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * El objetivo del ejercicio es crear una aplicación cliente/servidor
 * que se comunique por el puerto 2000 y realice lo siguiente:
 *
 * El servidor debe generar un número secreto de forma aleatoria entre el 0 al 100.
 * El objetivo de cliente es solicitarle al usuario un número y enviarlo al servidor hasta que adivine el
 * número secreto. Para ello, el servidor para cada número que le envía el cliente le indicará si es menor,
 * mayor o es el número secreto del servidor.
 */
public class Cliente {

    public static void main(String[] args) throws Exception {
        System.out.println("-- Iniciando cliente --");

        // Configuramos el socket
        String host = "localhost";
        int puerto = 2000;
        Socket socket = new Socket(host, puerto);

        // Creamos un flujo de salida
        PrintWriter flujoSalida = new PrintWriter(socket.getOutputStream(), true); // autoFlush true, para forzar envío

        // Creamos un flujo de entrada
        BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String textoRecibido = "";

        // Creamos un lectura de teclado
        Scanner scan = new Scanner(System.in);
        int teclado = 0;

        boolean acertado = false;

        while (!acertado) {
            System.out.print("Escribe un número: ");
            teclado = Integer.parseInt(scan.nextLine());

            flujoSalida.println(teclado);
            textoRecibido = flujoEntrada.readLine();
            System.out.println(textoRecibido);

            if (textoRecibido.equals("Acertado")) {
                acertado = true;
            }
        }
        System.out.println("¡Felicidades, has acertado!");
        flujoEntrada.close();
        flujoSalida.close();
        socket.close();

        System.out.println("-- Fin del cliente --");

    }
}