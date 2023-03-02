/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.concurrent.Semaphore;

/**
 * Hilo filósofo. Su método run() realiza un bucle infinito que consite en
 * invocar a los métodos pensar y comer ... -> pensar -> comer...
 *
 * @author Iván Estévez Sabucedo
 */
public class Filosofo extends Thread {

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
        super.run(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * Mostrará un mensaje en la Salida de que el 'Filósofo ' N ' está pensado'.
     * Para simular esta actividad, dormirá el hilo un tiempo aleatorio
     */
    public void pensar() {

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

    }

}
