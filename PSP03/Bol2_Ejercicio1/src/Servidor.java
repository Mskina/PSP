import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    final static String FIN = "*";

    /**
     * Utilizando sockets TCP, implementar un programa servidor que inicialice un array de 5 objetos de tipo Profesor.
     * El servidor aceptará conexiones de clientes en un bucle infinito. Cada vez qye se conecte un cliente, el servidor
     * le asignará un id, que empezará en 1 e irá incrementándose cada vez que se conecte un nuevo cliente. El servidor
     * recibirá del cliente un idProfesor y le devolverá el objeto Profesor asociado.
     *
     * @param args
     */
    public static void main(String[] args) {

        /**
         * Creo las Asignaturas
         */
        Asignatura asignatura1 = new Asignatura(1, "Asignatura 1");
        Asignatura asignatura2 = new Asignatura(2, "Asignatura 2");
        Asignatura asignatura3 = new Asignatura(3, "Asignatura 3");
        Asignatura asignatura4 = new Asignatura(4, "Asignatura 4");

        Asignatura[] asignaturasProfesor1 = new Asignatura[2];
        asignaturasProfesor1[0] = asignatura2;
        asignaturasProfesor1[1] = asignatura4;

        Asignatura[] asignaturasProfesor2 = new Asignatura[2];
        asignaturasProfesor2[0] = asignatura1;
        asignaturasProfesor2[1] = asignatura2;

        Asignatura[] asignaturasProfesor3 = new Asignatura[2];
        asignaturasProfesor3[0] = asignatura3;
        asignaturasProfesor3[1] = asignatura4;

        Asignatura[] asignaturasProfesor4 = new Asignatura[2];
        asignaturasProfesor4[0] = asignatura1;
        asignaturasProfesor4[1] = asignatura4;

        Asignatura[] asignaturasProfesor5 = new Asignatura[2];
        asignaturasProfesor5[0] = asignatura2;
        asignaturasProfesor5[1] = asignatura3;

        /**
         * Creo las especialidades
         */
        Especialidad especialidad1 = new Especialidad(1, "Especialidad 1");
        Especialidad especialidad2 = new Especialidad(2, "Especialidad 2");
        Especialidad especialidad3 = new Especialidad(3, "Especialidad 3");
        Especialidad especialidad4 = new Especialidad(4, "Especialidad 4");
        Especialidad especialidad5 = new Especialidad(4, "Especialidad 5");

        // Error, la especialidad es única
//        Especialidad[] especialidadesProfesor1 = new Especialidad[2];
//        especialidadesProfesor1[0] = especialidad2;
//        especialidadesProfesor1[1] = especialidad4;
//
//        Especialidad[] especialidadesProfesor2 = new Especialidad[2];
//        especialidadesProfesor2[0] = especialidad1;
//        especialidadesProfesor2[1] = especialidad2;
//
//        Especialidad[] especialidadesProfesor3 = new Especialidad[2];
//        especialidadesProfesor3[0] = especialidad3;
//        especialidadesProfesor3[1] = especialidad4;
//
//        Especialidad[] especialidadesProfesor4 = new Especialidad[2];
//        especialidadesProfesor4[0] = especialidad1;
//        especialidadesProfesor4[1] = especialidad4;
//
//        Especialidad[] especialidadesProfesor5 = new Especialidad[2];
//        especialidadesProfesor5[0] = especialidad2;
//        especialidadesProfesor5[1] = especialidad3;

        /**
         * Creo los profesores
         */

        Profesor profesor1 = new Profesor(1, "Profesor 1", asignaturasProfesor1, especialidad1);
        Profesor profesor2 = new Profesor(2, "Profesor 2", asignaturasProfesor2, especialidad2);
        Profesor profesor3 = new Profesor(3, "Profesor 3", asignaturasProfesor3, especialidad3);
        Profesor profesor4 = new Profesor(4, "Profesor 4", asignaturasProfesor4, especialidad4);
        Profesor profesor5 = new Profesor(5, "Profesor 5", asignaturasProfesor5, especialidad5);

        Profesor[] profesores = new Profesor[5];
        profesores[0] = profesor1;
        profesores[1] = profesor2;
        profesores[2] = profesor3;
        profesores[3] = profesor4;
        profesores[4] = profesor5;

        int puerto = 6000;

        try {
            System.out.println("-- Iniciado socket servidor --");
            // Iniciamos el socket servidor
            ServerSocket servidor = new ServerSocket(puerto);

            // Esperamos al cliente
            Socket cliente = servidor.accept();
            System.out.println(">> Cliente conectado.");

            // Creo un flujo de salida
            ObjectOutputStream flujoSalida = new ObjectOutputStream(cliente.getOutputStream());

            // Se crea un flujo de entrada desde el cliente
            InputStreamReader isr = new InputStreamReader(cliente.getInputStream());
            BufferedReader flujoEntrada = new BufferedReader(isr);

            // Se espera por la cadena del cliente
            String cadena = flujoEntrada.readLine();
            System.out.println("Recibido de cliente: " + cadena);

            while (!cadena.equals(FIN)) {

                int idProfesorRecibido = Integer.parseInt(cadena);
                boolean profesorEncontrado = false;

                for (Profesor p : profesores) {
                    if (p.getIdProfesor() == idProfesorRecibido) {
                        profesorEncontrado = true;
                        flujoSalida.writeObject(p);
                        System.out.println("Enviando: " + p);
                    }
                }

                if (!profesorEncontrado) {
                    flujoSalida.writeObject(new Profesor());
                    System.out.println("Enviado un profesor vacío.");
                }

                cadena = flujoEntrada.readLine();
                System.out.println("Recibido de cliente: " + cadena);
            }

            flujoSalida.close();
            flujoEntrada.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
