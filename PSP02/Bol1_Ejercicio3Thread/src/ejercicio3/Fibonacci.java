/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 * Recuerda que fib(0)=0, fib(1)=1 y para todo n>1, fib(n)=fib(n-1)+fib(n-2)
 *
 * @author Iván Estévez Sabucedo
 */
public class Fibonacci extends Thread {

    int numero;

    public Fibonacci(int numero) {
        this.numero = numero;
    }

    public void run() {
        String fibo = "0, 1";
        int num3 = 0;

        if (numero == 0) {
            fibo = "0";
            num3 = 0;
        }
        if (numero == 1) {
            fibo = "0, 1";
            num3 = 1;
        }
        if (numero > 1) {

            int num1 = 0, num2 = 1;
            int contador = 1;

            while (contador < numero) {
                fibo = fibo.concat(", ");

                num3 = num2 + num1;
                fibo = fibo.concat(String.valueOf(num3));
                num1 = num2;
                num2 = num3;
                contador++;
            }
        }
        System.out.println("La serie es: " + fibo);
        System.out.println("El num fibonacci es " + num3);
    }

}
