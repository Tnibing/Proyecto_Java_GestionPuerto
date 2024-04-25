package gui;

import agentes.Buque;
import controladoresEventos.EventoBotonAddContenedor;
import controladoresEventos.EventoBotonComenzarPararRuta;
import controladoresEventos.EventoBotonGenerarArchivo;
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
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;
import rutas.Puerto;
import rutas.Ruta;

/**
 *
 * @author Fran <6W>
 */

public class GUI extends JFrame {
    
    // Datos que maneja la interfaz gráfica.
    // Los guardo aquí y le paso la referencia a los controladores
    // para que los cambios se hagan sobre las mismas instancias
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

    // Todos los componentes que se van a usar en la interfaz gráfica.
    
    // PANEL IZQUIERDO
    
    // Botones con listas desplegables PANEL IZQUIERDO.
    private JComboBox listaNavierasComboBox;
    private JComboBox listaPuertosOrigenComboBox;
    private JComboBox listaPuertosDestinoComboBox;
    
    //Botones PANEL IZQUIERDO
    private JButton botonAddContenedoresJButton;
    private JButton botonGenerarArchivoJButton;
    
    // Inserción de texto y formateo (solo acepta números) PANEL IZQUIERDO
    private JFormattedTextField numeroDeContenedoresJFormattedTextField;
    private NumberFormatter formateadorJFormattedTextField;
    
    // Inserción de texto para strings PANEL IZQUIERDO
    private JTextField nombreDeArchivoGeneradoJTextField;
    
    // Posicionamiento de componentes (Constraints) PANEL IZQUIERDO.
    private GridBagConstraints constrainsListaPuertosOrigenComboBox;
    private GridBagConstraints constrainsListaPuertosDestinoComboBox;
    private GridBagConstraints constraintsSeleccionPuertoOrigenJLabel;
    private GridBagConstraints constraintsSeleccionNavieraJLabel;
    private GridBagConstraints constraintsListaNavierasComboBox;
    private GridBagConstraints constraintsSeleccionPuertoDestinoJLabel;
    private GridBagConstraints constraintsAddContenedoresJFormattedTextField;
    private GridBagConstraints constraintsBotonAddContenedoresJButton;
    private GridBagConstraints constraintsNumeroDeContenedoresJLabel;
    private GridBagConstraints constraintsInputNombreArchivoRegistroJLabel;
    private GridBagConstraints constraintsNombreDeArchivoGeneradoJTextField;
    private GridBagConstraints constraintsBotonGenerarArchivoJButton;

    // Texto PANEL IZQUIERDO.
    private JLabel seleccionPuertoOrigenJLabel;
    private JLabel seleccionPuertoDestinoJLabel;
    private JLabel seleccionNavieraJLabel;
    private JLabel numeroDeContenedoresJLabel;
    private JLabel inputNombreArchivoRegistroJLabel;
    
    // JLabel para imágenes PANEL IZQUIERDO
    private JLabel contenedorImagenIzquierdaLogoJLabel;
    
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

    // JLabel para imágenes PANEL CENTRO.
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
    private GridBagConstraints constraintsContenedorImagenIzquierdaLogoJLabel;

    // PANELES.
    private JPanel ladoIzquierdoInternoJPanel;
    private JPanel ladoIzquierdoJPanel;
    private JPanel ladoCentroInternoJPanel;
    private JPanel ladoCentroJPanel;
    private JPanel panelComponenetesInternoCentroArribaJPanel;
    private JPanel panelComponenetesInternoCentroAbajoJPanel;

    public GUI() {

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
        // El panel del centro tapa el color, añado este color al panel del centro (al crear el panel central más abajo).
        // También añado unos márgenes para que se vea este color de fondo
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
        listaNavierasComboBox.setPreferredSize(new Dimension(156, 26));

        // (JComboBox)
        String[] puertosOrigen = {"Valencia España", "Castellón España", "Barcelona España", "Pireo Grecia", "Estambul Turquía", "Yarimca Turquía"};
        listaPuertosOrigenComboBox = new JComboBox(puertosOrigen);
        listaPuertosOrigenComboBox.setPreferredSize(new Dimension(156, 26));

        // (JComboBox)
        String[] puertosDestino = {"Valencia España", "Castellón España", "Barcelona España", "Pireo Grecia", "Estambul Turquía", "Yarimca Turquía"};
        listaPuertosDestinoComboBox = new JComboBox(puertosDestino);
        listaPuertosDestinoComboBox.setPreferredSize(new Dimension(156, 26));

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
        
        // (JLabel)
        numeroDeContenedoresJLabel = new JLabel();
        numeroDeContenedoresJLabel.setText("Número de contenedores:");
        numeroDeContenedoresJLabel.setForeground(Color.WHITE);
        
        // (JLabel)
        inputNombreArchivoRegistroJLabel = new JLabel();
        inputNombreArchivoRegistroJLabel.setText("Nombre del archivo:");
        inputNombreArchivoRegistroJLabel.setForeground(Color.WHITE);

        // Formateo para que solo acepte enteros el JFormattedTextField
        formateadorJFormattedTextField = new NumberFormatter();
        formateadorJFormattedTextField.setValueClass(Integer.class);
        formateadorJFormattedTextField.setMinimum(0);
        formateadorJFormattedTextField.setAllowsInvalid(false);

        // (JFormattedTextField) para la selección del número de contenedores que añadir
        numeroDeContenedoresJFormattedTextField = new JFormattedTextField(formateadorJFormattedTextField);
        numeroDeContenedoresJFormattedTextField.setPreferredSize(new Dimension(156, 26));
        
        // (JButton) botón para añadir contenedores
        botonAddContenedoresJButton = new JButton("Añadir contenedor/es");
        botonAddContenedoresJButton.addActionListener(new EventoBotonAddContenedor(listaPuertosOrigenComboBox, listaPuertosDestinoComboBox, 
                                                                                                                                           listaNavierasComboBox, numeroDeContenedoresJFormattedTextField, 
                                                                                                                                           p1, p2, p3, p4, p5, p6));

        // (JTextField) inserción del nombre del archivo que se va a generar
        nombreDeArchivoGeneradoJTextField = new JTextField();
        nombreDeArchivoGeneradoJTextField.setPreferredSize(botonAddContenedoresJButton.getPreferredSize());
        
        // (JButton) botón para generar archivo
        botonGenerarArchivoJButton = new JButton("Generar bitácora");
        botonGenerarArchivoJButton.setPreferredSize(botonAddContenedoresJButton.getPreferredSize());


        // Imagen, primero se carga como ImageIcon y luego lo paso a
        // Image para poder cambiar el tamaño
        ImageIcon iconoApp = new ImageIcon("logoAPP4.png");
        Image iconoAppOriginal = iconoApp.getImage();
        Image iconoAppImgEscalada = iconoAppOriginal.getScaledInstance(70, 80, Image.SCALE_SMOOTH);
        ImageIcon iconoAppFinal = new ImageIcon(iconoAppImgEscalada);
        
        contenedorImagenIzquierdaLogoJLabel = new JLabel(iconoAppFinal);
        
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
        constraintsSeleccionNavieraJLabel.insets = new Insets(25, 5, 5, 5);
        constraintsSeleccionNavieraJLabel.weighty = 0;

        // Lista de navieras (JComboBox Constraint).
        constraintsListaNavierasComboBox = new GridBagConstraints();
        constraintsListaNavierasComboBox.gridx = 0;
        constraintsListaNavierasComboBox.gridy = 5;
        constraintsListaNavierasComboBox.gridwidth = 1;
        constraintsListaNavierasComboBox.gridheight = 1;
        constraintsListaNavierasComboBox.anchor = GridBagConstraints.NORTH;
        constraintsListaNavierasComboBox.insets = new Insets(5, 5, 5, 5);
        constraintsListaNavierasComboBox.weighty = 0;
        
        // "Número de contenedores" (JLabelConstraint)
        constraintsNumeroDeContenedoresJLabel = new GridBagConstraints();
        constraintsNumeroDeContenedoresJLabel = new GridBagConstraints();
        constraintsNumeroDeContenedoresJLabel.gridx = 0;
        constraintsNumeroDeContenedoresJLabel.gridy = 6;
        constraintsNumeroDeContenedoresJLabel.gridwidth = 1;
        constraintsNumeroDeContenedoresJLabel.gridheight = 1;
        constraintsNumeroDeContenedoresJLabel.anchor = GridBagConstraints.NORTH;
        constraintsNumeroDeContenedoresJLabel.insets = new Insets(50, 5, 5, 5);
        constraintsNumeroDeContenedoresJLabel.weighty = 0;

        // Área de texto para el número de contenedores (JFormattedTextField Constraint)
        constraintsAddContenedoresJFormattedTextField = new GridBagConstraints();
        constraintsAddContenedoresJFormattedTextField = new GridBagConstraints();
        constraintsAddContenedoresJFormattedTextField.gridx = 0;
        constraintsAddContenedoresJFormattedTextField.gridy = 7;
        constraintsAddContenedoresJFormattedTextField.gridwidth = 1;
        constraintsAddContenedoresJFormattedTextField.gridheight = 1;
        constraintsAddContenedoresJFormattedTextField.anchor = GridBagConstraints.NORTH;
        constraintsAddContenedoresJFormattedTextField.insets = new Insets(5, 5, 5, 5);
        constraintsAddContenedoresJFormattedTextField.weighty = 0;

        // Botón para añadir contenedores (JButton Constraint)
        constraintsBotonAddContenedoresJButton = new GridBagConstraints();
        constraintsBotonAddContenedoresJButton = new GridBagConstraints();
        constraintsBotonAddContenedoresJButton.gridx = 0;
        constraintsBotonAddContenedoresJButton.gridy = 8;
        constraintsBotonAddContenedoresJButton.gridwidth = 1;
        constraintsBotonAddContenedoresJButton.gridheight = 1;
        constraintsBotonAddContenedoresJButton.anchor = GridBagConstraints.NORTH;
        constraintsBotonAddContenedoresJButton.insets = new Insets(5, 5, 5, 5);
        constraintsBotonAddContenedoresJButton.weighty = 0;
        
        // JLabel indicando nombre del archivo (JLabel Constraint)
        constraintsInputNombreArchivoRegistroJLabel = new GridBagConstraints();
        constraintsInputNombreArchivoRegistroJLabel = new GridBagConstraints();
        constraintsInputNombreArchivoRegistroJLabel.gridx = 0;
        constraintsInputNombreArchivoRegistroJLabel.gridy = 9;
        constraintsInputNombreArchivoRegistroJLabel.gridwidth = 1;
        constraintsInputNombreArchivoRegistroJLabel.gridheight = 1;
        constraintsInputNombreArchivoRegistroJLabel.anchor = GridBagConstraints.NORTH;
        constraintsInputNombreArchivoRegistroJLabel.insets = new Insets(50, 5, 5, 5);
        constraintsInputNombreArchivoRegistroJLabel.weighty = 0;
        
        // Campo para que el usuario ponga el nombre del archivo (JTextField Constraint)
        constraintsNombreDeArchivoGeneradoJTextField = new GridBagConstraints();
        constraintsNombreDeArchivoGeneradoJTextField = new GridBagConstraints();
        constraintsNombreDeArchivoGeneradoJTextField.gridx = 0;
        constraintsNombreDeArchivoGeneradoJTextField.gridy = 10;
        constraintsNombreDeArchivoGeneradoJTextField.gridwidth = 1;
        constraintsNombreDeArchivoGeneradoJTextField.gridheight = 1;
        constraintsNombreDeArchivoGeneradoJTextField.anchor = GridBagConstraints.NORTH;
        constraintsNombreDeArchivoGeneradoJTextField.insets = new Insets(5, 5, 5, 5);
        constraintsNombreDeArchivoGeneradoJTextField.weighty = 0;
        
        // Contraints del botón para generar arhivos (JButton Constraint)
        constraintsBotonGenerarArchivoJButton = new GridBagConstraints();
        constraintsBotonGenerarArchivoJButton = new GridBagConstraints();
        constraintsBotonGenerarArchivoJButton.gridx = 0;
        constraintsBotonGenerarArchivoJButton.gridy = 11;
        constraintsBotonGenerarArchivoJButton.gridwidth = 1;
        constraintsBotonGenerarArchivoJButton.gridheight = 1;
        constraintsBotonGenerarArchivoJButton.anchor = GridBagConstraints.NORTH;
        constraintsBotonGenerarArchivoJButton.insets = new Insets(5, 5, 5, 5);
        constraintsBotonGenerarArchivoJButton.weighty = 0;
        
        // Constraints del contenedor de la imagen del logo (JLabel Constraints)
        constraintsContenedorImagenIzquierdaLogoJLabel = new GridBagConstraints();
        constraintsContenedorImagenIzquierdaLogoJLabel = new GridBagConstraints();
        constraintsContenedorImagenIzquierdaLogoJLabel.gridx = 0;
        constraintsContenedorImagenIzquierdaLogoJLabel.gridy = 12;
        constraintsContenedorImagenIzquierdaLogoJLabel.gridwidth = 1;
        constraintsContenedorImagenIzquierdaLogoJLabel.gridheight = 1;
        constraintsContenedorImagenIzquierdaLogoJLabel.anchor = GridBagConstraints.NORTH;
        constraintsContenedorImagenIzquierdaLogoJLabel.insets = new Insets(35, 5, 5, 5);
        constraintsContenedorImagenIzquierdaLogoJLabel.weighty = 1;
                

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
        ladoIzquierdoJPanel.add(numeroDeContenedoresJLabel, constraintsNumeroDeContenedoresJLabel);
        ladoIzquierdoJPanel.add(numeroDeContenedoresJFormattedTextField, constraintsAddContenedoresJFormattedTextField);
        ladoIzquierdoJPanel.add(botonAddContenedoresJButton, constraintsBotonAddContenedoresJButton);
        ladoIzquierdoJPanel.add(inputNombreArchivoRegistroJLabel, constraintsInputNombreArchivoRegistroJLabel);
        ladoIzquierdoJPanel.add(nombreDeArchivoGeneradoJTextField, constraintsNombreDeArchivoGeneradoJTextField);
        ladoIzquierdoJPanel.add(botonGenerarArchivoJButton, constraintsBotonGenerarArchivoJButton);
        ladoIzquierdoJPanel.add(contenedorImagenIzquierdaLogoJLabel, constraintsContenedorImagenIzquierdaLogoJLabel);

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
        comenzarPararBuquesJButton.addActionListener(new EventoBotonComenzarPararRuta(rutaBuquesJTextArea, cinzia, maerskNP, bomar));

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
        infoPuertosJButton = new JButton("Mostrar información de puertos");
        infoPuertosJButton.addActionListener(new EventoMostrarInfoPuertos(infoPuertosTextoJTextArea, ruta));

        // (JButton) para limpiar la pantalla de la información de los puertos
        limpiarPantallaInfoPuertosJButton = new JButton("Limpiar pantalla");
        limpiarPantallaInfoPuertosJButton.setPreferredSize(infoPuertosJButton.getPreferredSize());
        limpiarPantallaInfoPuertosJButton.addActionListener(new EventoBotonLimpiarPantalla(infoPuertosTextoJTextArea));

        // Barra de scroll para puertos.
        scrollTextoPuertosJScrollPane = new JScrollPane(infoPuertosTextoJTextArea);

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
        
        // Como este escuchador necesita un componente que se crea después del boton de generar archivo
        // lo pongo aquí para que tenga acceso a ese botón
        botonGenerarArchivoJButton.addActionListener(new EventoBotonGenerarArchivo(nombreDeArchivoGeneradoJTextField, rutaBuquesJTextArea));

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

        // Adición de componentes al panel de centro-abajo
        panelComponenetesInternoCentroAbajoJPanel.add(contenedorImagenCentroPuertoJLabel, constraintsContenedorImagenCentroPuertoJLabel);
        panelComponenetesInternoCentroAbajoJPanel.add(infoPuertosJButton, constraintsInfoPuertosJButton);
        panelComponenetesInternoCentroAbajoJPanel.add(limpiarPantallaInfoPuertosJButton, constraintsLimpiarPantallaInfoPuertosJButton);
        panelComponenetesInternoCentroAbajoJPanel.add(scrollTextoPuertosJScrollPane, constraintsInfoTextoPuertosJScrollPane);

        // Adición de componentes al panel de centro-arriba
        panelComponenetesInternoCentroArribaJPanel.add(scrollTextoBuquesJScrollPane, constraintsRutaBuquesJScrollPane);
        panelComponenetesInternoCentroArribaJPanel.add(contenedorImagenCentroBuqueJLabel, constraintsContenedorImagenCentroBuqueJLabel);
        panelComponenetesInternoCentroArribaJPanel.add(comenzarPararBuquesJButton, constraintsComenzarPararBuquesJButton);
        panelComponenetesInternoCentroArribaJPanel.add(limpiarPantallaBuquesJButton, constraintsLimpiarPantallaBuquesJButton);

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

        // Sin esto, no se vería el JFrame al iniciar la aplicación.
        this.setVisible(true);
    }
}
