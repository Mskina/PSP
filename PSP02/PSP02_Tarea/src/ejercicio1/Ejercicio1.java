/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int tamanhoTotal = 15;
        int capacidadBuffer = 6;

        Buffer bf = new Buffer(capacidadBuffer);

        Consumidor consumidor = new Consumidor(bf);
        Productor productor = new Productor(bf, tamanhoTotal);

        System.out.println(">> Inicio del programa.");

        consumidor.start();
        productor.start();
        
        try {
            consumidor.join();
            productor.join();
        } catch (InterruptedException ex) {
            System.out.println("Excepción en join.");
        }
        System.out.println(">> Fin del programa.");

    }
}
