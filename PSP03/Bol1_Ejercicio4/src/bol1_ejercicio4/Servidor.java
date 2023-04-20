/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol1_ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Crea un programa cliente que introduzca por teclado un número entero y se lo
 * envíe al servidor. El servidor le devolverá el cuadrado del número.
 *
 * @author Iván Estévez Sabucedo
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // Se establece el puerto
        int puerto = 6000;

        // Se crea el socket servidor
        System.out.println(" == PROGRAMA SERVIDOR INICIADO == ");
        ServerSocket servidor = new ServerSocket(puerto);

        // Se crea el socket cliente
        Socket clienteConectado = null;

        // Se espera al cliente
        System.out.println("Esperando al cliente...");
        clienteConectado = servidor.accept();

        // Se crea el flujo de entrada del cliente
        InputStream entrada = null;
        entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        
        int numeroRecibido = flujoEntrada.readInt();

        // Mostramos el mensaje enviado por el cliente
        System.out.println("Recibiendo del CLIENTE: \n\t"
                + numeroRecibido);

        // Se crea el flujo de salida hacia el cliente
        OutputStream salida = null;
        salida = clienteConectado.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);        
        
        // Se devuelve al cliente el número al cuadrado
        flujoSalida.writeDouble(Math.pow(numeroRecibido, 2));

        // Cierre de streams y sockets
        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujoSalida.close();
        clienteConectado.close();
        servidor.close();
    }
}
