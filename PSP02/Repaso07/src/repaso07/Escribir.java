/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso07;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Escribir extends Thread {

    private StringBuilder sb;
    private char c;
    Semaphore semaforo;

    public Escribir(StringBuilder sb, char c, Semaphore semaforo) {
        this.sb = sb;
        this.c = c;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {

        try {
            semaforo.acquire();
        } catch (InterruptedException ex) {
            //
        }

        for (int i = 0; i < 30; i++) {
            sb.append(c);
        }

        semaforo.release();
    }

}
