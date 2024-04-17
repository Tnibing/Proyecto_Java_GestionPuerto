package agentes;

import gestionRuta.Buque;
import gestionRuta.Puerto;
import gestionRuta.Ruta;

/**
 *
 * @author Fran <6W>
 */

public class Main {
    public static void main(String[] args) {
        
        Naviera nav1 = new Naviera("Arkas");
        Naviera nav2 = new Naviera("Maersk");
        Naviera nav3 = new Naviera("CMA");
        
        Puerto p1 = new Puerto("Valencia", "Espa�a");
        Puerto p2 = new Puerto("Castell�n", "Espa�a");
        Puerto p3 = new Puerto("Barcelona", "Espa�a");
        Puerto p4 = new Puerto("Pireo", "Grecia");
        Puerto p5 = new Puerto("Estambul", "Turqu�a");
        Puerto p6 = new Puerto("Yarimca", "Turqu�a");
        
        Ruta rutaMediterraneo = new Ruta("Ruta de comercio Mediterr�nea.");
        
        Buque buque1 = new Buque("CINZIA A", rutaMediterraneo);
        Buque buque2 = new Buque("MAERSK NEWPORT", rutaMediterraneo);
        Buque buque3 = new Buque("BOMAR RESOLVE", rutaMediterraneo);

        rutaMediterraneo.addPuerto(p1, p2, p3, p4, p5, p6);
        
        nav1.addBuque(buque1);
        nav2.addBuque(buque2);
        nav3.addBuque(buque3);
        
        new GUI_TEST();
    }
}
