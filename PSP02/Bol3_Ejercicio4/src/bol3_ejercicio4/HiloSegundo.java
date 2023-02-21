/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class HiloSegundo extends Thread {
    
    protected Semaphore semaforo;

    public HiloSegundo(String name, Semaphore semaforo) {
        super(name);
        this.semaforo = semaforo;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloSegundo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("(" + i + ")" + "Me llamo: " + getName());
            semaforo.release();            
        }        
    }  
    
}
