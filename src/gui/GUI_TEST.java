package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Fran <6W>
 */

public class GUI_TEST extends JFrame implements ActionListener {

    // Todos los componentes que se van a usar en la interfaz gráfica.
    
    // PANEL IZQUIERDO
    
    // Botones con listas desplegables PANEL IZQUIERDO.
    private JComboBox listaNavierasComboBox;
    private JComboBox listaPuertosOrigenComboBox;
    private JComboBox listaPuertosDestinoComboBox;

    // Posicionamiento de componentes (Constraints) PANEL IZQUIERDO.
    private GridBagConstraints constrainsListaPuertosOrigenComboBox;
    private GridBagConstraints constrainsListaPuertosDestinoComboBox;
    private GridBagConstraints constraintsSeleccionPuertoOrigenJLabel;
    private GridBagConstraints constraintsSeleccionNavieraJLabel;
    private GridBagConstraints constraintsListaNavierasComboBox;
    private GridBagConstraints constraintsSeleccionPuertoDestinoJLabel;

    // Texto PANEL IZQUIERDO.
    private JLabel seleccionPuertoOrigenJLabel;
    private JLabel seleccionPuertoDestinoJLabel;
    private JLabel seleccionNavieraJLabel;
    
    // PANEL CENTRO
    
    // Botones "click" PANEL CENTRO.
    private JButton comenzarBuquesJButton;
    private JButton pararBuquesJButton;
    private JButton infoPuertosJButton;
    
    // Texto PANEL CENTRO.
    private JTextArea rutaBuquesJTextArea;
    private JTextArea infoPuertosTextoJTextArea;
    private JScrollPane scrollTextoBuquesJTextArea;
    private JScrollPane scrollTextoPuertosJTextArea;
    
    // JLabel para imágenes PANEL CENTRO.
    private JLabel contenedorImagenCentroBuqueJLabel;
    private JLabel contenedorImagenCentroPuertoJLabel;
    
    // Posicionameinto de componentes (Constraints) PANEL CENTRO
    private GridBagConstraints constraintsRutaBuquesJTextArea;
    private GridBagConstraints constraintsComenzarBuquesJButton;
    private GridBagConstraints constraintsPararBuquesJButton;
    private GridBagConstraints  constraintsContenedorImagenCentroBuqueJLabel;
    private GridBagConstraints constraintsContenedorImagenCentroPuertoJLabel;
    private GridBagConstraints constraintsInfoPuertosJButton;
    private GridBagConstraints constraintsInfoTextoPuertosJTextArea;

    // PANELES.
    private JPanel ladoIzquierdoInternoJPanel;
    private JPanel ladoIzquierdoJPanel;
    private JPanel ladoCentroInternoJPanel;
    private JPanel ladoCentroJPanel;
    private JPanel panelComponenetesInternoCentroArribaJPanel;
    private JPanel panelComponenetesInternoCentroAbajoJPanel;

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
        ladoIzquierdoInternoJPanel = new JPanel(new BorderLayout());
        ladoIzquierdoInternoJPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
        ladoIzquierdoInternoJPanel.setOpaque(false);
        
        // Panel izquierdo.
        // El panel principal (JFrame) usa el BorderLayout, este panel usa
        // GridBagLayout, permite un posicionamiento más concreto de los
        // componentes que se le añadan gracias al uso de constraints.
        ladoIzquierdoJPanel = new JPanel();
        ladoIzquierdoJPanel.setLayout(new GridBagLayout());
        ladoIzquierdoJPanel.setBorder(new BordeRedondo(50));
        ladoIzquierdoJPanel.setOpaque(false);

        // COMPONENTES DEL PANEL IZQUIERDO
        
        // Crea un botón desplegable, cada elemento del botón es
        // un elemento del vector.
        String[] navieras = {"Arkas", "Maersk", "CMA"};
        listaNavierasComboBox = new JComboBox(navieras);
        // Cambio del tamaño manual para igualarlo a las listas desplegables.
        listaNavierasComboBox.setPreferredSize(new Dimension(139, 25));

        // (JComboBox)
        String[] puertosOrigen = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertosOrigenComboBox = new JComboBox(puertosOrigen);

        // (JComboBox)
        String[] puertosDestino = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertosDestinoComboBox = new JComboBox(puertosDestino);

        // (JLabel)
        seleccionPuertoOrigenJLabel = new JLabel();
        seleccionPuertoOrigenJLabel.setText("Puerto de origen:");
        seleccionPuertoOrigenJLabel.setForeground(Color.WHITE);

        // (JLabel)
        seleccionPuertoDestinoJLabel = new JLabel();
        seleccionPuertoDestinoJLabel.setText("Puerto de destino:");
        seleccionPuertoDestinoJLabel.setForeground(Color.WHITE);

        // (JLabel)
        seleccionNavieraJLabel = new JLabel();
        seleccionNavieraJLabel.setText("Naviera:");
        seleccionNavieraJLabel.setForeground(Color.WHITE);

        // En los constraints, gridx = 0 -> primera columna, gridy modifica la fila.
        // Los componentes se colocan todos en la misma columna pero diferente fila.
        // weighty -> valor mayor, prioridad, ocupa el espacio disponible. Añado el weighty = 1 al último
        // componente para que "empuje" a los demás hacia arriba, así consigo que estén
        // "anclados" en el top del panel, si no, aparecerían centrados.
        
        // CONSTRAINTS COMPONENTES PANEL IZQUIERDO
        
        // "Puerto de origen:" (JLabel Constraint)
        constraintsSeleccionPuertoOrigenJLabel = new GridBagConstraints();
        constraintsSeleccionPuertoOrigenJLabel.gridx = 0;
        constraintsSeleccionPuertoOrigenJLabel.gridy = 0;
        constraintsSeleccionPuertoOrigenJLabel.gridwidth = 1;
        constraintsSeleccionPuertoOrigenJLabel.gridheight = 1;
        constraintsSeleccionPuertoOrigenJLabel.anchor = GridBagConstraints.NORTH;
        constraintsSeleccionPuertoOrigenJLabel.insets = new Insets(5, 5, 5, 5);
        constraintsSeleccionPuertoOrigenJLabel.weighty = 0;

        // Lista de puertos (JComboBox Constraint).
        constrainsListaPuertosOrigenComboBox = new GridBagConstraints();
        constrainsListaPuertosOrigenComboBox.gridx = 0;
        constrainsListaPuertosOrigenComboBox.gridy = 1;
        constrainsListaPuertosOrigenComboBox.gridwidth = 1;
        constrainsListaPuertosOrigenComboBox.gridheight = 1;
        constrainsListaPuertosOrigenComboBox.anchor = GridBagConstraints.NORTH;
        constrainsListaPuertosOrigenComboBox.insets = new Insets(5, 5, 5, 5);
        constrainsListaPuertosOrigenComboBox.weighty = 0;

        // "Puerto de destino:" (JLabel Constraint)
        constraintsSeleccionPuertoDestinoJLabel = new GridBagConstraints();
        constraintsSeleccionPuertoDestinoJLabel.gridx = 0;
        constraintsSeleccionPuertoDestinoJLabel.gridy = 2;
        constraintsSeleccionPuertoDestinoJLabel.gridwidth = 1;
        constraintsSeleccionPuertoDestinoJLabel.gridheight = 1;
        constraintsSeleccionPuertoDestinoJLabel.anchor = GridBagConstraints.NORTH;
        constraintsSeleccionPuertoDestinoJLabel.insets = new Insets(5, 5, 5, 5);
        constraintsSeleccionPuertoDestinoJLabel.weighty = 0;

        // Lista de puertos (JComboBox Constraint).
        constrainsListaPuertosDestinoComboBox = new GridBagConstraints();
        constrainsListaPuertosDestinoComboBox.gridx = 0;
        constrainsListaPuertosDestinoComboBox.gridy = 3;
        constrainsListaPuertosDestinoComboBox.gridwidth = 1;
        constrainsListaPuertosDestinoComboBox.gridheight = 1;
        constrainsListaPuertosDestinoComboBox.anchor = GridBagConstraints.NORTH;
        constrainsListaPuertosDestinoComboBox.insets = new Insets(5, 5, 5, 5);
        constrainsListaPuertosDestinoComboBox.weighty = 0;

        // "Naviera:" (JLabel Constraint)
        constraintsSeleccionNavieraJLabel = new GridBagConstraints();
        constraintsSeleccionNavieraJLabel.gridx = 0;
        constraintsSeleccionNavieraJLabel.gridy = 4;
        constraintsSeleccionNavieraJLabel.gridwidth = 1;
        constraintsSeleccionNavieraJLabel.gridheight = 1;
        constraintsSeleccionNavieraJLabel.anchor = GridBagConstraints.NORTH;
        constraintsSeleccionNavieraJLabel.insets = new Insets(50, 5, 5, 5);
        constraintsSeleccionNavieraJLabel.weighty = 0;

        // Lista de navieras (JComboBox Constraint).
        constraintsListaNavierasComboBox = new GridBagConstraints();
        constraintsListaNavierasComboBox.gridx = 0;
        constraintsListaNavierasComboBox.gridy = 5;
        constraintsListaNavierasComboBox.gridwidth = 1;
        constraintsListaNavierasComboBox.gridheight = 1;
        constraintsListaNavierasComboBox.anchor = GridBagConstraints.NORTH;
        constraintsListaNavierasComboBox.insets = new Insets(5, 5, 5, 5);
        constraintsListaNavierasComboBox.weighty = 1;

        // Adición de componentes al panel izquierdo (los componentes que le correspondan
        // con sus respectivos constraints).
        ladoIzquierdoJPanel.setPreferredSize(new Dimension(290, 800));
        ladoIzquierdoJPanel.setBackground(new Color(0x304A6E));
        ladoIzquierdoJPanel.add(seleccionPuertoOrigenJLabel, constraintsSeleccionPuertoOrigenJLabel);
        ladoIzquierdoJPanel.add(listaPuertosOrigenComboBox, constrainsListaPuertosOrigenComboBox);
        ladoIzquierdoJPanel.add(seleccionPuertoDestinoJLabel, constraintsSeleccionPuertoDestinoJLabel);
        ladoIzquierdoJPanel.add(listaPuertosDestinoComboBox, constrainsListaPuertosDestinoComboBox);
        ladoIzquierdoJPanel.add(seleccionNavieraJLabel, constraintsSeleccionNavieraJLabel);
        ladoIzquierdoJPanel.add(listaNavierasComboBox, constraintsListaNavierasComboBox);
        
        ladoIzquierdoInternoJPanel.add(ladoIzquierdoJPanel, BorderLayout.CENTER);

        /*
        *
        *
        * PANEL CENTRO
        *
        *
        */
        
        // Panel interno para que se vean mejor los bordes y añadir margen al panel centro.
        ladoCentroInternoJPanel = new JPanel(new BorderLayout());
        ladoCentroInternoJPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        ladoCentroInternoJPanel.setOpaque(false);
        
        // Panel centro.
        ladoCentroJPanel = new JPanel();
        ladoCentroJPanel.setLayout(new BorderLayout());
        ladoCentroJPanel.setBackground(new Color(0x668DC0));
        ladoCentroJPanel.setBorder(new BordeRedondo(50));
        ladoCentroJPanel.setOpaque(false);
        
        // COMPONENTES DEL PANEL CENTRO
        
        // (JPanel) Panel de los componentes de abajo.
        panelComponenetesInternoCentroAbajoJPanel = new JPanel();
        panelComponenetesInternoCentroAbajoJPanel.setLayout(new GridBagLayout());
        panelComponenetesInternoCentroAbajoJPanel.setOpaque(false);
        
        // (JPanel) Panel de los componentes de arriba.
        panelComponenetesInternoCentroArribaJPanel = new JPanel();
        panelComponenetesInternoCentroArribaJPanel.setLayout(new GridBagLayout());
        panelComponenetesInternoCentroArribaJPanel.setOpaque(false);
        
        // (JButton) info puertos.
        infoPuertosJButton = new JButton("Mostrar información de puertos");
        
        // (JTextArea) Buques.
        rutaBuquesJTextArea = new JTextArea(10, 1);
        rutaBuquesJTextArea.setEditable(true);
        rutaBuquesJTextArea.setPreferredSize(new Dimension(700, 300));
        rutaBuquesJTextArea.setBackground(new Color(0xC0D0EF));
        rutaBuquesJTextArea.setForeground(Color.BLACK);
        rutaBuquesJTextArea.setOpaque(true);
        rutaBuquesJTextArea.setMargin(new Insets(10, 10, 10, 10));
        rutaBuquesJTextArea.setEditable(false);
        
        // Barra de scroll para rutaBuquesJTextArea.
        scrollTextoBuquesJTextArea = new JScrollPane(rutaBuquesJTextArea);
        scrollTextoBuquesJTextArea.setPreferredSize(new Dimension(700, 300));
        
        // (JButton) iniciar ruta.
        comenzarBuquesJButton = new JButton("Iniciar ruta");
        comenzarBuquesJButton.addActionListener(this);

        // (JButton) parar ruta.
        pararBuquesJButton = new JButton("Parar ruta");
        pararBuquesJButton.setPreferredSize(comenzarBuquesJButton.getPreferredSize());
        
        // (JTextArea) Puertos.
        infoPuertosTextoJTextArea = new JTextArea(0, 0);
        infoPuertosTextoJTextArea.setEditable(false);
        infoPuertosTextoJTextArea.setPreferredSize(new Dimension(700, 300));
        infoPuertosTextoJTextArea.setBackground(new Color(0xC0D0EF));
        infoPuertosTextoJTextArea.setForeground(Color.BLACK);
        infoPuertosTextoJTextArea.setOpaque(true);
        infoPuertosTextoJTextArea.setMargin(new Insets(10, 10, 10, 10));

        // Barra de scroll para puertos.
        scrollTextoPuertosJTextArea = new JScrollPane(infoPuertosTextoJTextArea);
        scrollTextoPuertosJTextArea.setPreferredSize(new Dimension(700, 300));
        
        // Imagen, primero se carga como ImageIcon y luego lo paso a
        // Image para poder cambiar el tamaño
        ImageIcon buqueImgIcono = new ImageIcon("buqueSim.png");
        Image buqueImgOriginal = buqueImgIcono.getImage();
        Image buqueImgEscalada = buqueImgOriginal.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon buqueImgFinal = new ImageIcon(buqueImgEscalada);
        
        // Otra imagen
        ImageIcon puertoImgIcono = new ImageIcon("imagenPuerto.png");
        Image puertoImgOriginal = puertoImgIcono.getImage();
        Image puertoImgEscalada = puertoImgOriginal.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon puertoImgFinal = new ImageIcon(puertoImgEscalada);
        
        // JLabel para la imagen (buque)
        contenedorImagenCentroBuqueJLabel = new JLabel(buqueImgFinal);
        
        // Otro JLabel para la otra imagen (puerto)
        contenedorImagenCentroPuertoJLabel = new JLabel(puertoImgFinal);
        
        // CONSTRAINTS COMPONENTES PANEL CENTRO 
        
        // Ruta buques (JTextArea Constraint)
        constraintsRutaBuquesJTextArea = new GridBagConstraints();
        constraintsRutaBuquesJTextArea.gridx = 0;
        constraintsRutaBuquesJTextArea.gridy = 0;
        constraintsRutaBuquesJTextArea.gridwidth = 1;
        constraintsRutaBuquesJTextArea.gridheight = 1;
        constraintsRutaBuquesJTextArea.anchor = GridBagConstraints.NORTH;
        constraintsRutaBuquesJTextArea.insets = new Insets(5, 5, 5, 5);
        constraintsRutaBuquesJTextArea.weighty = 0;
        
        // Info puertos (JTextArea Constraint)
        constraintsInfoTextoPuertosJTextArea = new GridBagConstraints();
        constraintsInfoTextoPuertosJTextArea.gridx = 1;
        constraintsInfoTextoPuertosJTextArea.gridy = 1;
        constraintsInfoTextoPuertosJTextArea.gridwidth = 0;
        constraintsInfoTextoPuertosJTextArea.gridheight = 0;
        constraintsInfoTextoPuertosJTextArea.anchor = GridBagConstraints.EAST;
        constraintsInfoTextoPuertosJTextArea.insets = new Insets(350, 0, 0, 0);
        constraintsInfoTextoPuertosJTextArea.weighty = 0;
        constraintsInfoTextoPuertosJTextArea.weightx = 1;
        
        // Imagen buque (ImageIcon Constraints)
        constraintsContenedorImagenCentroBuqueJLabel = new GridBagConstraints();
        constraintsContenedorImagenCentroBuqueJLabel.gridx = 1;
        constraintsContenedorImagenCentroBuqueJLabel.gridy = 0;
        constraintsContenedorImagenCentroBuqueJLabel.gridwidth = 0;
        constraintsContenedorImagenCentroBuqueJLabel.gridheight = 0;
        constraintsContenedorImagenCentroBuqueJLabel.anchor = GridBagConstraints.NORTH;
        constraintsContenedorImagenCentroBuqueJLabel.insets = new Insets(30, 80, 5, 5);
        constraintsContenedorImagenCentroBuqueJLabel.weighty = 0;
        constraintsContenedorImagenCentroBuqueJLabel.weightx = 0;
        
        // Boton comenzar (JButton Constraint)
        constraintsComenzarBuquesJButton = new GridBagConstraints();
        constraintsComenzarBuquesJButton.gridx = 1;
        constraintsComenzarBuquesJButton.gridy = 0;
        constraintsComenzarBuquesJButton.gridwidth = 1;
        constraintsComenzarBuquesJButton.gridheight = 1;
        constraintsComenzarBuquesJButton.anchor = GridBagConstraints.NORTH;
        constraintsComenzarBuquesJButton.insets = new Insets(170, 80, 5, 5);
        constraintsComenzarBuquesJButton.weighty = 0;
        
        // Boton parar (JButton Constraint)
        constraintsPararBuquesJButton = new GridBagConstraints();
        constraintsPararBuquesJButton.gridx = 1;
        constraintsPararBuquesJButton.gridy = 0;
        constraintsPararBuquesJButton.gridwidth = 1;
        constraintsPararBuquesJButton.gridheight = 1;
        constraintsPararBuquesJButton.anchor = GridBagConstraints.NORTH;
        constraintsPararBuquesJButton.insets = new Insets(220, 80, 5, 5);
        constraintsPararBuquesJButton.weighty = 1;
        
        // Boton info puertos (JButton Constraint)
        constraintsInfoPuertosJButton = new GridBagConstraints();
        constraintsInfoPuertosJButton.gridx = 0;
        constraintsInfoPuertosJButton.gridy = 1;
        constraintsInfoPuertosJButton.gridwidth = 1;
        constraintsInfoPuertosJButton.gridheight = 1;
        constraintsInfoPuertosJButton.anchor = GridBagConstraints.WEST;
        constraintsInfoPuertosJButton.insets = new Insets(520, 0, 0, 20);
        constraintsInfoPuertosJButton.weighty = 1;
        constraintsInfoPuertosJButton.weightx = 0;
        
        // Imagen Puerto (ImageIcon Constraints)
        constraintsContenedorImagenCentroPuertoJLabel = new GridBagConstraints();
        constraintsContenedorImagenCentroPuertoJLabel.gridx = 0;
        constraintsContenedorImagenCentroPuertoJLabel.gridy = 0;
        constraintsContenedorImagenCentroPuertoJLabel.gridwidth = 0;
        constraintsContenedorImagenCentroPuertoJLabel.gridheight = 0;
        constraintsContenedorImagenCentroPuertoJLabel.anchor = GridBagConstraints.SOUTH;
        constraintsContenedorImagenCentroPuertoJLabel.insets = new Insets(100, 20, 140, 750);
        constraintsContenedorImagenCentroPuertoJLabel.weighty = 0;
        constraintsContenedorImagenCentroPuertoJLabel.weightx = 0;
        
        // Adición de componentes al panel de centro-abajo
        panelComponenetesInternoCentroAbajoJPanel.add(contenedorImagenCentroPuertoJLabel, constraintsContenedorImagenCentroPuertoJLabel);
        panelComponenetesInternoCentroAbajoJPanel.add(scrollTextoPuertosJTextArea, constraintsInfoTextoPuertosJTextArea);
        panelComponenetesInternoCentroAbajoJPanel.add(infoPuertosJButton, constraintsInfoPuertosJButton);
        
        // Adición de componentes al panel de centro-arriba
        panelComponenetesInternoCentroArribaJPanel.add(scrollTextoBuquesJTextArea, constraintsRutaBuquesJTextArea);
        panelComponenetesInternoCentroArribaJPanel.add(contenedorImagenCentroBuqueJLabel, constraintsContenedorImagenCentroBuqueJLabel);
        panelComponenetesInternoCentroArribaJPanel.add(comenzarBuquesJButton, constraintsComenzarBuquesJButton);
        panelComponenetesInternoCentroArribaJPanel.add(pararBuquesJButton, constraintsPararBuquesJButton);
        
        panelComponenetesInternoCentroArribaJPanel.setVisible(true);
        
        // Se añade el panel de componentes al del centro
        ladoCentroJPanel.add(panelComponenetesInternoCentroAbajoJPanel, BorderLayout.SOUTH);
        ladoCentroJPanel.add(panelComponenetesInternoCentroArribaJPanel, BorderLayout.NORTH);
        
        // Se añade el panel del centro a su contenedor interno.
        ladoCentroInternoJPanel.add(ladoCentroJPanel, BorderLayout.CENTER);
        
        // Adición de paneles al JFrame principal.
        // Como el panel principal utiliza BorderLayout, se pueden colocar los paneles en 
        // NORTH, EAST, SOUTH, WEST, CENTER.
        this.add(ladoIzquierdoInternoJPanel, BorderLayout.WEST);
        this.add(ladoCentroInternoJPanel, BorderLayout.CENTER);
        
        // Para no cambiar el tamaño (me rompe la posición de los componentes :) ).
        this.setResizable(false);
        
        // Para que al comenzar la aplicación, el JFrame principal
        // aparezca en el centro de la pantalla. Sin esto, aparecería
        // arriba a la izquierda.
        this.setLocationRelativeTo(null);
        
        // Sin esto, no se vería el JFrame al comenzar la aplicación.
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == comenzarBuquesJButton) {
            
            SwingUtilities.invokeLater(new Runnable() {
                
                @Override
                public void run() {
                    rutaBuquesJTextArea.append("Test\n");
                }
            });
        }
    }
}
