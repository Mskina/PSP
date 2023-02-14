/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol2_ejercicio2;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Contador {

//    private Object nameLock = new Object();
//    private String name;
    private int valor;

    public void incrementa() {
        synchronized (this) {
            valor++;
        }
    }

    public void decrementa() {
        synchronized (this) {
            valor--;
        }
    }

//    public void setName(String name) {
//        synchronized (nameLock) {
//            this.name = name;
//            // agregar al histórico...
//        }
//    }
    public int getValor() {
        return valor;
    }
}

//// CON CLASE LOCK (java.util.concurrent)
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class Contador {
//    
//    private Lock lock;
//    private int valor;
//
//    public Contador() {
//        this.lock = new ReentrantLock();
//    }
//    
//    public void incrementa() {
//        lock.lock();
//        try {
//            valor++;
//        } finally {
//            lock.unlock();
//        }
//    }
//    
//    public void decrementa() {
//        lock.lock();
//        try {
//            valor--;
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public int getValor() {
//        return valor;
//    }
//}
