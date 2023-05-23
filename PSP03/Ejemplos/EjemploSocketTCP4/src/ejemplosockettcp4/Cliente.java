/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplosockettcp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Red Parte 2, página 14.
 * 
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
public class Cliente {
    
    final static String FIN = "*";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Se establecen host y puerto
        String host = "localhost";
        int puerto = 6000;
        
        try {
            // Se crea el socket cliente
            Socket cliente = new Socket(host, puerto);

            // Se crea un flujo de salida hacia el servidor
            PrintWriter flujoSalida = new PrintWriter(cliente.getOutputStream(), true);

            // Se crea un flujo de entrada desde el servidor
            InputStreamReader isr = new InputStreamReader(cliente.getInputStream());
            BufferedReader flujoEntrada = new BufferedReader(isr);

            // Se crea un flujo de entrada para teclado
            BufferedReader textoTeclado = new BufferedReader(new InputStreamReader(System.in));

            String cadena, mensajeServidor = "";
            
            // Se solicita cadena al usuario
            System.out.print("Introduce cadena: ");            
            cadena = textoTeclado.readLine();
            
            // Mientras no sea el caracter de finalización...
            while (!cadena.equals(FIN)) {
                // Se envía la cadena al servidor
                flujoSalida.println(cadena);
                
                // Recibimos la respuesta del servidor
                mensajeServidor = flujoEntrada.readLine();
                System.out.println(" =>Respuesta del servidor: " + mensajeServidor);
                System.out.print("Introduce cadena: ");
                cadena = textoTeclado.readLine();//lectura por teclado                
            }
            // Se cierran streams y sockets
            flujoSalida.close();
            flujoEntrada.close();
            System.out.println("Fin del envio ... ");
            textoTeclado.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
