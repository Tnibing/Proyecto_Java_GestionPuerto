package controladoresEventos;

import agentes.Buque;
import gestionRuta.Puerto;
import gestionRuta.Ruta;
import gui.GUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Fran <6W>
 */

public class EventoBotonComenzarPararRuta implements ActionListener {

    // Datos
    private Puerto p1 = new Puerto("Valencia", "España");
    private Puerto p2 = new Puerto("Castellón", "España");
    private Puerto p3 = new Puerto("Barcelona", "España");
    private Puerto p4 = new Puerto("Pireo", "Grecia");
    private Puerto p5 = new Puerto("Estambul", "Turquía");
    private Puerto p6 = new Puerto("Yarimca", "Turquía");

    private Ruta ruta1 = new Ruta("Ruta de comercio Mediterránea", p1, p2, p3, p4, p5, p6);
    private Ruta ruta2 = new Ruta("Ruta de comercio Mediterránea", p1, p2, p3, p4, p5, p6);
    private Ruta ruta3 = new Ruta("Ruta de comercio Mediterránea", p1, p2, p3, p4, p5, p6);

    private Buque cinzia = new Buque("CINZIA A", ruta1);
    private Buque maerskNP = new Buque("MAERSK NEWPORT", ruta2);
    private Buque bomar = new Buque("BOMAR RESOLVE", ruta3);
    
    private JTextArea texto;
    private Boolean enRuta = false;

    // Hilos, 1 para cada barco
    private Thread HiloBuqueArkas;
    private Thread HiloBuqueMaersk;
    private Thread HiloBuqueCMA;

    // El JTextArea que se va a modificar se pasa como parámetro del constructor
    public EventoBotonComenzarPararRuta(JTextArea texto) {
        this.texto = texto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Si los buques NO están en ruta
        if (!enRuta) {

            // bucle del buque de Arkas
            HiloBuqueArkas = new Thread(new Runnable() {

                @Override
                public void run() {

                     enRuta = true;

                    texto.append("El buque " + cinzia.getNombre() + " de la naviera " + cinzia.getNombreNaviera() + " comienza la ruta en el puerto de " + cinzia.getPuertoActual().getNombre() + ".\n");
                    
                    while (enRuta) {

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        texto.append("Soy el buque de ARKAS\n");
                        
                    }
                }
            });

            
            // bucle del buque de Maersk
            HiloBuqueMaersk = new Thread(() -> {
                
                 enRuta = true;
                
                texto.append("El buque " + maerskNP.getNombre() + " de la naviera " + maerskNP.getNombreNaviera() + " comienza la ruta en el puerto de " + maerskNP.getPuertoActual().getNombre() + ".\n");
                
                while (enRuta) {
                    
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    texto.append("Soy el buque de MAERSK\n");
                    
                }
            });

            // bucle del buque de CMA
            HiloBuqueCMA = new Thread(new Runnable() {

                @Override
                public void run() {
                    
                     enRuta = true;

                    texto.append("El buque " + bomar.getNombre() + " de la naviera " + bomar.getNombreNaviera() + " comienza la ruta en el puerto de " + bomar.getPuertoActual().getNombre() + ".\n");
                    
                    while (enRuta) {

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        texto.append("Soy el buque de CMA\n");

                    }
                }
            });
            
            // Se inician los 3 hilos
            HiloBuqueArkas.start();
            HiloBuqueMaersk.start();
            HiloBuqueCMA.start();

        } else {
            
            // Si los buques ya están de ruta, boolean a false
            enRuta = false;
            
            // Se espera a que todos acaben la ejecución de la iteración actual
            try {
                HiloBuqueArkas.join();
                HiloBuqueMaersk.join();
                HiloBuqueCMA.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(EventoBotonComenzarPararRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Se informa de que ha ruta ha sido detenida
            texto.append("Ruta DETENIDA...\n");

        }
    }
}
