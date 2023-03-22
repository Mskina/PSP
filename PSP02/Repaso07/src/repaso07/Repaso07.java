/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso07;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Repaso07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        for (int i = 0; i < 30; i++) {

            char A = 'A';
            char B = 'B';
            char C = 'C';

            StringBuilder sb = new StringBuilder();
            Semaphore semaforo = new Semaphore(1);

            Escribir escribir1 = new Escribir(sb, A, semaforo);
            Escribir escribir2 = new Escribir(sb, B, semaforo);
            Escribir escribir3 = new Escribir(sb, C, semaforo);

            escribir1.start();
            escribir2.start();
            escribir3.start();

            try {
                escribir1.join();
                escribir2.join();
                escribir3.join();
            } catch (InterruptedException ex) {
                //
            }

            System.out.println(sb.length() + ": " + sb.toString());
        }
    }

}
