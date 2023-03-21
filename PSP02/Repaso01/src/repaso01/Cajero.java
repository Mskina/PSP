/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso01;

/**
 * Es el recurso compartido por los terminales
 *
 * @author Iván Estévez Sabucedo
 */
public class Cajero {

    private int localidades;

    public Cajero() {
    }

    public synchronized void sumarLocalidades() {
        localidades++;
    }

    public synchronized int mostrarLocalidades() {
        return localidades;
    }

}
