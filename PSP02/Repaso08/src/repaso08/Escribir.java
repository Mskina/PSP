/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso08;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Escribir extends Thread {

    private StringBuilder sb;
    private char c;

    private boolean escribiendo = false;

    public Escribir(StringBuilder sb, char c) {
        this.sb = sb;
        this.c = c;
    }

    public synchronized void guardarChar(char c) {
        while (escribiendo) {
            try {
                wait();
            } catch (InterruptedException ex) {
                //
            }
        }
        escribiendo = true;
        for (int i = 0; i < 30; i++) {
            sb.append(c);
        }
        escribiendo = false;
        notifyAll();
    }

    @Override
    public void run() {
        guardarChar(c);
    }

}
