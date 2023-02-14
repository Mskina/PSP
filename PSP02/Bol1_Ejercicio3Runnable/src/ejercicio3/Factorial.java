/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 * Recuerda que factorial(0)=1 y para todo n>0, factorial(n)=n*factorial(n-1).
 *
 * @author Iván Estévez Sabucedo
 */
public class Factorial implements Runnable {
    
    int numero;
    
    public Factorial (int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        int factorial = 1;
        if (numero == 0) {
            factorial = 1;
        }
        if (numero > 0) {
            for (int i = 1; i <= numero; i++) {
                factorial = factorial * i;
            }
        }
        System.out.println("El factorial es: "+factorial);
        
    }

}
