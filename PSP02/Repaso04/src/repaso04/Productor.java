/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso04;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Productor extends Thread {

    private Caja caja;
    //private String texto = "Este es el texto.";
    private String path;

    public Productor(Caja caja, String path) {
        this.caja = caja;
        this.path = path;
    }

    @Override
    public void run() {
        
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(this.path));
            
            int c;
            while( (c = isr.read() ) != -1 ) {
                caja.guardarCaracter((char) c);
            }
        } catch (IOException ex) {
            //
        }
        
        
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(this.path));
//            
//            String line;
//            while( (line = br.readLine() ) != null ) {
//                caja.guardarLinea(line);
//            }
//        } catch (IOException ex) {
//            //
//        }
    }

}
