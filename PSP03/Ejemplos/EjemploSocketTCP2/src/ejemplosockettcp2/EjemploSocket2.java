/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplosockettcp2;

import java.net.InetAddress;
import java.net.Socket;

/**
 * Red Parte 2, página 6.
 * 
 * El siguiente ejemplo crea un socket cliente y lo conecta al host local al
 * puerto 6000 (tiene que haber un ServerSocket escuchando en ese puerto).
 * Después, visualiza el puerto local al que está conectado el socket, el
 * puerto, host y dirección IP de la máquina remota a la que se conecta (en este
 * caso es el host local):
 *
 * @author Iván Estévez Sabucedo
 */
public class EjemploSocket2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int puerto = 6000;

        // Abro el socket
        Socket cliente = new Socket(host, puerto);

        // Una vez conectado...
        InetAddress i = cliente.getInetAddress();
        System.out.println("Puerto local: " + cliente.getLocalPort());
        System.out.println("Puerto Remoto: " + cliente.getPort());
        System.out.println("Host Remoto: " + i.getHostName().toString());
        System.out.println("IP Host Remoto: " + i.getHostAddress().toString());

        // Cierre del socket
        cliente.close();
    }
}
