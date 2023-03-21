/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso05;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Impresora {

    private Semaphore semaforo;

    public Impresora() {
        this.semaforo = new Semaphore(1);
    }

    public void imprimir(String str) {
        try {
            this.semaforo.acquire();
        } catch (InterruptedException ex) {
            //
            return;
        }

        try {
            Thread.sleep(500);
            System.out.println("IMPRESO!!!! " + str);
        } catch (InterruptedException ex) {
            //
        } finally {
            this.semaforo.release();
        }
        
        
    }
}