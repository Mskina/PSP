/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio3;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Caracteres extends Thread {

    char caracter;
    boolean hayCaracter;

    public Caracteres() {
    }

    public synchronized void guardarCaracter(char c) {
        while (hayCaracter == true) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("guardarCaracter: Error esperando");
            }
        }
        this.caracter = c;
        hayCaracter = true;
        notifyAll();
    }

    public synchronized char leerCaracter() {
        while (hayCaracter == false) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("leerCaracter: Error esperando");
            }
        }
        char c = this.caracter;
        hayCaracter = false;
        notifyAll();
        return c;
    }

}
