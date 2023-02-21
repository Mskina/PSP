/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Productor extends Thread {

    private Cola colita;

    public Productor(Cola colita) {
        this.colita = colita;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(177);
                colita.addNum(i);
            } catch (InterruptedException ex) {
                System.out.println("Error en el hilo Productor");
            }
        }
    }

}
