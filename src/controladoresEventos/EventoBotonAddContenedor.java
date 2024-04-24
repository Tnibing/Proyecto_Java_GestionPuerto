package controladoresEventos;

import agentes.Naviera;
import cargas.Contenedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import rutas.Puerto;
import rutas.PuertosOrigenYDestinoIgualesException;

/**
 *
 * @author Fran <6W>
 */
public class EventoBotonAddContenedor implements ActionListener {

    private Puerto pValencia;
    private Puerto pCastellon;
    private Puerto pBarcelona;
    private Puerto pPireo;
    private Puerto pEstambul;
    private Puerto pYarimca;

    private Puerto contenedorPuertoOrigen;
    private Puerto contenedorPuertoDestino;

    private Naviera nav;
    private JComboBox naviera;

    private Contenedor contenedor;

    private int numContenedores;
    private JFormattedTextField numContenedoresParsearEsto;

    private JComboBox puertoO;
    private JComboBox puertoD;

    public EventoBotonAddContenedor(JComboBox puertoO, JComboBox puertoD, JComboBox naviera, JFormattedTextField num,
            Puerto pValencia, Puerto pCastellon, Puerto pBarcelona, Puerto pPireo, Puerto pEstambul, Puerto pYarimca) {

        this.pValencia = pValencia;
        this.pCastellon = pCastellon;
        this.pBarcelona = pBarcelona;
        this.pPireo = pPireo;
        this.pEstambul = pEstambul;
        this.pYarimca = pYarimca;

        numContenedoresParsearEsto = num;

        this.naviera = naviera;

        this.puertoO = puertoO;
        this.puertoD = puertoD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Thread hiloAddContenedores = new Thread(() -> {

            nav = new Naviera((String) naviera.getSelectedItem());

            numContenedores = numContenedoresParsearEsto.getValue() == null ? 0 : (Integer) numContenedoresParsearEsto.getValue();

            String seleccionPuertoOrigen = (String) puertoO.getSelectedItem();
            String[] selecPuertoO = seleccionPuertoOrigen.split(" ");

            String seleccionPuertoDestino = (String) puertoD.getSelectedItem();
            String[] selecPuertoD = seleccionPuertoDestino.split(" ");

            switch (selecPuertoO[0]) {

                case "Valencia" ->
                    contenedorPuertoOrigen = pValencia;

                case "Castellón" ->
                    contenedorPuertoOrigen = pCastellon;

                case "Barcelona" ->
                    contenedorPuertoOrigen = pBarcelona;

                case "Pireo" ->
                    contenedorPuertoOrigen = pPireo;

                case "Estambul" ->
                    contenedorPuertoOrigen = pEstambul;

                case "Yarimca" ->
                    contenedorPuertoOrigen = pYarimca;
            }

            switch (selecPuertoD[0]) {

                case "Valencia" ->
                    contenedorPuertoDestino = pValencia;

                case "Castellón" ->
                    contenedorPuertoDestino = pCastellon;

                case "Barcelona" ->
                    contenedorPuertoDestino = pBarcelona;

                case "Pireo" ->
                    contenedorPuertoDestino = pPireo;

                case "Estambul" ->
                    contenedorPuertoDestino = pEstambul;

                case "Yarimca" ->
                    contenedorPuertoDestino = pYarimca;
            }

            if (numContenedores == 0) {
                JOptionPane.showMessageDialog(null, "¡No puedes añadir 0 contenedores!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (contenedorPuertoOrigen.compareTo(contenedorPuertoDestino) != 0) {

                while (numContenedores > 0) {

                    contenedor = new Contenedor(nav, contenedorPuertoOrigen, contenedorPuertoDestino);
                    contenedorPuertoOrigen.addContenedores(contenedor);
                    numContenedores--;
                }

                JOptionPane.showMessageDialog(null, contenedorPuertoOrigen.getContenedores().size() + " contenedores añadidos.\nOrigen:\n" + contenedorPuertoOrigen.infoPuerto() + "\nDestino:\n" + contenedorPuertoDestino.infoPuerto(), "Confirmado", JOptionPane.INFORMATION_MESSAGE);

            } else {

                try {
                    throw new PuertosOrigenYDestinoIgualesException("¡Los puertos de origen y destino no pueden ser el mismo!");

                } catch (PuertosOrigenYDestinoIgualesException ex) {

                    JOptionPane.showMessageDialog(null, "¡Los puertos de origen y destino no pueden ser el mismo!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        hiloAddContenedores.start();
    }
}
