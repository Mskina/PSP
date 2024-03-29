/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol3_ejercicio1;

/**
 * Se trata de simular el comienzo de una clase. Los alumnos llegarán y
 * esperarán hasta que llegue el profesor y salude para que comience la clase.
 * Los alumnos y el profesor compartirán un objeto de la clase Bienvenida, con
 * dos métodos sincronizados:
 *
 * Uno donde los alumnos llegan y saludan al profesor (se quedan esperando
 * mientras el profesor no llegue)
 *
 * Otro donde el profesor llega e indica que la clase puede comenzar,
 * notificándoselo a los alumnos.
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol3_Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        Bienvenida bienvenida = new Bienvenida();
        Profesor profesor = new Profesor(bienvenida);

        Alumno[] alumnos = new Alumno[20];

        for (int i = 0; i < 20; i++) {
            alumnos[i] = new Alumno(bienvenida);
        }

        profesor.start();

        for (int i = 0; i < 20; i++) {
            alumnos[i].start();
        }

        profesor.join();
        System.out.println("Comienza la clase");
    }
}
