/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol2_ejercicio3;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class SaldoThread extends Thread {

    private Saldo saldo;
    private double ingreso;

    public SaldoThread(Saldo saldo) {
        this.saldo = saldo;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }    

    @Override
    public void run() {
        saldo.realizarIngreso(ingreso);
    }
}
