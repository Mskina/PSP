/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

/**
 * Usando el modelo productor-consumidor, crea un programa cuyo productor lea 10
 * cadenas de teclado y su consumidor obtenga dichas cadenas, las tranfoerme a
 * mayúsculas, cuente los caracteres recibidos y muestre ambos resultados por
 * pantalla. Cuando el usuario introduzca "*", el programa deberá finalizar.
 *
 * @author Iván Estévez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Creo los tres objetos
        Almacen almacen = new Almacen();
        Productor productor = new Productor(almacen);
        Consumidor consumidor = new Consumidor(almacen);

        System.out.println("--- Inicio del ejercicio 2 ---\n");

        // Inicio productor y consumidor
        productor.start();
        consumidor.start();

        // Espero a que finalicen
        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException ex) {
            System.out.println("Error en join: " + ex.getMessage());
        }

        System.out.println("\n--- Fin del ejercicio 2 ---");
    }
}
