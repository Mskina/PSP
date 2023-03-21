/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repaso06;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Repaso06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(1);
        
        new Marco(s1, s2).start();
        new Polo(s1, s2).start();
    }
    
}
