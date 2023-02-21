/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol3_ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Productor extends Thread {
    
    private Caracteres caracteres;
    private String nombreFichero;

    public Productor(Caracteres caracteres, String nombreFichero) {
        this.caracteres = caracteres;
        this.nombreFichero = nombreFichero;
    }

    public void run() {
        FileReader fr = null;
        try {
            // Creo el fichero
            File fichero = new File(nombreFichero);
            // Creo el lector
            fr = new FileReader(fichero);
            // Creo el buffer
            BufferedReader br = new BufferedReader(fr);
            
            int c = 0;
            
            // Lectura caracter a caracter
            while ((c = br.read()) != -1) // Leemos caracter a caracter
            {
                char caracter = (char) c; // Convertimos int a char
                caracteres.guardarCaracter(caracter);
            }
            caracteres.guardarCaracter((char)-1);
        } catch (IOException ex) {
            System.out.println("Error al leer el fichero");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fileReader");
            }
        }

    }

}
