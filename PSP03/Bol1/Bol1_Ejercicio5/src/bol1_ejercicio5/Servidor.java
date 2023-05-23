package bol1_ejercicio5;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Crea un programa servidor que pueda atender hasta 3 clientes. Debe enviar a
 * cada cliente un mensaje indicando el número de cliente que es. Este número
 * será 1, 2 o 3. El cliente mostrará el mensaje recibido. Cambia el programa
 * para que lo haga para N clientes, siendo N un parámetro que tendrás que
 * definir en el programa.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    private final static int FIN = 17;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Se establece el puerto
        int puerto = 6000;

        // Se crea el socket servidor
        System.out.println(" == PROGRAMA SERVIDOR INICIADO == ");
        ServerSocket servidor = new ServerSocket(puerto);

        for (int i = 1; i < FIN + 1; i++) {
            // Se crea el socket cliente
            Socket clienteConectado = null;

            // Se espera al cliente
            System.out.println("Esperando al cliente...");
            clienteConectado = servidor.accept();
            System.out.println("Se ha conectado el cliente " + i);

            // Se crea el flujo de salida hacia el cliente
            OutputStream salida = null;
            salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            // Se devuelve al cliente el número al cuadrado
            flujoSalida.writeInt(i);

            // Cierre de streams y socket
            salida.close();
            flujoSalida.close();
            clienteConectado.close();
        }

        // Cierre del servidor
        servidor.close();
        System.out.println(" == PROGRAMA SERVIDOR FINALIZADO == ");
    }
}
