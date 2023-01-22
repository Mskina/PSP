/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Vamos a hacer un programa similar al anterior pero instanciando 2 threads. En
 * el HiloA mostrará el mensaje NO, hasta un maximo de 30 veces; en el HiloB
 * mostrará el mensaje YES, hasta un máximo de 30 veces. En el programa
 * principal mostrará un mensaje “Ejecución en HiloA” y se ejecutará el HiloA;
 * luego mostrará un mensaje “Ejecución en HiloB” y se ejecutará el HiloB; y
 * luego un mensaje “Ejecución en main”.
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            System.out.println("Ejecución en HiloA");
            Thread hiloA = new HiloA();
            hiloA.start();
            hiloA.join();

            System.out.println("Ejecución en HiloB");
            Thread hiloB = new HiloB();
            hiloB.start();
            hiloB.join();
            
            System.out.println("Fin: ejecución en main");

        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
    }

}
