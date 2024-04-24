package gui;

import controladoresEventos.EventoBotonComenzarPararRuta;
import controladoresEventos.EventoBotonLimpiarPantalla;
import controladoresEventos.EventoMostrarInfoPuertos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Fran <6W>
 */

public class GUI extends JFrame {


    // Todos los componentes que se van a usar en la interfaz gr�fica.
    
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
    private JButton comenzarPararBuquesJButton;
    private JButton limpiarPantallaBuquesJButton;
    private JButton infoPuertosJButton;
    private JButton limpiarPantallaInfoPuertosJButton;

    // Texto PANEL CENTRO.
    private JTextArea rutaBuquesJTextArea;
    private JTextArea infoPuertosTextoJTextArea;
    private JScrollPane scrollTextoBuquesJScrollPane;
    private JScrollPane scrollTextoPuertosJScrollPane;

    // JLabel para im�genes PANEL CENTRO.
    private JLabel contenedorImagenCentroBuqueJLabel;
    private JLabel contenedorImagenCentroPuertoJLabel;

    // Posicionameinto de componentes (Constraints) PANEL CENTRO
    private GridBagConstraints constraintsRutaBuquesJScrollPane;
    private GridBagConstraints constraintsComenzarPararBuquesJButton;
    private GridBagConstraints constraintsLimpiarPantallaBuquesJButton;
    private GridBagConstraints constraintsContenedorImagenCentroBuqueJLabel;
    private GridBagConstraints constraintsContenedorImagenCentroPuertoJLabel;
    private GridBagConstraints constraintsInfoPuertosJButton;
    private GridBagConstraints constraintsInfoTextoPuertosJScrollPane;
    private GridBagConstraints constraintsLimpiarPantallaInfoPuertosJButton;


    // PANELES.
    private JPanel ladoIzquierdoInternoJPanel;
    private JPanel ladoIzquierdoJPanel;
    private JPanel ladoCentroInternoJPanel;
    private JPanel ladoCentroJPanel;
    private JPanel panelComponenetesInternoCentroArribaJPanel;
    private JPanel panelComponenetesInternoCentroAbajoJPanel;

    public GUI() {

        // Cambios del JFrame (ventana principal de la aplicaci�n).
        this.setTitle("Gesti�n Portuaria");

        // Tama�o del JFrame.
        this.setSize(1400, 800);

        // Sin esto, al hacer click en la "X" el programa se esconder�a,
        // no parar�a su ejecuci�n.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout manager, este en concreto (BorderLayout) posiciona en NORTH, EAST, SOUTH, WEST, CENTER.
        this.setLayout(new BorderLayout());

        // Color de fondo del JFrame principal, si se a�ade un panel al JFrame
        // se posiciona por encima y el color ya no se ver�a.
        // El panel del centro tapa el color, a�ado este color al panel del centro (al crear el panel central m�s abajo).
        // Tambi�n a�ado unos m�rgenes para que se vea este color de fondo
        this.getContentPane().setBackground(new Color(0x0F1C30));

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
        // Panel interno para que se vean mejor los bordes del panel izquierdo con m�rgenes.
        ladoIzquierdoInternoJPanel = new JPanel(new BorderLayout());
        ladoIzquierdoInternoJPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
        ladoIzquierdoInternoJPanel.setOpaque(false);

        // Panel izquierdo.
        // El panel principal (JFrame) usa el BorderLayout, este panel usa
        // GridBagLayout, permite un posicionamiento m�s concreto de los
        // componentes que se le a�adan gracias al uso de constraints.
        ladoIzquierdoJPanel = new JPanel();
        ladoIzquierdoJPanel.setLayout(new GridBagLayout());
        ladoIzquierdoJPanel.setBorder(new BordeRedondo(50));
        ladoIzquierdoJPanel.setOpaque(false);

        // COMPONENTES DEL PANEL IZQUIERDO
        // Crea un bot�n desplegable, cada elemento del bot�n es
        // un elemento del vector.
        String[] navieras = {"Arkas", "Maersk", "CMA"};
        listaNavierasComboBox = new JComboBox(navieras);
        // Cambio del tama�o manual para igualarlo a las listas desplegables.
        listaNavierasComboBox.setPreferredSize(new Dimension(139, 25));

        // (JComboBox)
        String[] puertosOrigen = {"Valencia (Espa�a)", "Castell�n (Espa�a)", "Barcelona (Espa�a)", "Pireo (Grecia)", "Estambul (Turqu�a)", "Yarimca (Turqu�a)"};
        listaPuertosOrigenComboBox = new JComboBox(puertosOrigen);

        // (JComboBox)
        String[] puertosDestino = {"Valencia (Espa�a)", "Castell�n (Espa�a)", "Barcelona (Espa�a)", "Pireo (Grecia)", "Estambul (Turqu�a)", "Yarimca (Turqu�a)"};
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
        // weighty -> valor mayor, prioridad, ocupa el espacio disponible. A�ado el weighty = 1 al �ltimo
        // componente para que "empuje" a los dem�s hacia arriba, as� consigo que est�n
        // "anclados" en el top del panel, si no, aparecer�an centrados.
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

        // Adici�n de componentes al panel izquierdo (los componentes que le correspondan
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
        // Panel interno para que se vean mejor los bordes y a�adir margen al panel centro.
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

        // (JTextArea) Buques.
        rutaBuquesJTextArea = new JTextArea(10, 1);
        rutaBuquesJTextArea.setEditable(false);
        rutaBuquesJTextArea.setBackground(new Color(0xC0D0EF));
        rutaBuquesJTextArea.setForeground(Color.BLACK);
        rutaBuquesJTextArea.setOpaque(true);
        rutaBuquesJTextArea.setMargin(new Insets(10, 10, 10, 10));

        // Barra de scroll para rutaBuquesJTextArea.
        scrollTextoBuquesJScrollPane = new JScrollPane(rutaBuquesJTextArea);

        // (JButton) iniciar / parar ruta.
        comenzarPararBuquesJButton = new JButton("Iniciar / Parar ruta");
        comenzarPararBuquesJButton.addActionListener(new EventoBotonComenzarPararRuta(rutaBuquesJTextArea));

        // (JButton) parar ruta.
        limpiarPantallaBuquesJButton = new JButton("Limpiar pantalla");
        limpiarPantallaBuquesJButton.setPreferredSize(comenzarPararBuquesJButton.getPreferredSize());
        limpiarPantallaBuquesJButton.addActionListener(new EventoBotonLimpiarPantalla(rutaBuquesJTextArea));
        
        // (JTextArea) Puertos.
        infoPuertosTextoJTextArea = new JTextArea(10, 1);
        infoPuertosTextoJTextArea.setEditable(false);
        infoPuertosTextoJTextArea.setBackground(new Color(0xC0D0EF));
        infoPuertosTextoJTextArea.setForeground(Color.BLACK);
        infoPuertosTextoJTextArea.setOpaque(true);
        infoPuertosTextoJTextArea.setMargin(new Insets(10, 10, 10, 10));

        // (JButton) info puertos.
        infoPuertosJButton = new JButton("Mostrar informaci�n de puertos");
        infoPuertosJButton.addActionListener(new EventoMostrarInfoPuertos(infoPuertosTextoJTextArea));

        // (JButton) para limpiar la pantalla de la informaci�n de los puertos
        limpiarPantallaInfoPuertosJButton = new JButton("Limpiar pantalla");
        limpiarPantallaInfoPuertosJButton.setPreferredSize(infoPuertosJButton.getPreferredSize());
        limpiarPantallaInfoPuertosJButton.addActionListener(new EventoBotonLimpiarPantalla(infoPuertosTextoJTextArea));

        // Barra de scroll para puertos.
        scrollTextoPuertosJScrollPane = new JScrollPane(infoPuertosTextoJTextArea);

        // Imagen, primero se carga como ImageIcon y luego lo paso a
        // Image para poder cambiar el tama�o
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
        // Ruta buques (JScrollPanel Constraint)
        constraintsRutaBuquesJScrollPane = new GridBagConstraints();
        constraintsRutaBuquesJScrollPane.gridx = 0;
        constraintsRutaBuquesJScrollPane.gridy = 0;
        constraintsRutaBuquesJScrollPane.gridwidth = 1;
        constraintsRutaBuquesJScrollPane.gridheight = 1;
        constraintsRutaBuquesJScrollPane.fill = GridBagConstraints.BOTH;
        constraintsRutaBuquesJScrollPane.weightx = 1.0;
        constraintsRutaBuquesJScrollPane.anchor = GridBagConstraints.CENTER;
        constraintsRutaBuquesJScrollPane.insets = new Insets(5, 5, 5, 5);
        constraintsRutaBuquesJScrollPane.weighty = 1.0;
        constraintsRutaBuquesJScrollPane.weightx = 1.0;

        // Info puertos (JScrollPane Constraint)
        constraintsInfoTextoPuertosJScrollPane = new GridBagConstraints();
        constraintsInfoTextoPuertosJScrollPane.gridx = 1;
        constraintsInfoTextoPuertosJScrollPane.gridy = 0;
        constraintsInfoTextoPuertosJScrollPane.gridwidth = 0;
        constraintsInfoTextoPuertosJScrollPane.gridheight = 0;
        constraintsInfoTextoPuertosJScrollPane.fill = GridBagConstraints.BOTH;
        constraintsInfoTextoPuertosJScrollPane.anchor = GridBagConstraints.CENTER;
        constraintsInfoTextoPuertosJScrollPane.insets = new Insets(0, 0, 0, 0);
        constraintsInfoTextoPuertosJScrollPane.weighty = 1.0;
        constraintsInfoTextoPuertosJScrollPane.weightx = 1.0;

        // Imagen buque (ImageIcon Constraints)
        constraintsContenedorImagenCentroBuqueJLabel = new GridBagConstraints();
        constraintsContenedorImagenCentroBuqueJLabel.gridx = 1;
        constraintsContenedorImagenCentroBuqueJLabel.gridy = 0;
        constraintsContenedorImagenCentroBuqueJLabel.gridwidth = 0;
        constraintsContenedorImagenCentroBuqueJLabel.gridheight = 0;
        constraintsContenedorImagenCentroBuqueJLabel.anchor = GridBagConstraints.EAST;
        constraintsContenedorImagenCentroBuqueJLabel.insets = new Insets(40, 40, 170, 30);
        constraintsContenedorImagenCentroBuqueJLabel.weighty = 0;
        constraintsContenedorImagenCentroBuqueJLabel.weightx = 0;

        // Boton comenzar (JButton Constraint)
        constraintsComenzarPararBuquesJButton = new GridBagConstraints();
        constraintsComenzarPararBuquesJButton.gridx = 1;
        constraintsComenzarPararBuquesJButton.gridy = 0;
        constraintsComenzarPararBuquesJButton.gridwidth = 1;
        constraintsComenzarPararBuquesJButton.gridheight = 1;
        constraintsComenzarPararBuquesJButton.anchor = GridBagConstraints.NORTH;
        constraintsComenzarPararBuquesJButton.insets = new Insets(170,65, 5, 5);
        constraintsComenzarPararBuquesJButton.weighty = 0;

        // Boton limpiar info rutas(JButton Constraint)
        constraintsLimpiarPantallaBuquesJButton = new GridBagConstraints();
        constraintsLimpiarPantallaBuquesJButton.gridx = 1;
        constraintsLimpiarPantallaBuquesJButton.gridy = 0;
        constraintsLimpiarPantallaBuquesJButton.gridwidth = 1;
        constraintsLimpiarPantallaBuquesJButton.gridheight = 1;
        constraintsLimpiarPantallaBuquesJButton.anchor = GridBagConstraints.NORTH;
        constraintsLimpiarPantallaBuquesJButton.insets = new Insets(220, 65, 5, 5);
        constraintsLimpiarPantallaBuquesJButton.weighty = 1;

        // Boton info puertos (JButton Constraint)
        constraintsInfoPuertosJButton = new GridBagConstraints();
        constraintsInfoPuertosJButton.gridx = 0;
        constraintsInfoPuertosJButton.gridy = 1;
        constraintsInfoPuertosJButton.gridwidth = 1;
        constraintsInfoPuertosJButton.gridheight = 1;
        constraintsInfoPuertosJButton.anchor = GridBagConstraints.NORTH;
        constraintsInfoPuertosJButton.insets = new Insets(185, 0, 0, 20);
        constraintsInfoPuertosJButton.weighty = 0;
        constraintsInfoPuertosJButton.weightx = 0;
        
        // Boton limpiar pantalla info puertos (JButton Constraint)
        constraintsLimpiarPantallaInfoPuertosJButton = new GridBagConstraints();
        constraintsLimpiarPantallaInfoPuertosJButton.gridx = 0;
        constraintsLimpiarPantallaInfoPuertosJButton.gridy = 2;
        constraintsLimpiarPantallaInfoPuertosJButton.gridwidth = 1;
        constraintsLimpiarPantallaInfoPuertosJButton.gridheight = 1;
        constraintsLimpiarPantallaInfoPuertosJButton.anchor = GridBagConstraints.NORTH;
        constraintsLimpiarPantallaInfoPuertosJButton.insets = new Insets(20, 0, 10, 20);
        constraintsLimpiarPantallaInfoPuertosJButton.weighty = 0;
        constraintsLimpiarPantallaInfoPuertosJButton.weightx = 0;

        // Imagen Puerto (ImageIcon Constraints)
        constraintsContenedorImagenCentroPuertoJLabel = new GridBagConstraints();
        constraintsContenedorImagenCentroPuertoJLabel.gridx = 0;
        constraintsContenedorImagenCentroPuertoJLabel.gridy = 0;
        constraintsContenedorImagenCentroPuertoJLabel.gridwidth = 0;
        constraintsContenedorImagenCentroPuertoJLabel.gridheight = 0;
        constraintsContenedorImagenCentroPuertoJLabel.anchor = GridBagConstraints.WEST;
        constraintsContenedorImagenCentroPuertoJLabel.insets = new Insets(50, 55, 140, 750);
        constraintsContenedorImagenCentroPuertoJLabel.weighty = 0;
        constraintsContenedorImagenCentroPuertoJLabel.weightx = 0;

        // Adici�n de componentes al panel de centro-abajo
        panelComponenetesInternoCentroAbajoJPanel.add(contenedorImagenCentroPuertoJLabel, constraintsContenedorImagenCentroPuertoJLabel);
        panelComponenetesInternoCentroAbajoJPanel.add(infoPuertosJButton, constraintsInfoPuertosJButton);
        panelComponenetesInternoCentroAbajoJPanel.add(limpiarPantallaInfoPuertosJButton, constraintsLimpiarPantallaInfoPuertosJButton);
        panelComponenetesInternoCentroAbajoJPanel.add(scrollTextoPuertosJScrollPane, constraintsInfoTextoPuertosJScrollPane);

        // Adici�n de componentes al panel de centro-arriba
        panelComponenetesInternoCentroArribaJPanel.add(scrollTextoBuquesJScrollPane, constraintsRutaBuquesJScrollPane);
        panelComponenetesInternoCentroArribaJPanel.add(contenedorImagenCentroBuqueJLabel, constraintsContenedorImagenCentroBuqueJLabel);
        panelComponenetesInternoCentroArribaJPanel.add(comenzarPararBuquesJButton, constraintsComenzarPararBuquesJButton);
        panelComponenetesInternoCentroArribaJPanel.add(limpiarPantallaBuquesJButton, constraintsLimpiarPantallaBuquesJButton);

        panelComponenetesInternoCentroArribaJPanel.setVisible(true);

        // Se a�ade el panel de componentes al del centro
        ladoCentroJPanel.add(panelComponenetesInternoCentroAbajoJPanel, BorderLayout.SOUTH);
        ladoCentroJPanel.add(panelComponenetesInternoCentroArribaJPanel, BorderLayout.NORTH);

        // Se a�ade el panel del centro a su contenedor interno.
        ladoCentroInternoJPanel.add(ladoCentroJPanel, BorderLayout.CENTER);

        // Adici�n de paneles al JFrame principal.
        // Como el panel principal utiliza BorderLayout, se pueden colocar los paneles en 
        // NORTH, EAST, SOUTH, WEST, CENTER.
        this.add(ladoIzquierdoInternoJPanel, BorderLayout.WEST);
        this.add(ladoCentroInternoJPanel, BorderLayout.CENTER);

        // Para no cambiar el tama�o (me rompe la posici�n de los componentes :) ).
        this.setResizable(true);

        // Para que al comenzar la aplicaci�n, el JFrame principal
        // aparezca en el centro de la pantalla. Sin esto, aparecer�a
        // arriba a la izquierda.
        this.setLocationRelativeTo(null);

        // Sin esto, no se ver�a el JFrame al iniciar la aplicaci�n.
        this.setVisible(true);
    }
}