/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

/**
 * Diseña un programa que simule la gestión de una caja de supermercado, con 4
 * terminales de pago. Los 4 terminales acceden al recurso compartido Caja
 * (sección crítica), que es donde se va almacenando el importe global de los
 * pagos.
 * 
 * Al final del programa, se mostrará el importe total global facturado.
 *
 * @author Iván Estévez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creo la caja
        Caja caja = new Caja();

        // Creo los 4 terminales
        Terminal t1 = new Terminal("Terminal 1", caja);
        Terminal t2 = new Terminal("Terminal 2", caja);
        Terminal t3 = new Terminal("Terminal 3", caja);
        Terminal t4 = new Terminal("Terminal 4", caja);

        // Inicio de mensajes
        System.out.println("--- Inicio del ejercicio 1 ---\n");

        // Inicio los 4 terminales
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Espero a que finalicen los 4 terminales
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException ex) {
            System.out.println("Error en join: " + ex.getMessage());
        }

        // Muestro por pantalla el importe total que almacena la caja
        System.out.println(caja.toString());
        
        System.out.println("\n--- Fin del ejercicio 1 ---");
    }

}
