package bol1_ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Iván Estévez Sabucedo
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // Se establecen host y puerto
        String host = "localhost";
        int puerto = 6000; //puerto remoto	

        // Se inicia el cliente
        System.out.println(" == PROGRAMA CLIENTE INICIADO == ");
        Socket cliente = new Socket(host, puerto);

        // Con el cliente ya conectado, muestro sus puertos local y remoto
        System.out.println("\ngetLocalPort(): devuelve el puerto LOCAL al que"
                + "\n esta enlazado el socket. -1 si no esta enlazado a ningun puerto");
        System.out.println("\tPuerto local: " + cliente.getLocalPort());

        System.out.println("\ngetPort(): devuelve el puerto REMOTO al que"
                + "\n esta conectado el socket. -1 si no esta conectado a ningun puerto");
        System.out.println("\tPuerto remoto: " + cliente.getPort());

        System.out.println("\ngetInetAddress(): Returns the address to which the socket is connected.");
        // Necesito procesar esa InetAddress, ya que un toString me devolvería
        // "localhost/127.0.0.1"
        InetAddress ia = cliente.getInetAddress();
        System.out.println("\tIP de la maquina remota: " + ia.getHostAddress());

        cliente.close();
    }

}
