/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol2_ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol2_Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        long tiempoInicio;
        long tiempoFin;
        long tiempoTotal;        
        
        // SECUENCIAL 
        
        tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < args.length; i++) {
            File file = new File(args[i]);
            int charCount = contarCaracteres(file);
            System.out.println("El archivo " +file.getAbsolutePath()+ " tiene " + charCount + " caracteres.");
        }
        
        tiempoFin = System.currentTimeMillis();
        
        tiempoTotal = tiempoFin - tiempoInicio;
        
        System.out.println("El proceso secuencial ha tardado " + tiempoTotal + " milisegundos.");

        // POR HILOS      
                
        tiempoInicio = System.currentTimeMillis();
        
        ContarThread[] hilos = new ContarThread[args.length];
        
        for (int i = 0; i < args.length; i++) {
            hilos[i] = new ContarThread(new File(args[i]));
        }

        for (int i = 0; i < args.length; i++) {
            hilos[i].start();
        }

        for (int i = 0; i < args.length; i++) {
            hilos[i].join();
        }

        tiempoFin = System.currentTimeMillis();
        tiempoTotal = tiempoFin - tiempoInicio;

        System.out.println("El proceso por hilos ha tardado " + tiempoTotal + " milisegundos.");
    }

    private static int contarCaracteres(File file) {
        int charCount = 0;

        try (
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader input = new InputStreamReader(fis);
                BufferedReader reader = new BufferedReader(input)) {

            String data;
            while ((data = reader.readLine()) != null) {
                charCount += data.length();
            }
        } catch (IOException ex) {
            charCount = -1;
        }

        return charCount;
    }

}
