/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso03;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class HiloLector extends Thread {

    Semaforo semaforo;

    public HiloLector(String nombre, Semaforo semaforo) {
        super(nombre);
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        while (true) {
            semaforo.accesoLeer();
            try {
                Thread.sleep((int)(Math.random()*70));
            } catch (InterruptedException ex) {
                //
            }
            semaforo.lecturaFinalizada();
            try {
                Thread.sleep((int)(Math.random()*700));
            } catch (InterruptedException ex) {
                //
            }
        }
    }

}
