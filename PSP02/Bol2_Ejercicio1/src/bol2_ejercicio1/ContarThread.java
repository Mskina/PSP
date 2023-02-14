/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bol2_ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class ContarThread extends Thread {

    private File file;

    public ContarThread(File file) {
        this.file = file;
    }

    @Override
    public void run() {
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

        System.out.println("El archivo " + file.getAbsolutePath() + " tiene " + charCount + " caracteres.");
    }
}
