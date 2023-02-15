/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol2_ejercicio3;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Saldo {

    private double saldo;

    public Saldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        try {
            SaldoThread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("Oh no! " + ex.getMessage());
        }
        return saldo;
    }

    public void setSaldo(double saldo) {
        try {
            SaldoThread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("Oh no! " + ex.getMessage());
        }
        this.saldo = saldo;
    }
// Cómo obtengo el nombre del hilo?
    public void realizarIngreso(double ingreso) {
        String nombreHilo = Thread.currentThread().getName();
        double saldoFinal = getSaldo() + ingreso;
        setSaldo(saldoFinal);
        System.out.printf("El saldo después del ingreso de %s es: %.2f \n",nombreHilo,getSaldo());
    }

}
