/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import java.util.concurrent.Semaphore;

/**
 * Clase donde reside el método main() que inicia la aplicación
 *
 * @author Iván Estévez Sabucedo
 */
public class Main {

    /**
     * Define los parámetros necesarios para construir hilos filósofos (ver el
     * constructor de la clase Filosofo). Se crean los 5 filósofos, y los
     * inicia.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Se emplea variable por si se quiere variar el comportamiento
        int numFilosofos = 5;

        // Se podría añadir una comprobación, ya que con 1 filósofo no funcionaría correctamente
//        if (numFilosofos == 1) {
//            System.out.println("No se puede realizar con 1 comensal");
//            System.exit(0);
//        }
        
        // Siguiendo indicaciones de la documentación, creo una matriz
        // en la que establezo qué dos palillos corresponden a cada filósofo.
        // MATRIZ
        int[][] palillosFilosofo = new int[numFilosofos][2]; // 5 filósofos, 2 palillos
//        Asignación inicial: manual para 5 filósofos
//        palillosFilosofo[0][0] = 0; // Filósofo 1, izq palillo 1
//        palillosFilosofo[0][1] = 4; // Filósofo 1, der palillo 5
//        palillosFilosofo[1][0] = 1;
//        palillosFilosofo[1][1] = 0;
//        palillosFilosofo[2][0] = 2;
//        palillosFilosofo[2][1] = 1;
//        palillosFilosofo[3][0] = 3;
//        palillosFilosofo[3][1] = 2;
//        palillosFilosofo[4][0] = 4;
//        palillosFilosofo[4][1] = 3;

        // Mejora: asignando de forma que se puedan añadir más o menos filósofos.
        // Los pallilos del filósofo 1 no siguen la norma
        palillosFilosofo[0][0] = 0;
        palillosFilosofo[0][1] = numFilosofos - 1;

        // En el bucle se asignan del mismo modo para todos
        for (int i = 1; i < numFilosofos; i++) {
            palillosFilosofo[i][0] = i;
            palillosFilosofo[i][1] = i - 1;
        }

        // Creo un array de semáforos y le establezo su tamaño
        Semaphore[] palillos = new Semaphore[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            // Se inicia a 1 porque el palillo está libre al empezar
            palillos[i] = new Semaphore(1);
        }

        // Creo un array de filósofos y le establezco su tamaño
        Filosofo[] filosofos = new Filosofo[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Filosofo(i, palillos, palillosFilosofo);
        }

        // Inicio todos los hilos al mismo tiempo
        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i].start();
        }
    }
}
