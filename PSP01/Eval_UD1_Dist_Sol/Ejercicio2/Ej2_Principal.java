package Ejercicio2;

import java.io.*;

public class Ej2_Principal {
    public static void main(String[] args) throws IOException {
        File directorio = new File(".\\out\\production\\EXAMEN_T1_2223");
        ProcessBuilder pb = new ProcessBuilder("java", "Ejercicio2.Ej2_Subproceso", "2", "5", "hola");

        pb.directory(directorio);
        Process p = pb.start();

        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null) {
                System.out.println("ERROR >" + liner);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // COMPROBACION DE la salida del programa
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
            switch (exitVal) {
                case (0):
                    System.out.println("FINAL CORRECTO...");
                    break;
                case (-1):
                    System.out.println("NO SE HAN ENVIADO PARÁMETROS...");
                    break;
                case (1):
                    System.out.println("EXISTEN PARÁMETROS NO NUMERICOS...");
                    break;
                case (2):
                    System.out.println("MAS DE LA MITAD DE LOS ARGUMENTOS ES SUPERIOR A LA MEDIA ARITMÉTICA");
                    break;
                case (3):
                    System.out.println("MENOS DE LA MITAD DE LOS ARGUMENTOS ES SUPERIOR A LA MEDIA ARITMÉTICA");
                    break;
            }
            try {
                BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String liner;
                while ((liner = is.readLine()) != null) {
                    System.out.println(liner);
                }
            } catch (Exception e) {
                e.getStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
