/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol3_ejercicio4;

import java.util.concurrent.Semaphore;

/**
 * Escribe una clase llamada Orden que cree dos hilos y fuerce que la escritura
 * del segundo sea siempre anterior a la escritura por pantalla del primero,
 * empleando la clase Semaphore del paquete java.util.concurrent.
 *
 * @author Iván Estévez Sabucedo
 */
public class Orden {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Semaphore semaforo = new Semaphore(0);
        
        HiloPrimero hilo1 = new HiloPrimero("Hilo 1", semaforo);
        HiloSegundo hilo2 = new HiloSegundo("Hilo 2", semaforo);
        
        hilo1.start();        
        hilo2.start();
    }

}
