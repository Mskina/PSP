/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad2;

import java.io.Serializable;

/**
 *
 * @author Iván Estévez Sabucedo
 */
public class Fichero implements Serializable {

    private String nombre;
    private String descri;

    public Fichero(String nombre, String descri) {
        this.nombre = nombre;
        this.descri = descri;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescri() {
        return descri;
    }
    
    

}
