/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio1;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Alumno extends Thread {

    private Bienvenida bienvenida;

    public Alumno(Bienvenida bienvenida) {
        this.bienvenida = bienvenida;
    }

    public void run() {
        try {
            bienvenida.saludar();
        } catch (InterruptedException ex) {
            System.out.println("Error al arrancar al alumno");
        }
    }

}
