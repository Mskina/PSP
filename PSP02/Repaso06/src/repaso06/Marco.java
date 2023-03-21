/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso06;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Marco extends Thread {

    private Semaphore s1;
    private Semaphore s2;
    
    public Marco(Semaphore s1, Semaphore s2) {
        this.s1 = s1;
        this.s2 = s2;
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                s2.acquire();
                System.out.println("Marco");
                s1.release();
            } catch (InterruptedException ex) {
                //
            }
        }
    }
    
}
