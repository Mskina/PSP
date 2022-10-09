/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileejemplo2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

/**
 *
 * @author mskin
 */
public class FileEjemplo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Path path = Paths.get("C:\\Users\\mskin\\Desktop\\prueba");
        try {
            if (Files.exists(path)) {
                Files.delete(path);
            } else {
                Files.createDirectory(path);
            }
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }

}
