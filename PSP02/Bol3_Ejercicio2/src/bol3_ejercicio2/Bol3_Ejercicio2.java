/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol3_ejercicio2;

/**
 * Implementar una aplicación compuesta por 3 clases:
 *
 * - Una Cola, que será el objeto compartido.
 *
 * - Un productor y un consumidor.
 *
 * El productor generará 10 números, y los insertará en el objeto Cola, tras
 * hacer un pequeño sleep. El consumidor los leerá, y los mostrará por pantalla.
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol3_Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Cola colita = new Cola();
        Consumidor consumidor = new Consumidor(colita);
        Productor productor = new Productor(colita);

        productor.start();
        consumidor.start();
    }

}
