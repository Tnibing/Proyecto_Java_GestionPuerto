package rutas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Fran <6W>
 */

public class Ruta {
    
    private String nombreRuta;
    private List<Puerto> puertos;
    
    public Ruta(String n, Puerto ... p) {
        nombreRuta = n;
        puertos = new ArrayList<>();
        
        for (Puerto puertoVector : p) {
            puertos.add(puertoVector);
        }
        
    }
    
    public String getNombre() {
        return nombreRuta;
    }
    
    public void addPuerto (Puerto ... p) {
        
        puertos.addAll(Arrays.asList(p));
    }
    
    public List<Puerto> getPuertos() {
        return puertos;
    }
    
    @Override
    public String toString() {
        String res = "Nombre ruta: " + getNombre() + "\nPuertos de la ruta: " + puertos.toString() + "\n\n";
        
        return res;
    }
}
