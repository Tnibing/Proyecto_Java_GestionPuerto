package controladoresEventos;

import agentes.Buque;
import cargas.Contenedor;
import rutas.Puerto;
import rutas.Ruta;
import gui.GUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
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

    private Ruta ruta = new Ruta("Ruta de comercio Mediterránea", p1, p2, p3, p4, p5, p6);

    private Buque cinzia = new Buque("CINZIA A", ruta);
    private Buque maerskNP = new Buque("MAERSK NEWPORT", ruta);
    private Buque bomar = new Buque("BOMAR RESOLVE", ruta);

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

                    gestionBuques(cinzia, 1000);

                }
            });

            // bucle del buque de Maersk
            HiloBuqueMaersk = new Thread(() -> {

                enRuta = true;

                gestionBuques(maerskNP, 2600);

            });

            // bucle del buque de CMA
            HiloBuqueCMA = new Thread(new Runnable() {

                @Override
                public void run() {

                    enRuta = true;

                    gestionBuques(bomar, 5300);

                }
            });

            // Se inician los 3 hilos
            HiloBuqueArkas.start();
            HiloBuqueMaersk.start();
            HiloBuqueCMA.start();

        } else {

            // Si los buques ya están de ruta, boolean a false para que paren
            enRuta = false;

            // Se espera a que todos los hilos acaben la ejecución de la iteración actual
            try {
                HiloBuqueArkas.join();
                HiloBuqueMaersk.join();
                HiloBuqueCMA.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(EventoBotonComenzarPararRuta.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Se informa en la interfaz gráfica de que ha ruta ha sido detenida
            texto.append("\nRuta DETENIDA...\n");
        }
    }

    private void gestionBuques(Buque b, int esperar) {

        texto.append("El buque " + b.getNombre() + " de la naviera " + b.getNombreNaviera() + " comienza la ruta en el puerto de " + b.getPuertoActual().getNombre() + ".\n");

        while (enRuta) {

            try {
                Thread.sleep(esperar);
            } catch (InterruptedException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Descarga de contenedores
            List<Contenedor> contenedoresBuque = b.getContenedores();

            int contenedoresDescargados = 0;

            for (Contenedor c : contenedoresBuque) {

                if (c.getDestino() == b.getPuertoActual()) {

                    b.getPuertoActual().addContenedores(c);
                    b.descargarContenedores(c);
                    contenedoresDescargados++;
                }

            }

            texto.append("\nEl buque " + b.getNombre() + " ha DESCARGADO " + contenedoresDescargados + " contenedores en el puerto de " + b.getPuertoActual().getNombre() + ".\n");
            // Fin descarga contenedores

            // Carga contenedores
            List<Contenedor> contenedores = b.getPuertoActual().getContenedores();

            for (Contenedor c : contenedores) {

                if (c.getNaviera().getNombre().equals(b.getNombreNaviera()) && b.getContenedores().size() < b.getCapacidad()) {
                    b.addContenedor(c);
                    b.getPuertoActual().cargarContenedores(c);
                }

            }

            int puertoActual = b.getRuta().getPuertos().indexOf(b.getPuertoActual());
            int puertoDestino;

            if (puertoActual < b.getRuta().getPuertos().size() - 1) {
                puertoDestino = puertoActual + 1;
            } else {
                puertoDestino = 0;
            }

            texto.append("El buque " + b.getNombre() + " ha CARGADO " + b.getContenedores().size() + " contenedores en el puerto de " + b.getPuertoActual().getNombre() + ".\n"
                    + "Siguiente destino:\n" + b.getRuta().getPuertos().get(puertoDestino).toString() + "\n");

            cinzia.setPuertoActual(b.getRuta().getPuertos().get(puertoDestino));
            // Fin carga contenedores
        }
    }
}
