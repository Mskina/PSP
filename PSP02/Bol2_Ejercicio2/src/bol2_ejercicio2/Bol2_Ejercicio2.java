/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol2_ejercicio2;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol2_Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Contador contador = new Contador();

        IncrementaThread hiloIncrementa = new IncrementaThread(contador);
        DecrementaThread hiloDecrementa = new DecrementaThread(contador);

        hiloIncrementa.start();
        hiloDecrementa.start();

        hiloIncrementa.join();
        hiloDecrementa.join();

        System.out.println("El valor final es: " + contador.getValor());
    }

}
