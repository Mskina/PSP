/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplosocketudp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Red Parte 2, páginas 15 a 17.
 *
 * @author Iván Estévez Sabucedo
 */
public class ReceptorUDP {

    public static void main(String[] args) throws Exception {

        /**
         * El siguiente ejemplo utiliza el primer constructor para recibir el
         * mensaje de un datagrama, el mensaje se aloja en bufer.
         *
         * Aquí creamos un datagrama vacío. Luego veremos cómo se recupera la
         * información del mensaje.
         */
        byte[] bufer = new byte[1024];
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);

        /**
         * Con el paquete vacío ya creado, generamos un DatagramSocket.
         * Establezco el puerto 12345 que será por donde me lleguen los
         * paquetes.
         */
        DatagramSocket socket = new DatagramSocket(12345);
        socket.receive(recibo);//recibo datagrama

        /**
         * Una vez ejecutamos socket.receive(), procedemos a recuperar los datos
         * del paquete recibido.
         *
         */
        // Obtengo la longitud (número de bytes) del mensaje
        int bytesRec = recibo.getLength();

        // Creo una String con el contenido del paquete recibido
        String paquete = new String(recibo.getData());

        // Muestro dicha String por pantalla
        System.out.println("Paquete original: ");
        System.out.println(paquete);
        System.out.println("Paquete con trim()");
        System.out.println(paquete.trim());

        // Información varia
        System.out.println("Número de Bytes recibidos: " + bytesRec);
        System.out.println("Puerto origen del mensaje: " + recibo.getPort());
        System.out.println("IP de origen : " + recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino del mensaje:" + socket.getLocalPort());

        // Cierro el socket
        socket.close();

    }

}
