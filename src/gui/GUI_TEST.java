package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Fran <6W>
 */

public class GUI_TEST extends JFrame implements ActionListener {

    // Todos los componentes que se van a usar en la interfaz gráfica.
    
    // Botones con listas desplegables PANEL IZQUIERDO.
    private JComboBox listaNavieras;
    private JComboBox listaPuertosOrigen;
    private JComboBox listaPuertosDestino;

    // Posicionamiento de componentes (Constraints) PANEL IZQUIERDO.
    private GridBagConstraints constrainsListaPuertos;
    private GridBagConstraints constrainsListaPuertos2;
    private GridBagConstraints constraintsSeleccionPuertoOrigen;
    private GridBagConstraints constraintsSeleccionNaviera;
    private GridBagConstraints constraintsListaNavieras;
    private GridBagConstraints seleccionPDestino;

    // Texto PANEL IZQUIERDO.
    private JLabel seleccionPuertoOrigen;
    private JLabel seleccionPuertoDestino;
    private JLabel seleccionNaviera;

    // Botones "click" PANEL CENTRO.
    private JButton comenzarBuques;
    private JButton pararBuques;
    
    // Texto PANEL CENTRO.
    private JTextArea rutaBuques;

    // PANELES.
    private JPanel ladoIzquierdoInterno;
    private JPanel ladoIzquierdo;
    private JPanel ladoCentroInterno;
    private JPanel ladoCentro;

    public GUI_TEST() {
        
        // Cambios del JFrame (ventana principal de la aplicación).
        this.setTitle("Gestión Portuaria");
        
        // Tamaño del JFrame.
        this.setSize(1400, 800);

        // Sin esto, al hacer click en la "X" el programa se escondería,
        // no pararía su ejecución.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout manager, este en concreto (BorderLayout) posiciona en NORTH, EAST, SOUTH, WEST, CENTER.
        this.setLayout(new BorderLayout());

        // Color de fondo del JFrame principal, si se añade un panel al JFrame
        // se posiciona por encima y el color ya no se vería.
        this.getContentPane().setBackground(new Color(0x0F1C30));
        // El panel del centro tapa el color, añado este color al panel del centro (al crear el panel central más abajo).

        // Icono del JFrame principal.
        ImageIcon icono = new ImageIcon("buqueIcono.png");
        this.setIconImage(icono.getImage());
        
        

        /*
        *
        *
        * PANEL IZQUIERDO
        *
        *
        */
        
        // Panel interno para que se vean mejor los bordes del panel izquierdo con márgenes.
        ladoIzquierdoInterno = new JPanel(new BorderLayout());
        ladoIzquierdoInterno.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
        ladoIzquierdoInterno.setOpaque(false);
        
        // Panel izquierdo.
        // El panel principal (JFrame) usa el BorderLayout, este panel usa
        // GridBagLayout, permite un posicionamiento más concreto de los
        // componentes que se le añadan gracias al uso de constraints.
        ladoIzquierdo = new JPanel();
        ladoIzquierdo.setLayout(new GridBagLayout());
        ladoIzquierdo.setBorder(new BordeRedondo(50));
        ladoIzquierdo.setOpaque(false);

        // COMPONENTES DEL PANEL IZQUIERDO
        
        // Crea un botón desplegable, cada elemento del botón es
        // un elemento del vector.
        String[] navieras = {"Arkas", "Maersk", "CMA"};
        listaNavieras = new JComboBox(navieras);
        // Cambio del tamaño manual para igualarlo a las listas desplegables.
        listaNavieras.setPreferredSize(new Dimension(139, 25));

        // (JComboBox)
        String[] puertosOrigen = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertosOrigen = new JComboBox(puertosOrigen);

        // (JComboBox)
        String[] puertosDestino = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertosDestino = new JComboBox(puertosDestino);

        // (JLabel)
        seleccionPuertoOrigen = new JLabel();
        seleccionPuertoOrigen.setText("Puerto de origen:");
        seleccionPuertoOrigen.setForeground(new Color(0xC2C6CE));

        // (JLabel)
        seleccionPuertoDestino = new JLabel();
        seleccionPuertoDestino.setText("Puerto de destino:");
        seleccionPuertoDestino.setForeground(new Color(0xC2C6CE));

        // (JLabel)
        seleccionNaviera = new JLabel();
        seleccionNaviera.setText("Naviera:");
        seleccionNaviera.setForeground(new Color(0xC2C6CE));

        // En los constraints, gridx = 0 -> primera columna, gridy modifica la fila.
        // Los componentes se colocan todos en la misma columna pero diferente fila.
        // weighty -> valor mayor, prioridad, ocupa el espacio disponible. Añado el weighty = 1 al último
        // componente para que "empuje" a los demás hacia arriba, así consigo que estén
        // "anclados" en el top del panel, si no, aparecerían centrados.
        
        // "Puerto de origen:" (JLabel Constraint)
        constraintsSeleccionPuertoOrigen = new GridBagConstraints();
        constraintsSeleccionPuertoOrigen.gridx = 0;
        constraintsSeleccionPuertoOrigen.gridy = 0;
        constraintsSeleccionPuertoOrigen.gridwidth = 1;
        constraintsSeleccionPuertoOrigen.gridheight = 1;
        constraintsSeleccionPuertoOrigen.anchor = GridBagConstraints.NORTH;
        constraintsSeleccionPuertoOrigen.insets = new Insets(5, 5, 5, 5);
        constraintsSeleccionPuertoOrigen.weighty = 0;

        // Lista de puertos (JComboBox Constraint).
        constrainsListaPuertos = new GridBagConstraints();
        constrainsListaPuertos.gridx = 0;
        constrainsListaPuertos.gridy = 1;
        constrainsListaPuertos.gridwidth = 1;
        constrainsListaPuertos.gridheight = 1;
        constrainsListaPuertos.anchor = GridBagConstraints.NORTH;
        constrainsListaPuertos.insets = new Insets(5, 5, 5, 5);
        constrainsListaPuertos.weighty = 0;

        // "Puerto de destino:" (JLabel Constraint)
        seleccionPDestino = new GridBagConstraints();
        seleccionPDestino.gridx = 0;
        seleccionPDestino.gridy = 2;
        seleccionPDestino.gridwidth = 1;
        seleccionPDestino.gridheight = 1;
        seleccionPDestino.anchor = GridBagConstraints.NORTH;
        seleccionPDestino.insets = new Insets(5, 5, 5, 5);
        seleccionPDestino.weighty = 0;

        // Lista de puertos (JComboBox Constraint).
        constrainsListaPuertos2 = new GridBagConstraints();
        constrainsListaPuertos2.gridx = 0;
        constrainsListaPuertos2.gridy = 3;
        constrainsListaPuertos2.gridwidth = 1;
        constrainsListaPuertos2.gridheight = 1;
        constrainsListaPuertos2.anchor = GridBagConstraints.NORTH;
        constrainsListaPuertos2.insets = new Insets(5, 5, 5, 5);
        constrainsListaPuertos2.weighty = 0;

        // "Naviera:" (JLabel Constraint)
        constraintsSeleccionNaviera = new GridBagConstraints();
        constraintsSeleccionNaviera.gridx = 0;
        constraintsSeleccionNaviera.gridy = 4;
        constraintsSeleccionNaviera.gridwidth = 1;
        constraintsSeleccionNaviera.gridheight = 1;
        constraintsSeleccionNaviera.anchor = GridBagConstraints.NORTH;
        constraintsSeleccionNaviera.insets = new Insets(50, 5, 5, 5);
        constraintsSeleccionNaviera.weighty = 0;

        // Lista de navieras (JComboBox Constraint).
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
        ladoIzquierdo.setBackground(new Color(0x304A6E));
        ladoIzquierdo.add(seleccionPuertoOrigen, constraintsSeleccionPuertoOrigen);
        ladoIzquierdo.add(listaPuertosOrigen, constrainsListaPuertos);
        ladoIzquierdo.add(seleccionPuertoDestino, seleccionPDestino);
        ladoIzquierdo.add(listaPuertosDestino, constrainsListaPuertos2);
        ladoIzquierdo.add(seleccionNaviera, constraintsSeleccionNaviera);
        ladoIzquierdo.add(listaNavieras, constraintsListaNavieras);
        
        ladoIzquierdoInterno.add(ladoIzquierdo, BorderLayout.CENTER);

        /*
        *
        *
        * PANEL CENTRO
        *
        *
        */
        
        // Panel interno para que se vean mejor los bordes y añadir margen al panel centro.
        ladoCentroInterno = new JPanel(new BorderLayout());
        ladoCentroInterno.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        ladoCentroInterno.setOpaque(false);
        
        
        // Panel centro.
        ladoCentro = new JPanel();
        ladoCentro.setLayout(new GridBagLayout());
        ladoCentro.setBackground(new Color(0x668DC0));
        ladoCentro.setBorder(new BordeRedondo(50));
        ladoCentro.setOpaque(false);
        
        // COMPONENTES DEL PANEL CENTRO
        
        // (JButton)
        comenzarBuques = new JButton("Iniciar ruta");
        
        // (JButton)
        pararBuques = new JButton("Parar ruta");
        
        // (JTextArea)
        rutaBuques = new JTextArea(1, 10);
        rutaBuques.setEditable(false);
        rutaBuques.setPreferredSize(new Dimension(800, 400));
        rutaBuques.setBackground(new Color(0xC0D0EF));
        rutaBuques.setForeground(new Color(0x0F1C30));
        rutaBuques.setBorder(new BordeRedondo(50));
        rutaBuques.setOpaque(false);
        
        // Adición de componentes al panel centro.
        ladoCentro.add(rutaBuques);
        ladoCentro.add(comenzarBuques);
        ladoCentro.add(pararBuques);
        
        // Se añade el panel del centro a su contenedor interno.
        ladoCentroInterno.add(ladoCentro, BorderLayout.CENTER);
        
        /* 
        *
        *  TO DO
        *
        */

        // Adición de paneles al JFrame principal.
        // Como el panel principal utiliza BorderLayout, se pueden colocar los paneles en 
        // NORTH, EAST, SOUTH, WEST, CENTER.
        this.add(ladoIzquierdoInterno, BorderLayout.WEST);
        this.add(ladoCentroInterno, BorderLayout.CENTER);
        
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
