package agentes;

import gestionCarga.Contenedor;
import gestionRuta.Buque;
import java.util.List;

/**
 *
 * @author Fran <6W>
 */

public class Naviera {
    
    private String nombre;
    List<Contenedor> contenedoresDisponibles;
    List<Contenedor> contenedoresEnUso;
    List<Buque> buques;
    
    public Naviera(String n) {
        nombre = n;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void generarContenedores() {
        
        int i = 0;
        Contenedor c;
        
        while (i < 15000) {
            
        }
    }
}
