/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol2_ejercicio4;

import java.util.Random;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class RetiradaCajeroThread extends Thread {

    Cuenta cuenta;

    public RetiradaCajeroThread(String name, Cuenta cuenta) {
        this.setName(name); // Implementado por Thread
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        Random rand = new Random();        
        for (int i = 0; i < 10; i++) {
            //double retirada = rand.nextDouble(25);
            cuenta.retirarSaldo(25);
            //System.out.printf("%s intenta retirar %.2f \n", this.getName(), retirada);
        }
    }

}
