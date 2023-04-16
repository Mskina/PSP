/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplosocket4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * En el siguiente ejemplo el programa cliente envía el texto tecleado en su
 * entrada estándar al servidor (en un puerto pactado) escribiendo en el socket,
 * el servidor lee del socket y devuelve de nuevo al cliente el texto recibido
 * escribiendo en el socket; el programa cliente lee del socket lo que le envía
 * el servidor de vuelta y lo muestra en pantalla. El programa servidor finaliza
 * cuando el cliente termine la entrada por teclado o cuando recibe como cadena
 * un asterisco; el cliente finaliza cuando se detiene la entrada de datos
 * mediante las teclas Ctrl+C o Ctrl+Z.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    final static String FIN = "*";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se establece el puerto
        int puerto = 6000;

        try {
            // Se inicia el socket servidor
            System.out.println("Esperando conexión ... ");
            ServerSocket servidor = new ServerSocket(puerto);

            // Se espera al cliente
            Socket clienteConectado = servidor.accept();
            System.out.println("Cliente conectado ... ");

            // Se crea un flujo de salida hacia el cliente
            PrintWriter flujoSalida = new PrintWriter(clienteConectado.getOutputStream(), true);

            // Se crea un flujo de entrada desde el cliente
            InputStreamReader isr = new InputStreamReader(clienteConectado.getInputStream());
            BufferedReader flujoEntrada = new BufferedReader(isr);

            // Se espera por la cadena del cliente
            String cad = flujoEntrada.readLine();

            // Si se recibe algo...
            if (cad != null) {
                // Mientras no se reciba el caracter de finalización...
                while (!(cad.equals(FIN))) {
                    // Devolvemos la cadena al cliente
                    flujoSalida.println(cad.toUpperCase()); //envio cadena al cliente
                    // Mostramos por pantalla la cadena recibida
                    System.out.println("Recibiendo: " + cad);
                    cad = flujoEntrada.readLine();
                    if (cad == null) {
                        break;
                    }
                }
            }

            // Se cierran streams y sockets
            System.out.println("Cerrando conexion ... ");
            flujoEntrada.close();
            flujoSalida.close();
            clienteConectado.close();
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
