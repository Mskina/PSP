/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Consumidor extends Thread {

    private Buffer bf;

    public Consumidor(Buffer bf) {
        this.bf = bf;
    }

    public void run() {
        char c;
        
        char stop = (char) -1;

        // Leo caracteres hasta que me llegue un -1 (stop)
        while ((c = bf.recogerCaracter()) != stop) {
            System.out.println("El consumidor ha recogido el caracter " + c + ".");
        }
    }
}
