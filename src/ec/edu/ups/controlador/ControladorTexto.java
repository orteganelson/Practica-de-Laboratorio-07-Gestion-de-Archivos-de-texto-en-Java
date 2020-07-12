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
 *
 * @author Usuario
 */
public class ControladorTexto {
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
