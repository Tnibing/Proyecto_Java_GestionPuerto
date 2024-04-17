package gestionRuta;

import gestionCarga.Buque;

/**
 *
 * @author Fran <6W>
 */

public class Puerto {
    
    private final String nombrePuerto;
    private final String paisPuerto;
    private final String nombreDeCargaPuerto;
    
    public Puerto(String nombre, String pais) {
        nombrePuerto = nombre;
        paisPuerto = pais;
        
        // El nombre de carga act�a como identificador universal del puerto, son las 2 primeras letras del pa�s m�s
        // las 3 primeras letras del nombre del puerto.
        nombreDeCargaPuerto = paisPuerto.substring(0, 2).toUpperCase().concat(nombrePuerto.substring(0, 3));
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
    
    // TODO, hacer la clase buque para que recibir y zarpar sean interesantes
    public void pedirAtracar(Buque b) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Recibiendo petici�n del buque ").append(b.getNombre()).append(" pidiendo permiso al puerto ").append(getNombre()).append(" para atracar.");
    }
}
