/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso03;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Semaforo {

    private final int LIBRE = 0;
    private final int CON_LECTORES = 1;
    private final int CON_ESCRITOR = 2;

    private int estado = LIBRE;
    private int totalLectores = 0;

    public synchronized void accesoLeer() {
        try {
            while (estado == CON_ESCRITOR) {
                wait();
            }
            totalLectores++;
            System.out.println("Entra el lector: " + Thread.currentThread().getName() + "; Lectores actuales: " + totalLectores);
            estado = CON_LECTORES;            
        } catch (InterruptedException ex) {
            //
        }
    }

    public synchronized void accesoEscribir() {
        try {
            while (estado != LIBRE) {
                wait();
            }
            System.out.println("Entra el escritor: " + Thread.currentThread().getName());
            estado = CON_ESCRITOR;            
        } catch (InterruptedException ex) {
            //
        }
    }

    public synchronized void lecturaFinalizada() {
        totalLectores--;
        System.out.println("Sale el lector: " + Thread.currentThread().getName() + "; Lectores actuales: " + totalLectores);        
        if (totalLectores == 0) {
            estado = LIBRE;
            notifyAll();
        }

    }

    public synchronized void escrituraFinalizada() {
        System.out.println("Sale el escritor: " + Thread.currentThread().getName());
        estado = LIBRE;
        notifyAll();
    }
}
