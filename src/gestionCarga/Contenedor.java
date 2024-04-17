package gestionCarga;

import agentes.Naviera;
import gestionRuta.Puerto;

/**
 *
 * @author Fran <6W>
 */

public class Contenedor {
    
    private Naviera nav;
    private String matricula;
    private String tamanyo;
    private int pesoVacio;
    private int pesoMax;
    private Puerto puertoDestino;
    
    public Contenedor(Naviera nav, String t, Puerto destino) {
        this.nav = nav;
        tamanyo = t;
        puertoDestino = destino;
        generarMatricula();
        generarPesos();
    }
    
    private void generarMatricula() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(nav.getNombre().toUpperCase()).append("U").append((int) (Math.random() * 10000000));
        
        matricula = sb.toString();
    }
    
    private void generarPesos() {
        
        if (tamanyo.equalsIgnoreCase("20 pies")) {
            pesoVacio = 2200;
            pesoMax = 28500;
            
        } else if (tamanyo.equalsIgnoreCase("40 pies")) {
            pesoVacio = 3800;
            pesoMax = 30000;
        }
    }
    
    
}
