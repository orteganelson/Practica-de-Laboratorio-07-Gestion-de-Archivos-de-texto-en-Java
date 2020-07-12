/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * Esta clase contiene los métodos necesarias para el usuario de este
 * programa pueda utilizarlo de una manera correcta y fácil, asi como los 
 * metodos para controlar textosy que el usuario pueda manipular el programa con
 * restricciones.
 *
 * @author Nelson Ortega
 * @version 11.3
 * @author Anahi Cabrera
 * @version 8.2
 */
public class ControladorTexto {
     /**
     * Declaracion de atributos
     */
    private String ruta;
    private File fichero;
    
    public ControladorTexto() {
        
    }
    
    public boolean comprobarRuta(String ruta) {
        fichero = new File(ruta);

        if (fichero.exists()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean comprobar(String ruta, String nombre) {
        nombre = nombre.concat(".txt");
        
        fichero = new File(ruta + File.separator + nombre);

        if (fichero.exists()) {
            return true;
            
        } else {
            return false;
            
        }
    }
    
    public String crearFichero(String ruta, String nombre) {

        nombre = nombre.concat(".txt");
        fichero = new File(ruta + File.separator + nombre);

        try {
            fichero.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return fichero.getAbsolutePath();
    }
    
    
    
}
