/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiples;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Multiples extends Thread{ //Hereda - "es un"{
    
    // Constructor    
    public Multiples (String nombre) {
        super(nombre);
    }
    
    // Redifinición del método run(), que es el que contiene
    // las indicaciones de lo que hará el hilo    
    @Override
    public void run() {
        try {
            for (int i=0; i<4;i++) {
                // Muestra el nombre del hilo actual
                System.out.println("En ejecución: " + Thread.currentThread().getName());
                
                // Duermo el hilo actual 1 segundo
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
        
        System.out.println(Thread.currentThread().getName() + " ha finalizado.");
    }
}
