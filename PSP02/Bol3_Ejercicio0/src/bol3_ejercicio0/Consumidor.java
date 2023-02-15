/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio0;

/**
 * Esta clase tiene los mismos atributos que el hilo productor. Ahora en el
 * método run() el hilo invocará al método vaciar() del recipiente para consumir
 * el valor que contiene, luego se bloquea durante unos segundos antes de
 * consumir otro valor.
 *
 * @author Iván Estévez Sabucedo
 */
public class Consumidor extends Thread {

    private Recipiente reci;
    private int numero;

    //constructor
    public Consumidor(Recipiente recipi, int nume) {
        reci = recipi;
        numero = nume;
    }

    public void run() {
        int valor = 0;
        for (int i = 1; i <= 5; i++) {
            valor = reci.vaciar();
            System.out.println("Consumidor " + numero + " toma el valor " + i);

            // Espera un tiempo antes de volver a consumir
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("Interrupcion del hilo...");
            }
        }
    }
}
