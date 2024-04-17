package agentes;

import gestionRuta.Buque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Fran <6W>
 */

public class Naviera {
    
    final private String nombre;
    List<Buque> buques;
    
    public Naviera(String n) {
        nombre = n;
        buques = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void addBuque(Buque ... b) {
        buques.addAll(Arrays.asList(b));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        buques.forEach(e -> sb.append(e.toString()));
        
        String res = "Nombre de la naviera: " + getNombre() +
                             "\nBuques de la naviera\n" + sb.toString();
        
        return res;
    }
}
