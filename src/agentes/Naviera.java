package agentes;

/**
 *
 * @author Fran <6W>
 */

public class Naviera {
    
    final private String nombre;
    
    public Naviera(String n) {
        nombre = n;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        
        return getNombre();
    }
}
