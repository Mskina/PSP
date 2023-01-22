/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Hilo extends Thread {

    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println("NO");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
}
