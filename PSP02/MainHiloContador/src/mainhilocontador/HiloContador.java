/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainhilocontador;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class HiloContador extends Thread {

    private int contador;

    public HiloContador(String nombre) {
        super(nombre);
        contador = 0;
    }

    public int getContador() {
        return contador;
    }

    public void run() {
        while (true) {
            contador++;
        }
    }

}
