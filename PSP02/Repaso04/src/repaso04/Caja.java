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
public class Caja {
    
    private boolean lleno;
    private char c;

    public Caja() {
        this.lleno = false;
    }
    
    public synchronized void guardarCaracter(char c) {
        while (this.lleno) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.c = c;
        this.lleno = true;
        notifyAll();
    }
    
    public synchronized char leerCaracter() {
        while (!this.lleno) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        char leido = this.c;
        this.lleno = false;
        notifyAll();
        return leido;
    }
}
