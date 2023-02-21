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
public class Consumidor extends Thread {

    private Cola colita;

    public Consumidor(Cola colita) {
        this.colita = colita;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Leo el número: " + colita.getNum());
        }
    }
}
