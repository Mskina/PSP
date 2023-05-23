/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol1_ejercicio1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Realiza un programa Java que admita desde consola nombres de máquinas o
 * direcciones IP y vaya mostrando por pantalla información sobre ellas,
 * haciendo uso de la clase InetAddress.
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol1_Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Escribe una URL o IP: ");
        String textoEscrito = scan.nextLine();

        try {
            InetAddress dir = InetAddress.getByName(textoEscrito);

            System.out.println("\ngetHostName(): devuelve el nombre del host de un objeto InetAddress");
            System.out.println("\t- getHostName(): " + dir.getHostName());

            System.out.println("\ngetHostAddress(): devuelve la direccion IP de un objeto InetAddress en forma de cadena");
            System.out.println("\t- Metodo getHostAddress(): " + dir.getHostAddress());

            System.out.println("\ntoString(): Converts this IP address to a String. The string returned is of the form: "
                    + "\nhostname / literal IP address. If the host name is unresolved, no reverse name service"
                    + "\nlookup is performed. The hostname part will be represented by an empty string.");
            System.out.println("\t- Metodo toString(): " + dir.toString());

            System.out.println("\ngetCanonicalHostName(): obtiene el nombre canonico completo (suele ser la direccion real del host) "
                    + "\nde un objeto InetAddress");
            System.out.println("\t- Metodo getCanonicalHostName(): " + dir.getCanonicalHostName());

        } catch (UnknownHostException ex) {
            System.out.println("Error en la URL o IP");
        }
    }
}
