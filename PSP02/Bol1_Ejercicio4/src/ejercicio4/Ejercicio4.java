/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creación de array
        Factorial[] array = new Factorial[10];

        // Se añaden los 10 hilos
        for (int i = 0; i < 10; i++) {
            array[i] = new Factorial(i + 5);
        }

        // Se inician los 10 hilos
        for (int i = 0; i < 10; i++) {
            array[i].start();
        }

        // Me aseguro de que han finalizado los 10
        for (int i = 0; i < 10; i++) {
            try {
                array[i].join();
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
        System.out.println("---");
        System.out.println("Finalizados los conjuntos. Pruebas:");

        // Imprimo el resultado
        for (int i = 0; i < 10; i++) {
            Factorial f = array[i];
            System.out.println("El factorial de " + f.getNumero() + " es " + f.getResultado());
        }
    }
}
