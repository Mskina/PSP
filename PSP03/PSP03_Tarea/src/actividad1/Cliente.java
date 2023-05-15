package actividad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * El cliente debe solicitarle al usuario un número y enviarlo al servidor hasta
 * que adivine el número secreto. El servidor, para cada número que le envía el
 * cliente, le indicará si es menor, mayor o es el número secreto del servidor.
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    private static final String HOST = "localhost";
    private static final int PUERTO = 2000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("-- Iniciando cliente --");

        // Creamos un flujo de salida
        try (
                Socket socket = new Socket(HOST, PUERTO); // Configuro el socket
                 PrintWriter flujoSalida = new PrintWriter(socket.getOutputStream(), true); // Flujo de salida con autoflush
                 BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Flujo de entrada
                ) {

            boolean acertado = false;
            String textoRecibido = "";
            System.out.println("El objetivo del juego es acertar un numero entre el 0 y el 100.");

            // Creamos un lectura de teclado
            Scanner scan = new Scanner(System.in);
            int teclado = 0;

            /**
             * Mientras acertado sea falso, se pide que el usuario escriba un
             * nuevo número. Se recibe por teclado y se envía al servidor, que
             * nos enviará una respuesta.
             */
            while (!acertado) {
                System.out.print("Escribe un numero: ");
                while (!scan.hasNextInt()) {
                    scan.next();
                    System.out.print("Escribe un numero: ");
                }
                
                teclado = scan.nextInt();

                flujoSalida.println(teclado);
                textoRecibido = flujoEntrada.readLine();
                System.out.println(textoRecibido);

                if (textoRecibido.equals("Enhorabuena, has acertado!")) {                    
                    acertado = true;
                }
            }

        } catch (IOException ioe) {
            System.out.println("Excepción: " + ioe.getMessage());
        }

        System.out.println("-- Fin del cliente --");
    }
}
