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
    private List<Character> abecedario;
    private Map<Character, Character> diccionario;
    
    public ControladorTexto() {
        abecedario = new ArrayList<>();
        diccionario = new HashMap<>();
        diccionario = crearDiccionario();
    }
    
    public Map<Character, Character> crearDiccionario() {
        //Declaracion de nuevas varibles
        String abecedario = "abcdefghijklmnñopqrstuvwxyz";
        String abecedario2 = "nopqrstuvwxyza☼bcdefghijklm";
        String numeros = "0123456789";
        String numeros2="♫►◄↕¶§▬↨↑↓♪";        
        String espacio = " ";


        for (int i = 0; i < abecedario.length(); i++) {
            diccionario.put(abecedario.charAt(i), abecedario2.charAt(i));
        }
        
        for (int i = 0; i < numeros.length()-1; i++) {
            diccionario.put(numeros.charAt(i), numeros2.charAt(i));
        }
        diccionario.put(espacio.charAt(0), numeros2.charAt(10));
        return diccionario;
    }
    
    public void encriptar(String rutaAbsoluta, String texto) {
        String aux = "";
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            String le1 = String.valueOf(letra);
            for (Map.Entry<Character, Character> letra2 : diccionario.entrySet()) {
                String le2 = String.valueOf(letra2.getKey());
                if (le1.equalsIgnoreCase(le2)) {
                    
                    if (Character.isUpperCase(letra)) {
                        aux = aux.concat(String.valueOf(letra2.getValue()).toUpperCase());
                        System.out.println(aux);
                    } else {
                        aux = aux.concat(String.valueOf(letra2.getValue()));
                        System.out.println(aux);
                    }
                }
            }
        }
        try {

            FileWriter archivoEscritura = new FileWriter(rutaAbsoluta, false);           

            BufferedWriter esc= new BufferedWriter(archivoEscritura);

            esc.append(aux);
            esc.close();
            archivoEscritura.close();

        } catch (FileNotFoundException e1) {
            System.out.println("Ruta no encontrada");
        } catch (IOException e2) {
            System.out.println("Error de escritura");
        } catch (Exception e3) {
            System.out.println("Error");
        }
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
