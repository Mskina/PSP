/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio0;

/**
 * Esta clase sólo tendrá el método run() donde invocará a la variable
 * compartida. Después de llenar el recipiente, se bloquea durante un tiempo
 * aleatorio.
 *
 * @author Iván Estévez Sabucedo
 */
public class Productor extends Thread {

    /**
     * Almacena una referencia al recipiente común. Esta referencia se la
     * transfiero a la clase a través del constructor
     */
    private Recipiente reci;

    /**
     * Nos permite identificar al hilo en el caso de que haya más de un hilo
     * productor. Su valor se lo asigno en el constructor de la clase
     */
    private int numero; //Si hay varios productores, cada uno llevará un numero

    // Constructor
    public Productor(Recipiente recipi, int num) {
        reci = recipi;
        numero = num;
    }

    /**
     * El método run() del hilo sólo invoca al método llenar() del recipiente
     * para llenarlo y espera un tiempo determinado antes de volver a llenar el
     * recipiente.
     */
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            reci.llenar(i);
            System.out.println("Productor " + numero + " pone el valor " + i);

            // Espera un tiempo antes de volver a llenar
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.println("Interrupcion del hilo...");
            }
        }
    }
}
