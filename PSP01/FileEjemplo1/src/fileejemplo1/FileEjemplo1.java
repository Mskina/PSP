package fileejemplo1;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class FileEjemplo1 {

    public static void main(String args[]) {
        Path path = Paths.get("C:\\Users\\mskin\\FileEjemplo\\hola.txt");
        System.out.println(" path = " + path);
        System.out.println(" exists = " + Files.exists(path));
        System.out.println(" readable = " + Files.isReadable(path));
        System.out.println(" writeable = " + Files.isWritable(path));
        System.out.println(" executeable = " + Files.isExecutable(path));
    }
}
