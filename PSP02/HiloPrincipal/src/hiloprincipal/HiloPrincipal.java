/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiloprincipal;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class HiloPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Thread hilo = Thread.currentThread();
        System.out.println("El hilo principal se llama " +hilo.getName());
    }
    
}
