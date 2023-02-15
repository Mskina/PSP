/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol2_ejercicio4;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol2_Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        double saldoInicial = 100;
        Cuenta cuenta = new Cuenta(saldoInicial);

        RetiradaCajeroThread hilo1 = new RetiradaCajeroThread("Pepe", cuenta);
        RetiradaCajeroThread hilo2 = new RetiradaCajeroThread("Maria", cuenta);
        
        hilo1.start();
        hilo2.start();
        
        hilo1.join();
        hilo2.join();
        
        System.out.println("Saldo final: " + cuenta.getSaldo());
    }

}
