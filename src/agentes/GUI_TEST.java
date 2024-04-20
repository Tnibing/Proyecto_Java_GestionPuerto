package agentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Fran <6W>
 */

public class GUI_TEST extends JFrame implements ActionListener {

    // Todos los componentes que se van a usar en la interfaz gráfica.
    
    // Botones con listas desplegables.
    private JComboBox listaNavieras;
    private JComboBox listaPuertosOrigen;
    private JComboBox listaPuertosDestino;
    
    // Botones "click".
    private JButton comenzarBuques;
    private JButton pararBuques;

    // Posicionamiento de componentes.
    private GridBagConstraints constrainsListaPuertos;
    private GridBagConstraints constrainsListaPuertos2;
    private GridBagConstraints constraintsSeleccionPuertoOrigen;
    private GridBagConstraints constraintsSeleccionNaviera;
    private GridBagConstraints constraintsListaNavieras;
    private GridBagConstraints seleccionPDestino;

    // Texto.
    private JLabel seleccionPuertoOrigen;
    private JLabel seleccionPuertoDestino;
    private JLabel seleccionNaviera;

    // Paneles.
    private JPanel ladoIzquierdo;
    private JPanel ladoCentro;

    public GUI_TEST() {

        // Cambios del JFrame (ventana principal de la aplicación).
        this.setTitle("Gestión Portuaria");
        
        // Tamaño.
        this.setSize(1400, 800);

        // Sin esto, al hacer click en la "X" el programa se escondería,
        // no pararía su ejecución.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout manager, este en concreto (BorderLayout) posiciona en NORTH, EAST, SOUTH, WEST, CENTER.
        this.setLayout(new BorderLayout());

        // Color de fondo del JFrame principal, si se añade un panel al JFrame
        // se posiciona por encima y el color ya no se vería.
        this.getContentPane().setBackground(new Color(0x649EFF));

        // Icono del JFrame principal.
        ImageIcon icono = new ImageIcon("buqueIcono.png");
        this.setIconImage(icono.getImage());

        // PANEL IZQUIERDO
        
        // El panel principal (JFrame) usa el BorderLayout, este panel usa
        // GridBagLayout, permite un posicionamiento más concreto de los
        // componentes que se le añadan gracias al uso de constraints.
        ladoIzquierdo = new JPanel();
        ladoIzquierdo.setLayout(new GridBagLayout());

        // COMPONENTES DEL PANEL IZQUIERDO
        
        // Crea un botón desplegable, cada elemento .
        String[] navieras = {"Arkas", "Maersk", "CMA"};
        listaNavieras = new JComboBox(navieras);
        // Cambio del tamaño manual para igualarlo a las listas desplegables.
        listaNavieras.setPreferredSize(new Dimension(139, 25));

        String[] puertosOrigen = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertosOrigen = new JComboBox(puertosOrigen);

        String[] puertosDestino = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertosDestino = new JComboBox(puertosDestino);

        seleccionPuertoOrigen = new JLabel();
        seleccionPuertoOrigen.setText("Puerto de origen:");

        seleccionPuertoDestino = new JLabel();
        seleccionPuertoDestino.setText("Puerto de destino:");

        seleccionNaviera = new JLabel();
        seleccionNaviera.setText("Naviera:");

        // En los constraints, gridx = 0 -> primera columna, gridy modifica la fila.
        // Los componentes se colocan todos en la misma columna pero diferente fila.
        // Weighty -> valor mayor, prioridad, ocupa el espacio disponible. Añado el weighty = 1 al último
        // componente para que "empuje" a los demás hacia arriba, así consigo que estén
        // "anclados" en el top del panel, si no, aparecerían centrados.
        
        // JLabel "Puerto de origen:"
        constraintsSeleccionPuertoOrigen = new GridBagConstraints();
        constraintsSeleccionPuertoOrigen.gridx = 0;
        constraintsSeleccionPuertoOrigen.gridy = 0;
        constraintsSeleccionPuertoOrigen.gridwidth = 1;
        constraintsSeleccionPuertoOrigen.gridheight = 1;
        constraintsSeleccionPuertoOrigen.anchor = GridBagConstraints.NORTH;
        constraintsSeleccionPuertoOrigen.insets = new Insets(5, 5, 5, 5);
        constraintsSeleccionPuertoOrigen.weighty = 0;

        // Lista de puertos (JComboBox).
        constrainsListaPuertos = new GridBagConstraints();
        constrainsListaPuertos.gridx = 0;
        constrainsListaPuertos.gridy = 1;
        constrainsListaPuertos.gridwidth = 1;
        constrainsListaPuertos.gridheight = 1;
        constrainsListaPuertos.anchor = GridBagConstraints.NORTH;
        constrainsListaPuertos.insets = new Insets(5, 5, 5, 5);
        constrainsListaPuertos.weighty = 0;

        // JLabel "Puerto de destino:"
        seleccionPDestino = new GridBagConstraints();
        seleccionPDestino.gridx = 0;
        seleccionPDestino.gridy = 2;
        seleccionPDestino.gridwidth = 1;
        seleccionPDestino.gridheight = 1;
        seleccionPDestino.anchor = GridBagConstraints.NORTH;
        seleccionPDestino.insets = new Insets(5, 5, 5, 5);
        seleccionPDestino.weighty = 0;

        // Lista de puertos (JComboBox).
        constrainsListaPuertos2 = new GridBagConstraints();
        constrainsListaPuertos2.gridx = 0;
        constrainsListaPuertos2.gridy = 3;
        constrainsListaPuertos2.gridwidth = 1;
        constrainsListaPuertos2.gridheight = 1;
        constrainsListaPuertos2.anchor = GridBagConstraints.NORTH;
        constrainsListaPuertos2.insets = new Insets(5, 5, 5, 5);
        constrainsListaPuertos2.weighty = 0;

        // JLabel "Naviera:"
        constraintsSeleccionNaviera = new GridBagConstraints();
        constraintsSeleccionNaviera.gridx = 0;
        constraintsSeleccionNaviera.gridy = 4;
        constraintsSeleccionNaviera.gridwidth = 1;
        constraintsSeleccionNaviera.gridheight = 1;
        constraintsSeleccionNaviera.anchor = GridBagConstraints.NORTH;
        constraintsSeleccionNaviera.insets = new Insets(50, 5, 5, 5);
        constraintsSeleccionNaviera.weighty = 0;

        // Lista de navieras (JComboBox).
        constraintsListaNavieras = new GridBagConstraints();
        constraintsListaNavieras.gridx = 0;
        constraintsListaNavieras.gridy = 5;
        constraintsListaNavieras.gridwidth = 1;
        constraintsListaNavieras.gridheight = 1;
        constraintsListaNavieras.anchor = GridBagConstraints.NORTH;
        constraintsListaNavieras.insets = new Insets(5, 5, 5, 5);
        constraintsListaNavieras.weighty = 1;

        // Adición de componentes al panel izquierdo (los componentes que le correspondan
        // con sus respectivos constraints).
        ladoIzquierdo.setPreferredSize(new Dimension(290, 800));
        ladoIzquierdo.setBackground(Color.WHITE);
        ladoIzquierdo.add(seleccionPuertoOrigen, constraintsSeleccionPuertoOrigen);
        ladoIzquierdo.add(listaPuertosOrigen, constrainsListaPuertos);
        ladoIzquierdo.add(seleccionPuertoDestino, seleccionPDestino);
        ladoIzquierdo.add(listaPuertosDestino, constrainsListaPuertos2);
        ladoIzquierdo.add(seleccionNaviera, constraintsSeleccionNaviera);
        ladoIzquierdo.add(listaNavieras, constraintsListaNavieras);

        // PANEL CENTRO
        
        ladoCentro = new JPanel();
        ladoCentro.setLayout(new GridBagLayout());
        
        // COMPONENTES DEL PANEL CENTRO
        
        /* 
        *
        *  TO DO
        *
        */

        // Adición de paneles al JFrame principal.
        // Como el panel principal utiliza BorderLayout, se pueden colocar los paneles en 
        // NORTH, EAST, SOUTH, WEST, CENTER.
        this.add(ladoIzquierdo, BorderLayout.WEST);
        
        // Para que al comenzar la aplicación, el JFrame principal
        // aparezca en el centro de la pantalla. Sin esto, aparecería
        // arriba a la izquierda.
        this.setLocationRelativeTo(null);
        
        // Sin esto, no se vería el JFrame al comenzar la aplicación.
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
