package agentes;

import cargas.Contenedor;
import rutas.Puerto;
import rutas.Ruta;
import java.util.ArrayList;
import java.util.List;

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
    
    public Puerto getPuertoActual() {
        return puertoInicial;
    }
    
    public void addContenedor(Contenedor c) {
        contenedoresCargados.add(c);
    }
    
    public void setPuertoActual(Puerto p) {
        puertoInicial = p;
    }
    
    // TO DO
    public void descargarContenedores(Contenedor  c) {
        contenedoresCargados.remove(c);
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
