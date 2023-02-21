/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio1;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Profesor extends Thread {

    private Bienvenida bienvenida;

    public Profesor(Bienvenida bienvenida) {
        this.bienvenida = bienvenida;
    }

    public void run() {
        try {
            Thread.sleep(76);
        } catch (InterruptedException ex) {
            System.out.println("Error al dormir/despertar del profesor");
        }
        bienvenida.empezarClase();
    }

}
