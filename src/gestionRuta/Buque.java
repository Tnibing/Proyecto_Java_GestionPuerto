package gestionRuta;

import gestionCarga.Contenedor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fran <6W>
 */

public class Buque {
    
    private String nombreBuque;
    private Ruta ruta;
    private int capacidadContenedores;
    private List<Contenedor> contenedores;
    private Puerto puertoActual;
    
    public Buque(String n, Ruta r) {
        nombreBuque = n;
        ruta = r;
        capacidadContenedores = 1600;
        contenedores = new ArrayList<>();
        
        if (nombreBuque.equalsIgnoreCase("CINZIA A"))
            puertoActual = new Puerto("Yarimca", "Turquía");
        
        else if (nombreBuque.equalsIgnoreCase("MAERSK NEWPORT"))
            puertoActual = new Puerto("Valencia", "España");
        
        else if (nombreBuque.equalsIgnoreCase("BOMAR RESOLVE"))
            puertoActual = new Puerto("Pireo", "Grecia");
    }
    
    public String getNombre() {
        return nombreBuque;
    }
    
    public Ruta getRuta() {
        return ruta;
    }
    
    public int getCapacidad() {
        return capacidadContenedores;
    }
    
    public List<Contenedor> getContenedores() {
        return contenedores;
    }
    
    // El spread operator en el parámetro devuelve un array del mismo tipo (Contenedor[])
    // de n número de elementos
    public void addContenedor(Contenedor ... c) {
        contenedores.addAll(Arrays.asList(c));
    }
    
    public Puerto getPuertoActual() {
        return puertoActual;
    }
    
    public void llegarAPuerto(Puerto p) {
        System.out.println("El buque " + getNombre() + " está llegando al puerto " + p.getNombre() + "...");
        p.pedirAtracar(this);
        
        try {
            Thread.sleep(2000);
            
            System.out.println("El buque " + getNombre() + " acaba de atracar.");
            
            System.out.println("Amarrando...");
            
            Thread.sleep(3000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Buque.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            System.out.println("Buque " + getNombre() + " asegurado, listo para carga/descarga de contenedores.");
            
            puertoActual = p;
            
            System.out.println("Puerto actual: " + puertoActual.getNombre());
        }
    }
    
    // TO DO
    public void descargarContenedores(Contenedor ... c) {
        
    }

    // TO DO
    public void cargarContenedores(Contenedor ... c) {
        
    }
    
    @Override
    public String toString() {
        StringBuilder listaCont =  new StringBuilder();
        
        contenedores.forEach(e -> listaCont.append(e).append("\n"));
        
        String res = "Nombre del buque: " + getNombre() + 
                             "\nRUTA\n" + getRuta().toString() + 
                             "\nCapacidad total de contenedores: " + getCapacidad() + 
                             "\nPuerto actual: " + puertoActual.toString() + 
                             "\nCONTENEDORES A BORDO\n" + listaCont.toString();
        
        return res;
    }
}
