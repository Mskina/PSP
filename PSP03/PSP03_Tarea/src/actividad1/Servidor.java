package actividad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * El servidor debe generar un número secreto de forma aleatoria entre 0 y 100.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    private static final int PUERTO = 2000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("-- Iniciando servidor --");

        try (
                ServerSocket serverSocket = new ServerSocket(PUERTO); // Creo el socket servidor
                 Socket clienteConectado = serverSocket.accept(); // Creo el socket cliente y acepto su conexión
                 PrintWriter flujoSalida = new PrintWriter(clienteConectado.getOutputStream(), true); // Creo el flujo de salida. Autoflush true para forzar la salida
                 BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream())); // Creo el flujo de entrada                
                ) {

            boolean acertado = false;
            int numeroRecibido;

            // Creo un número aleatorio
            Random random = new Random();
            int numeroAleatorio = random.nextInt(100);
            System.err.println("Debug: el numero generado es " + numeroAleatorio);

            /**
             * Mientras acertado sea falso, se siguen recibiendo números del
             * cliente, indicando si el número recibido es menor, mayor o igual
             * al generado. Al acertar se finaliza
             */
            while (!acertado) {
                numeroRecibido = Integer.parseInt(flujoEntrada.readLine());
                if (numeroRecibido == numeroAleatorio) {
                    flujoSalida.println("Enhorabuena, has acertado!");
                    System.err.println("Debug: el usuario ha acertado");
                    acertado = true;
                } else if (numeroRecibido < numeroAleatorio) {
                    flujoSalida.println("El numero que has escrito es menor al numero buscado");
                } else if (numeroRecibido > numeroAleatorio) {
                    flujoSalida.println("El numero que has escrito es mayor al numero buscado");
                }

            }
        } catch (IOException ioe) {
            System.out.println("Excepción: " + ioe.getMessage());
        }
        System.out.println("-- Fin del servidor --");
    }
}
