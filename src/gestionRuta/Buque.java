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
    
    // El spread operator en el parámetro devuelve un array del mismo tipo (Contenedor[])
    // de n número de elementos
    public void addContenedor(Contenedor ... c) {
        
        contenedores.addAll(Arrays.asList(c));
        
    }
    
    public Puerto getPuertoActual() {
        return puertoActual;
    }
    
    public void llegarAPuerto(Puerto p) {
        System.out.println("El buque " + getNombre() + " está llegando al puerto " + p.getNombre() + " ...");
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
    
    // El spread operator en el parámetro devuelve un array del mismo tipo (Contenedor[])
    // de n número de elementos
    public void descargarContenedores(Contenedor ... c) {
        
    }
    
    // El spread operator en el parámetro devuelve un array del mismo tipo (Contenedor[])
    // de n número de elementos
    public void cargarContenedores(Contenedor ... c) {
        
        
    }
}
