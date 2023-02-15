/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio0;

/**
 * Esta clase tiene un atributo contenido donde se almacena un valor entero.
 * Debe contar con dos métodos para almacenar y descargar el contenido de forma
 * sincronizada. Si el recipiente no se ha vaciado, habrá que esperar a que un
 * hilo consumidor lo vacíe. Una vez vaciado, se debe notificar que está vacío,
 * por si hay algún hilo productor bloqueado a la espera de llenarlo. Si el
 * recipiente no se ha llenado, un hilo consumidor estará bloqueado para poder
 * vaciar el contenido del recipiente.
 *
 * @author Iván Estévez Sabucedo
 */
public class Recipiente {

    private int contenido;
    private boolean lleno = false;

    /**
     * Es el método utilizado por los hilos consumidores. Si el recipiente no
     * está lleno, el hilo se bloquea a la espera de que lo llene un hilo
     * productor. Cuando le notifican que está lleno, salde del estado de
     * bloqueo, indica que va a coger el contenido del recipiente y lo va a
     * dejar vacío, y notifica que el recipiente está vacío a los procesos que
     * puedan estar bloqueados esperando para llenarlo
     *
     * @return
     */
    public synchronized int vaciar() {
        while (lleno == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("(Método vaciar) Interrupcion del hilo ... ");
            }
        }
        lleno = false;
        notifyAll();
        return contenido;
    }

    /**
     * Es el método utilizado por los hilos productores. Si el recipiente está
     * lleno, se queda bloqueado esperando la notificación de que se ha vaciado.
     * Cuando se le comunica este evento y el recipiente está vacío, lo llena y
     * notifica que está lleno a los hilos que puedan estar bloqueados a la
     * espera de que se llenara.
     *
     * @param valor
     */
    public synchronized void llenar(int valor) {
        while (lleno == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("(Método llenar) Interrupcion del hilo ... ");
            }
        }
        contenido = valor;
        lleno = true;
        notifyAll();
    }
}
