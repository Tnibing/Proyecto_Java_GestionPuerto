package controladoresEventos;

import agentes.Buque;
import cargas.Contenedor;
import gui.GUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import rutas.Puerto;

/**
 *
 * @author Fran <6W>
 */
public class EventoBotonComenzarPararRuta implements ActionListener {

    // Datos
    private Buque cinzia;
    private Buque maerskNP;
    private Buque bomar;

    private JTextArea texto;
    private Boolean enRuta = false;

    // Hilos, 1 para cada barco
    private Thread HiloBuqueArkas;
    private Thread HiloBuqueMaersk;
    private Thread HiloBuqueCMA;

    // El JTextArea que se va a modificar se pasa como parámetro del constructor
    public EventoBotonComenzarPararRuta(JTextArea texto, Buque cinzia, Buque maerskNP, Buque bomar) {
        this.texto = texto;
        this.cinzia = cinzia;
        this.maerskNP = maerskNP;
        this.bomar = bomar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Hilo que maneja los hilos de los buques para que la interfaz gráfica
        // no se quede colgada al parar la ruta. Cuando se para la ruta, se espera
        // a que los 3 hilos de los barcos acaben su iteración actual
        Thread HiloGeneralBuques = new Thread(() -> {

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
                // usando lambda expression por practicar
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
                texto.append("\nRuta DETENIDA...\n\n");

                // Para que el scroll siga al texto y no se quede arriba
                texto.setCaretPosition(texto.getDocument().getLength());
            }

        });

        HiloGeneralBuques.start();
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

                if (c.getNaviera().getNombre().equals(b.getNombreNaviera()) && b.getContenedores().size() < b.getCapacidad() && !c.getDestino().toString().equals(b.getPuertoActual().toString())) {
                    b.addContenedor(c);
                    b.getPuertoActual().cargarContenedores(c);
                }

            }

            // Saco el índice del puerto actual, a partir de ese índice, saco cuál sería el siguiente puerto de la lista
            int puertoActual = b.getRuta().getPuertos().indexOf(b.getPuertoActual());
            int puertoDestino;

            // Si el índice del puerto actual no es el último, se le suma 1 al índice para sacar el siguiente
            if (puertoActual < b.getRuta().getPuertos().size() - 1) {
                puertoDestino = puertoActual + 1;

                // Si no, quiere decir que el puerto actual es el último de la lista, tiene que volver al índice 0
            } else {
                puertoDestino = 0;
            }
            
            Puerto puerto = b.getPuertoActual();
            Puerto siguientePuerto = b.getRuta().getPuertos().get(puertoDestino);
            
            b.setPuertoActual(siguientePuerto);

            texto.append("El buque " + b.getNombre() + " ha CARGADO " + b.getContenedores().size() + " contenedores en el puerto de " + puerto.getNombre() + ".\n"
                    + "Siguiente destino:\n" + siguientePuerto.infoPuerto() + "\n");

            // Fin carga contenedores

            // Para que el scroll siga al texto y no se quede arriba
            texto.setCaretPosition(texto.getDocument().getLength());
        }
    }
}
