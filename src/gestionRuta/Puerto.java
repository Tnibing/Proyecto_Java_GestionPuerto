package gestionRuta;

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
        
        // El nombre de carga actúa como identificador universal del puerto, son las 2 primeras letras del país más
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
    
    public void pedirAtracar(Buque b) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Recibiendo petición del buque ").append(b.getNombre()).append(" pidiendo permiso al puerto ").append(getNombre()).append(" para atracar.");
    }
    
    @Override
    public String toString() {
        String res = "Nombre del puerto: " + getNombre() + "\nPaís: " + getPais() +  "Nombre de carga: " + getNombreDeCarga() + "\n\n";
        
        return res;
    }
}
