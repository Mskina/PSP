/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio4;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class HiloPrimero extends Thread {
    
    protected Semaphore semaforo;

    public HiloPrimero(String name, Semaphore semaforo) {
        super(name);
        this.semaforo = semaforo;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                semaforo.acquire();
                System.out.println("(" + i + ")" + "Me llamo: " + getName());
            } catch (InterruptedException ex) {
                //Logger.getLogger(HiloPrimero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }    
}
