/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio2;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cola {

    private Queue<Integer> colita;

    public Cola() {
        this.colita = new LinkedList<>();
    }

    public synchronized void addNum(int numero) {
        try {
            while (colita.size() == 10) {
                wait();
            }
            colita.add(numero);
            System.out.println("Añadido el número: "+numero);
            notifyAll();
        } catch (InterruptedException ex) {
            System.out.println("Error al añadir");
        }
    }

    public synchronized int getNum() {
        int numero = Integer.MIN_VALUE;
        try {
            while (colita.isEmpty()) {
                wait();                
            }
            numero = colita.remove();
            notifyAll();

        } catch (InterruptedException ex) {
            System.out.println("Error al leer");
        }
        return numero;
    }
}
