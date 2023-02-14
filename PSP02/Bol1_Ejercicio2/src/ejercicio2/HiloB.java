/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class HiloB extends Thread {

    public void run() {
        for (int i = 0; i < 30; i++) {            
            try {
                System.out.println("YES");
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
    }

}
