/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol2_ejercicio3;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol2_Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        double saldoInicial = 0.0;
        Saldo saldo = new Saldo(saldoInicial);

        Double ingreso1 = 17.17;
        SaldoThread hilo1 = new SaldoThread(saldo);
        hilo1.setName("hilo1");
        hilo1.setIngreso(ingreso1);
        hilo1.start();

        Double ingreso2 = 18.18;
        SaldoThread hilo2 = new SaldoThread(saldo);
        hilo2.setName("hilo2");
        hilo2.setIngreso(ingreso2);
        hilo2.start();

        Double ingreso3 = 19.19;
        SaldoThread hilo3 = new SaldoThread(saldo);
        hilo3.setName("hilo3");
        hilo3.setIngreso(ingreso3);
        hilo3.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("El saldo final es: " + saldo.getSaldo());
    }

}
