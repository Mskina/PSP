/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bol1_ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Bol1_Ejercicio2 {

    /**
     * Implementa un programa que recoja de teclado una URL (con el formato
     * http://www.sitioweb.dom) y abra una conexión a dicho sitio Web, mostrando
     * por pantalla el código HTML de su página inicial.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Escribe una URL o IP: ");
        // https://one.one.one.one/
        String consulta = scan.nextLine();
        
        URL url = null;
        try {
            url = new URL(consulta);
        } catch (MalformedURLException e) {
            System.out.println("Error en la URL.");
        }
        
        BufferedReader in;
        try {
            InputStream inputStream = url.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
