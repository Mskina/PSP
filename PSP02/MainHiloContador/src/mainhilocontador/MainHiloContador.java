/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainhilocontador;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class MainHiloContador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creo dos hilos        
        HiloContador h1 = new HiloContador("Mi hilo 1");
        HiloContador h2 = new HiloContador("Mi hilo 2");

        // Muestro las prioridades actuales de cada hilo
        System.out.println("Prioridad de h1: " + h1.getPriority());
        System.out.println("Prioridad de h2: " + h2.getPriority());

        // Cambiamos las prioridades
        h1.setPriority(Thread.NORM_PRIORITY + 2);
        h2.setPriority(Thread.NORM_PRIORITY - 2);

        // Muestro las prioridades actuales de cada hilo
        System.out.println("Prioridad de h1: " + h1.getPriority());
        System.out.println("Prioridad de h2: " + h2.getPriority());

        // Arrancamos los hilos. Primero el de menor prioridad
        h2.start();
        h1.start();

        try {
            Thread.sleep(3000); // Dormimos el hilo principal 3 segundos

            h1.stop(); // Detenemos el hilo de mayor prioridad
            h2.stop(); // Detenemos el hilo de menor prioridad
        } catch (InterruptedException ex) {
            System.out.println("Hilo principal interrumpido.");
        }

        System.out.println("h1 ha contado hasta: " + h1.getContador());
        System.out.println("h2 ha contado hasta: " + h2.getContador());
    }

}
