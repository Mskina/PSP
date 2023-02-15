/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol2_ejercicio4;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Cuenta {

    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void retirarSaldo(double retirada) {
        boolean comprobacion = comprobarRetirada(retirada);
        if (comprobacion) {
            double saldoFinal = getSaldo() - retirada;
            setSaldo(saldoFinal);
            System.out.println(">> Retirada efectuada. Saldo actual: "+getSaldo());
        } else {
            System.out.printf(">> Retirada no efectuada: Tienes %.2f euros y has intentado retirar %.2f \n", getSaldo(), retirada);
        }
    }

    private boolean comprobarRetirada(double retirada) {
        return (getSaldo() - retirada) >= 0;
    }

}
