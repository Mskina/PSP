/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Factorial extends Thread {

    private int numero;
    private int resultado;

    public Factorial(int numero) {
        this.numero = numero;
    }

    public void run() {
        System.out.println("Empieza el proceso. Cálculo del factorial de: " + numero);
        int factorial = 1;
        if (numero == 0) {
            factorial = 1;
        }
        if (numero > 0) {
            for (int i = 1; i <= numero; i++) {
                factorial = factorial * i;
            }
        }        
        resultado = factorial;
        System.out.println("Fin del proceso. El factorial de " + numero + " es: " + factorial);
    }

    public int getResultado() {
        return resultado;
    }

    public int getNumero() {
        return numero;
    }
}
