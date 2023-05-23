package bol1_ejercicio3;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Realiza un programa servidor TCP que acepte 2 clientes. Mostrar para cada
 * cliente conectado sus puertos local y remoto. Implementar también el programa
 * cliente, donde se muestren los puertos locales y remotos a los que se
 * encuentre conectado, asi como la IP de la máquina remota a la que se conecta.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int puerto = 6000;

        // Se crea el socket servidor
        System.out.println(" == PROGRAMA SERVIDOR INICIADO == ");
        ServerSocket servidor = new ServerSocket(puerto);

        // Se crea el socket cliente
        Socket clienteConectado = null;

        // Se espera a 2 clientes
        for (int i = 1; i < 3; i++) {
            System.out.println("Esperando al cliente " + i);
            clienteConectado = servidor.accept();

            // Con el cliente ya conectado, muestro sus puertos local y remoto
            System.out.println("\ngetLocalPort(): devuelve el puerto LOCAL al que"
                    + "\n esta enlazado el socket. -1 si no esta enlazado a ningun puerto");
            System.out.println("\tPuerto local: " + clienteConectado.getLocalPort());

            System.out.println("\ngetPort(): devuelve el puerto REMOTO al que"
                    + "\n esta conectado el socket. -1 si no esta conectado a ningun puerto");
            System.out.println("\tPuerto remoto: " + clienteConectado.getPort());

            clienteConectado.close();
        }
        servidor.close();
    }
}
