package gestionRuta;

import agentes.Naviera;
import gestionCarga.Contenedor;
import java.util.ArrayList;
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
    private List<Contenedor> contenedoresCargados;
    private Puerto puertoInicial;
    private Naviera navi;
    
    public Buque(String n, Ruta r) {
        nombreBuque = n;
        ruta = r;
        capacidadContenedores = 1600;
        contenedoresCargados = new ArrayList<>();
        
        if (nombreBuque.equalsIgnoreCase("CINZIA A")) {
            
            puertoInicial = new Puerto("Yarimca", "Turquía");
            
            navi = new Naviera("ARKAS");
        }
        
        else if (nombreBuque.equalsIgnoreCase("MAERSK NEWPORT")) {
            
            puertoInicial = new Puerto("Valencia", "España");
            
            navi = new Naviera("MAERSK");

        }
        
        else if (nombreBuque.equalsIgnoreCase("BOMAR RESOLVE")) {
            
            puertoInicial = new Puerto("Pireo", "Grecia");

            navi = new Naviera("CMA");
        }
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
        return contenedoresCargados;
    }
    
    public String getNombreNaviera() {
        return navi.toString();
    }
    
    // El spread operator en el parámetro devuelve un array del mismo tipo (Contenedor[])
    // de n número de elementos
    public void addContenedor(Contenedor ... c) {
        
        for (Contenedor conte : c) {
            
            if(contenedoresCargados.size() < capacidadContenedores)
                contenedoresCargados.add(conte);
            
        }
        
    }
    
    public Puerto getPuertoActual() {
        return puertoInicial;
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
            
            puertoInicial = p;
            
            System.out.println("Puerto actual: " + puertoInicial.getNombre());
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
        
        contenedoresCargados.forEach(e -> listaCont.append(e).append("\n"));
        
        String res = "Nombre del buque: " + getNombre() + 
                             "\nRUTA\n" + getRuta().toString() + 
                             "\nCapacidad total de contenedores: " + getCapacidad() + 
                             "\nPuerto actual: " + puertoInicial.toString() + 
                             "\nCONTENEDORES A BORDO\n" + listaCont.toString();
        
        return res;
    }
}
