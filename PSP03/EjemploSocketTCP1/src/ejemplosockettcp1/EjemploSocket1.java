/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplosockettcp1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class EjemploSocket1 {

    /**
     * Red Parte 2, página 5.
     * 
     * El siguiente ejemplo crea un socket de servidor y lo enlaza al puerto
     * 6000, visualiza el puerto por el que se esperan las conexiones y espera
     * que se conecten 2 clientes.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int puerto = 6000;// Puerto

        ServerSocket servidor = new ServerSocket(puerto);

        System.out.println("Escuchando en " + servidor.getLocalPort());

        // Esperamos a un cliente
        Socket clientel = servidor.accept();
        System.out.println("Conectado cliente1");

        // Esperamos a otro cliente
        Socket cliente2 = servidor.accept();
        System.out.println("Conectado cliente2");

        // Cerramos el socket servidor
        Thread.sleep(2000);
        servidor.close();
    }

}
