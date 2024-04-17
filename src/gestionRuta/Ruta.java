package gestionRuta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fran <6W>
 */

public class Ruta {
    
    private String nombreRuta;
    private List<Puerto> puertos;
    
    public Ruta(String n) {
        nombreRuta = n;
        puertos = new ArrayList<>();
    }
    
    public void addPuerto (Puerto p) {
        puertos.add(p);
    }
    
    public List<Puerto> getPuertos() {
        return puertos;
    }
}
