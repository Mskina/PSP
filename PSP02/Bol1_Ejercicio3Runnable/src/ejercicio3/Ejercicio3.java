/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

/**
 * Hacer un programa que calcule el factorial y un número de la sucesión de
 * Fibonacci. Cada uno de los cálculos tiene que ser realizado por un hilo
 * independiente. Las clases que implementen cada hilo tienen que llamarse
 * Factorial y Fibonacci. Implementar los procesos de 2 maneras diferentes:
 *
 * a) Heredando de la clase Thread
 *
 * b) Implementando la interface Runnable
 *
 * Recuerda que factorial(0)=1 y para todo n>0, factorial(n)=n*factorial(n-1).
 * Recuerda que fib(0)=0, fib(1)=1 y para todo n>1, fib(n)=fib(n-1)+fib(n-2).
 *
 *
 * @author Iván Estévez Sabucedo
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int numero = 5;        
                
        System.out.println("Método Runnable con el número " +String.valueOf(numero));
        
        Factorial f1 = new Factorial(numero);
        Thread hilo1 = new Thread(f1);                     
        hilo1.start();
        
        Fibonacci f2 = new Fibonacci(numero);
        Thread hilo2 = new Thread(f2);        
        hilo2.start();
    }

}
