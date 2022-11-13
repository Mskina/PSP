/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aleatorios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Escribe un programa Aleatorios que haga lo siguiente:
 *
 * Cree un subproceso que se encargue de generar números aleatorios. Este
 * proceso hijo escribirá en su salida estándar un número aleatorio del 0 al 10
 * cada vez que reciba una petición de ejecución por parte del padre (Cualquier
 * cadena recibida por entrada estándar).
 *
 * El proceso padre lee líneas de la entrada estándar y por cada línea que lea,
 * solicitará al hijo que le envíe un número aleatorio, lo leerá y lo imprimirá
 * en pantalla.
 *
 * Cuando el proceso padre reciba la palabra “fin”, finalizará la ejecución del
 * hijo y procederá a finalizar su ejecución.
 *
 *
 * @author Iván Estévez Sabucedo
 */
public class Aleatorios {

    // Definimos la palabra con la que finalizamos los procesos.
    static final String STOP = "fin";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Definimos la ruta del proceso hijo
        File directorio = new File("..\\AleatoriosHijo\\src\\aleatorioshijo");

        // Instanciamos un ProcessBuilder con la información del proceso que queremos ejecutar
        ProcessBuilder pb = new ProcessBuilder("java", "AleatoriosHijo.java");

        // Indicamos el working directory de dicho proceso
        pb.directory(directorio);

        // Envolvemos todo en un try-catch para controlar excepciones
        try {
            // Iniciamos el proceso hijo
            Process p = pb.start();

            // Creamos el reader para poder obtener la información que nos entrega el proceso hijo
            InputStream is = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            // Creamos el writer para enviarle información al proceso hijo
            OutputStream os = p.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

            // Para evitar confusión con los distintos buffers, usamos la clase Scanner para leer de teclado
            Scanner scan = new Scanner(System.in);
            String texto = scan.nextLine();

            // Bucle en el que leemos desde teclado hasta que coincida con la palabra de finalización
            while (!texto.equals(STOP)) {
                writer.write(texto); //Enviamos el texto
                writer.newLine(); // Enviamos una nueva línea (para que sepa que puede devolver el número)
                writer.flush(); // Vaciamos el buffer

                System.out.println(reader.readLine()); // Leemos la "respuesta" del hijo
                texto = scan.nextLine(); // Esperamos por una nueva escritura en teclado
            }

            //Finalizamos el proceso hijo
            p.destroy();

            // Cerramos los dos buffers
            writer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }
}
