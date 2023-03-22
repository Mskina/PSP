/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso04;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Buffer {

    private final int LIMITE = 6;
    private List<Character> lista;

    public Buffer() {
        this.lista = new ArrayList<>();
    }

    public synchronized void guardarCaracter(char c) {
        while (this.lista.size() == LIMITE) {
            try {
                wait();
            } catch (InterruptedException ex) {
                //
            }
        }
        this.lista.add(c);
        notifyAll();
    }

    public synchronized char leerCaracter() {
        while (this.lista.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                //
            }
        }
        notifyAll();
        return this.lista.remove(0); //FIFO
        // return this.lista.remove(this.lista.size() - 1) // LIFO
    }
}
