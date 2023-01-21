package Ejercicio1;

import java.io.*;
import java.util.Scanner;

public class Ej1_Principal {
    public static void main(String[] args) {

        File directorio = new File(".\\out\\production\\EXAMEN_T1_2223");
        File outputFile = new File(".\\src\\Ejercicio1\\outputFile.txt");

        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio1.OrdenarNumeros");
        pb.directory(directorio);
        pb.redirectOutput(ProcessBuilder.Redirect.to(outputFile));

        try {
            Process p = pb.start();
            BufferedReader bis = new BufferedReader(new InputStreamReader(p.getInputStream()));
            PrintStream ps = new PrintStream(p.getOutputStream());

            Scanner sc = new Scanner(System.in);
            int numLeido;
            do {
                System.out.println("Introduce números enteros (-999 para salir)");
                numLeido = sc.nextInt();
                ps.println(numLeido);
                ps.flush();
            } while (numLeido != -999);

            System.out.println("PROCESO TERMINADO");

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
