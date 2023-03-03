/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Hilo filósofo. Su método run() realiza un bucle infinito que consite en
 * invocar a los métodos pensar y comer ... -> pensar -> comer...
 *
 * @author Iván Estévez Sabucedo
 */
public class Filosofo extends Thread {

    private final Random r = new Random();

    private int miIndice;
    private Semaphore[] semaforoPalillo;
    private int[][] palillosFilosofo;

    /**
     * Constructor de tres parámetros, cada uno de los cuales se guardará en una
     * variable local para usarla cuando sea neceario
     *
     * @param miIndice índice que identifica al filósofo (un entero del 0 al 4)
     * @param semaforoPalillo vector de semáforos (uno para cada palillo)
     * @param palillosFilosofo matriz que para cada valor de su primer índice,
     * la fila, almacena los palillos que necesita el filósofo de ese índice
     * para comer. Por ejemplo: el filósofo de índice 0 necesita los palillos de
     * índices {0,4}, el de índice 1 los de índices {1,0}, etc... Puedes
     * prescindir de este vector si se te ocurre como calcular en tiempo real
     * los índices de los palillos que necesita cada filósofo para comer
     */
    public Filosofo(int miIndice, Semaphore[] semaforoPalillo, int[][] palillosFilosofo) {
        this.miIndice = miIndice;
        this.semaforoPalillo = semaforoPalillo;
        this.palillosFilosofo = palillosFilosofo;
    }

    /**
     * Bucle infinito: llamada al método pensar(), llamada al método comer().
     */
    @Override
    public void run() {
        while (true) {
            pensar();
            comer();
        }
    }

    /**
     * Mostrará un mensaje en la Salida de que el 'Filósofo ' N ' está pensado'.
     * Para simular esta actividad, dormirá el hilo un tiempo aleatorio
     */
    public void pensar() {
        try {
            System.out.println("El filosofo " + miIndice + " esta pensando.");
            Thread.sleep(r.nextInt(700) + 300);
        } catch (InterruptedException ex) {
            System.out.println("Excepción en pensar().");
        }
    }

    /**
     * Mostrará un mensaje en la Salida de que el 'Filósofo ' N ' está
     * hambriento', mientras trata de conseguir los dos palillos que necesita
     * para comer. Una vez conseguidos, mostrará un mensaje de que el 'Filósofo
     * ' N ' está comiendo'. Para simular esta actividad, dormirá el hilo un
     * tiempo aleatorio. Cuando termine, mostrará un mensaje de que el 'Filósofo
     * ' N ' ha terminado de comer', indicando los palillos que se quedan libres
     */
    public void comer() {
        System.out.println("El filosofo " + miIndice + " esta hambriento.");

        int indicePalilloIzq = palillosFilosofo[miIndice][0];
        int indicePalilloDer = palillosFilosofo[miIndice][1];

        boolean exito = false;
        try {
            while (!exito) {
                boolean palIzqDispo = semaforoPalillo[indicePalilloIzq].tryAcquire(r.nextInt(2000) + 1000, TimeUnit.MILLISECONDS);

                // Si adquiero el pallilo izquierdo, intento conseguir el derecho
                if (palIzqDispo) {
                    boolean palDerDispo = semaforoPalillo[indicePalilloDer].tryAcquire(r.nextInt(2000) + 1000, TimeUnit.MILLISECONDS);

                    // Si en ese tiempo adquiero el palillo derecho, como
                    if (palDerDispo) {
                        System.out.println("El filosofo " + miIndice + " esta comiendo.");
                        Thread.sleep(r.nextInt(700) + 300);
                        System.out.println("El filosofo " + miIndice + " ha terminado de comer.");

                        semaforoPalillo[indicePalilloIzq].release();
                        semaforoPalillo[indicePalilloDer].release();
                        exito = true;
                    } else {
                        // Si no he conseguido el palillo derecho, suelto el izquierdo
                        semaforoPalillo[indicePalilloIzq].release();
                    }
                }
            }
        } catch (InterruptedException ex) {
            System.out.println("Error al adquirir los palillos.");
        }
    }
}
