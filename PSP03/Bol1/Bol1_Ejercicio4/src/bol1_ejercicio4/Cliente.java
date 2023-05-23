package bol1_ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // Se establecen host y puerto
        String host = "localhost";
        int puerto = 6000;//puerto remoto	

        // Se inicia el cliente
        System.out.println(" == PROGRAMA CLIENTE INICIADO == ");
        Socket cliente = new Socket(host, puerto);

        // Se crea un flujo de salida hacia el servidor
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

        // Se envía un saludo al servidor
        flujoSalida.writeInt(9);

        // Se crea un flujo de entrada desde el servidor
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

        // El servidor envía un mensaje
        System.out.println("Recibiendo del SERVIDOR: \n\t"
                + flujoEntrada.readDouble());

        // Se cierran streams y sockets	
        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }
}
