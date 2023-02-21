/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio1;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Bienvenida {

    public synchronized void saludar() throws InterruptedException {
        System.out.println("Entra en clase el alumno " + Thread.currentThread().getName());
        wait();
    }

    public synchronized void empezarClase() {
        System.out.println("Llega el profesor al aula");
        notifyAll();
    }

}
