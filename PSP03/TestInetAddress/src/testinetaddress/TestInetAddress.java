package testinetaddress;

import java.net.*;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class TestInetAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InetAddress dir = null;
        System.out.println("========================================================");
        System.out.println("SALIDA PARA LOCALHOST: ");
        try {
            //LOCALHOST
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);//

            //URL	www.google.es		
            System.out.println("========================================================");
            System.out.println("SALIDA PARA UNA URL:");
            dir = InetAddress.getByName("www.google.es");
            pruebaMetodos(dir);

            // Array de tipo InetAddress con todas las direcciones IP 
            //asignadas a google.es
            System.out.println("\tDIRECCIONES IP PARA: " + dir.getHostName());
            InetAddress[] direcciones
                    = InetAddress.getAllByName(dir.getHostName());
            for (int i = 0; i < direcciones.length; i++) {
                System.out.println("\t\t" + direcciones[i].toString());
            }

            System.out.println("========================================================");

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }
    }// main

    private static void pruebaMetodos(InetAddress dir) {
        
        System.out.println("\ngetByName(): devuelve un objeto InetAddress que representa la direccion IP de la mauina "
                + "\nque se especifica como parametro (host). Este parametro puede ser el nombre de la maquina,"
                + "\nun nombre de dominio o una dirección IP.");
        System.out.println("\tMetodo getByName(): " + dir);
        
        
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\ngetLocalHost(): devuelve un objeto InetAddress que representa la direccion IP de la maquina "
                    + "\ndonde se esta ejecutando el programa");
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // USAMOS METODOS DE LA CLASE        
        System.out.println("\ngetHostName(): devuelve el nombre del host de un objeto InetAddress");
        System.out.println("\tgetHostName(): " + dir.getHostName());

        System.out.println("\ngetHostAddress(): devuelve la direccion IP de un objeto InetAddress en forma de cadena");
        System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());

        System.out.println("\ntoString(): Converts this IP address to a String. The string returned is of the form: "
                + "\nhostname / literal IP address. If the host name is unresolved, no reverse name service"
                + "\nlookup is performed. The hostname part will be represented by an empty string.");
        System.out.println("\tMetodo toString(): " + dir.toString());

        System.out.println("\ngetCanonicalHostName(): obtiene el nombre canonico completo (suele ser la direccion real del host) "
                + "\nde un objeto InetAddress");
        System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
    }	

}