/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplosockettcp3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Red Parte 2, página 10.
 * 
 * El programa cliente, en primer lugar envía un mensaje al servidor y después
 * recibe un mensaje del servidor visualizándolo en pantalla.
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
        flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");

        // Se crea un flujo de entrada desde el servidor
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

        // El servidor envía un mensaje
        System.out.println("Recibiendo del SERVIDOR: \n\t"
                + flujoEntrada.readUTF());

        // Se cierran streams y sockets	
        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }
}
