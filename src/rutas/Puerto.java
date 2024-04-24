package rutas;

import agentes.Buque;
import cargas.Contenedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fran <6W>
 */

public class Puerto {
    
    private final String nombrePuerto;
    private final String paisPuerto;
    private final String nombreDeCargaPuerto;
    private List<Contenedor> contenedores;
    
    public Puerto(String nombre, String pais) {
        nombrePuerto = nombre;
        paisPuerto = pais;
        
        // El nombre de carga actúa como identificador universal del puerto, son las 2 primeras letras del país más
        // las 3 primeras letras del nombre del puerto.
        nombreDeCargaPuerto = paisPuerto.substring(0, 2).toUpperCase().concat(nombrePuerto.substring(0, 3));
        
        contenedores = new ArrayList<>();
    }
    
    public String getPais() {
        return paisPuerto;
    }
    
    public String getNombreDeCarga() {
        return nombreDeCargaPuerto;
    }
    
    public String getNombre() {
        return nombrePuerto;
    }
    
    public List<Contenedor> getContenedores() {
        return contenedores;
    }
    
    public void addContenedores(Contenedor c) {
        contenedores.add(c);
    }
    
    public void cargarContenedores(Contenedor c) {
        contenedores.remove(c);
    }
    
    @Override
    public String toString() {
        String res = "Nombre del puerto: " + getNombre() + "\nPaís: " + getPais() +  "\nNombre de carga: " + getNombreDeCarga() + "\n";
        
        return res;
    }
}
