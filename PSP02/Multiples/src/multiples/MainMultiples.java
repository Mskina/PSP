/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiples;

import static java.lang.Thread.activeCount;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class MainMultiples {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Multiples hilo1 = new Multiples("Primero");
        Multiples hilo2 = new Multiples("Segundo");
        Multiples hilo3 = new Multiples("Tercero");
        Multiples hilo4 = new Multiples("Cuarto");

        try {
            hilo1.start();
            hilo2.start();

            System.out.println(">> Hijos en ejecución: " + activeCount());

            hilo1.join();
            hilo2.join();

            System.out.println(">> Hijos en ejecución: " + activeCount());

            hilo3.start();
            hilo4.start();

            System.out.println(">> Hijos en ejecución: " + activeCount());

            hilo3.join();
            hilo4.join();

            System.out.println(">> Hijos en ejecución: " + activeCount());

        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
        System.out.println("Fin de la aplicación principal");
    }

}
