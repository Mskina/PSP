/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio3;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Consumidor extends Thread {
    
    private Caracteres caracteres;

    public Consumidor(Caracteres caracteres) {
        this.caracteres = caracteres;
    }
    
    public void run() {
        char c;
        while ((c = caracteres.leerCaracter()) != (char)-1) {
            System.out.print(c);
        }
        System.out.println("");
    }
    
}
