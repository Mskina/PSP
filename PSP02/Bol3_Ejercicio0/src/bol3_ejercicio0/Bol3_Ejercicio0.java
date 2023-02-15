/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol3_ejercicio0;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol3_Ejercicio0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Recipiente reci = new Recipiente();

        Productor produ1 = new Productor(reci, 1);
        Consumidor consu1 = new Consumidor(reci, 1);

        produ1.start();
        consu1.start();
    }

}
