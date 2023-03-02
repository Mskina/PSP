/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.Random;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Productor extends Thread {

    private Buffer bf;
    private int tamanhoTotal;

    public Productor(Buffer bf, int tamanhoTotal) {
        this.bf = bf;
        this.tamanhoTotal = tamanhoTotal;
    }

    @Override
    public void run() {

        Random r = new Random();

        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char stop = (char) -1;
        
        for (int i = 0; i < tamanhoTotal; i++) {
            char c = alfabeto.charAt(r.nextInt(alfabeto.length()));
            bf.depositarCaracter(c);
            System.out.println("El productor ha despositado el caracter " + c + ".");
        }
        // Entrego un caracter final (-1, stop) para indicar que el bucle ha finalizado
        bf.depositarCaracter(stop);
    }

}
