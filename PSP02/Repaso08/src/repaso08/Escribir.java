/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso08;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Escribir extends Thread {

    private StringBuilder sb;
    private char c;

    public Escribir(StringBuilder sb, char c) {
        this.sb = sb;
        this.c = c;
    }

    @Override
    public void run() {

        synchronized (this.sb) {
            for (int i = 0; i < 30; i++) {
                sb.append(c);
            }
        }
    }
}
