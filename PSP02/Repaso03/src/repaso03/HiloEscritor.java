/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso03;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class HiloEscritor extends Thread {
    
    Semaforo semaforo;
    
    public HiloEscritor(String nombre, Semaforo semaforo) {
        super(nombre);
        this.semaforo = semaforo;
    }
    
    @Override
    public void run() {
        while (true) {
            semaforo.accesoEscribir();
            try {
                Thread.sleep((int)(Math.random()*500));
            } catch (InterruptedException ex) {
                //
            }
            semaforo.escrituraFinalizada();
        }
    }
}
