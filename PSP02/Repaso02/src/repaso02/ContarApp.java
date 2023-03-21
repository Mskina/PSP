/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso02;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class ContarApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ContarThread hilo1 = new ContarThread(10);
        hilo1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ContarApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        ContarThread hilo2 = new ContarThread(10);
        hilo2.start();

        while (hilo1.isAlive() || hilo2.isAlive()) {
            System.out.println("Sigo contando...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ContarApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ContarApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Acabé.");

    }

}
