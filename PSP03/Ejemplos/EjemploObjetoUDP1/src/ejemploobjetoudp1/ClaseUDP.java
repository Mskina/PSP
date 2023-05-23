/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploobjetoudp1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class ClaseUDP {

    /**
     * Para convertir un objeto Persona a un array de bytes
     */
    public void enviar() throws Exception {
        Persona persona = new Persona("Maria", 22);

        // CONVERTIMOS OBJETO A BYTES
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bs);

        out.writeObject(persona);//escribir objeto Persona en el stream

        out.close(); //cerrar stream
        byte[] bytes = bs.toByteArray(); // objeto en bytes
    }

    public void recibir() throws Exception {

        DatagramSocket socket = new DatagramSocket();
        
        // RECIBO DATAGRAMA
        byte[] recibidos = new byte[1024];
        DatagramPacket paqRecibido = new DatagramPacket(recibidos, recibidos.length);
        socket.receive(paqRecibido);//recibo el datagrama
        
        // CONVERTIMOS BYTES A OBJETO
        ByteArrayInputStream bais = new ByteArrayInputStream(recibidos);
        ObjectInputStream in = new ObjectInputStream(bais);
        
        Persona persona = (Persona) in.readObject();//obtengo objeto
        in.close();

    }

}
