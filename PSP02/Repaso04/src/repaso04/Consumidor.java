/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso04;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Consumidor extends Thread {
    
    private Caja caja;

    public Consumidor(Caja caja) {
        this.caja = caja;
    }
    
    @Override
    public void run() {
        char c = '\0';
        while (c != '.') {
            c = caja.leerCaracter();
            System.out.println("Consumidor: " + c);
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
