/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol2_ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class IncrementaThread extends Thread {

    private Contador contador;

    public IncrementaThread(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                contador.incrementa();
                Thread.sleep(17);
            }
        } catch (InterruptedException ex) {
            System.out.println("Oh no");
        }
    }

}
