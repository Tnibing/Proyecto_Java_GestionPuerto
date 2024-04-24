package cargas;

import agentes.Naviera;
import rutas.Puerto;

/**
 *
 * @author Fran <6W>
 */

public class Contenedor {
    
    private Naviera nav;
    private String matricula;
    private Puerto puertoOrigen;
    private Puerto puertoDestino;
    
    public Contenedor(Naviera nav, Puerto origen, Puerto destino) {
        this.nav = nav;
        puertoOrigen = origen;
        puertoDestino = destino;
        generarMatricula();
    }
    
    private void generarMatricula() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(nav.getNombre().toUpperCase()).append("U").append((int) (Math.random() * 10000000));
        
        matricula = sb.toString();
    }
    
    public Naviera getNaviera() {
        return nav;
    }
    
    public Puerto getOrigen() {
        return puertoOrigen;
    }
    
    public Puerto getDestino() {
        return puertoDestino;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    @Override
    public String toString() {
        
        String res = "Naviera del contenedor: " + getNaviera().getNombre() + "\nPuero de origen: " + puertoOrigen.getNombre() + "\nPuerdo de destino: " + puertoDestino.getNombre() + "\nMatrícula del contenedor: " + getMatricula() + "\n";
        
        return res;
    }
}
