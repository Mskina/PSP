/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Buffer {

    private List<Character> buffer;
    private int capacidadBuffer;

    public Buffer(int capacidadBuffer) {
        this.capacidadBuffer = capacidadBuffer;
        this.buffer = new ArrayList<>();
    }

    public synchronized void depositarCaracter(char c) {
        while (buffer.size() >= capacidadBuffer) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Excepción en depositarCaracter");
            }
        }
        buffer.add(c);
        notifyAll();
    }

    public synchronized char recogerCaracter() {
        while (buffer.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Excepción en recogerCaracter");
            }
        }
        char c = buffer.remove(buffer.size()-1);
        notifyAll();
        return c;
    }

    public void setCapacidadBuffer(int capacidadBuffer) {
        this.capacidadBuffer = capacidadBuffer;
    }

}
