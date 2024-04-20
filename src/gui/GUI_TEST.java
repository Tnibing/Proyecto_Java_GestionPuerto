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
    
    // PANEL CENTRO
    
    // Botones "click" PANEL CENTRO.
    private JButton comenzarBuques;
    private JButton pararBuques;
    private JButton infoPuertosBoton;
    
    // Texto PANEL CENTRO.
    private JTextArea rutaBuques;
    private JTextArea infoPuertosTexto;
    private JScrollPane scrollTextoBuques;
    private JScrollPane scrollTextoPuertos;
    
    // JLabel para imágenes PANEL CENTRO.
    private JLabel contenedorImagenCentroBuque;
    private JLabel contenedorImagenCentroPuerto;
    
    // Posicionameinto de componentes (Constraints) PANEL CENTRO
    private GridBagConstraints constraintsRutaBuques;
    private GridBagConstraints constraintsBotonComenzar;
    private GridBagConstraints constraintsBotonParar;
    private GridBagConstraints  constraintsImagenBuque;
    private GridBagConstraints constraintsImagenPuerto;
    private GridBagConstraints constraintsInfoPuertosBoton;
    private GridBagConstraints constraintsInfoPuertosTexto;

    // PANELES.
    private JPanel ladoIzquierdoInterno;
    private JPanel ladoIzquierdo;
    private JPanel ladoCentroInterno;
    private JPanel ladoCentro;
    private JPanel panelComponenetesInternoCentroArriba;
    private JPanel panelComponenetesInternoCentroAbajo;

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
        seleccionPuertoOrigen.setForeground(Color.WHITE);

        // (JLabel)
        seleccionPuertoDestino = new JLabel();
        seleccionPuertoDestino.setText("Puerto de destino:");
        seleccionPuertoDestino.setForeground(Color.WHITE);

        // (JLabel)
        seleccionNaviera = new JLabel();
        seleccionNaviera.setText("Naviera:");
        seleccionNaviera.setForeground(Color.WHITE);

        // En los constraints, gridx = 0 -> primera columna, gridy modifica la fila.
        // Los componentes se colocan todos en la misma columna pero diferente fila.
        // weighty -> valor mayor, prioridad, ocupa el espacio disponible. Añado el weighty = 1 al último
        // componente para que "empuje" a los demás hacia arriba, así consigo que estén
        // "anclados" en el top del panel, si no, aparecerían centrados.
        
        // CONSTRAINTS COMPONENTES PANEL IZQUIERDO
        
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
        ladoCentro.setLayout(new BorderLayout());
        ladoCentro.setBackground(new Color(0x668DC0));
        ladoCentro.setBorder(new BordeRedondo(50));
        ladoCentro.setOpaque(false);
        
        // COMPONENTES DEL PANEL CENTRO
        
        // (JPanel) Panel de los componentes de abajo.
        panelComponenetesInternoCentroAbajo = new JPanel();
        panelComponenetesInternoCentroAbajo.setLayout(new GridBagLayout());
        panelComponenetesInternoCentroAbajo.setOpaque(false);
        
        // (JPanel) Panel de los componentes de arriba.
        panelComponenetesInternoCentroArriba = new JPanel();
        panelComponenetesInternoCentroArriba.setLayout(new GridBagLayout());
        panelComponenetesInternoCentroArriba.setOpaque(false);
        
        // (JButton) info puertos.
        infoPuertosBoton = new JButton("Mostrar información de puertos");
        
        // (JTextArea) Buques.
        rutaBuques = new JTextArea(10, 1);
        rutaBuques.setEditable(true);
        rutaBuques.setPreferredSize(new Dimension(700, 300));
        rutaBuques.setBackground(new Color(0xC0D0EF));
        rutaBuques.setForeground(Color.BLACK);
        rutaBuques.setOpaque(true);
        rutaBuques.setMargin(new Insets(10, 10, 10, 10));
        rutaBuques.setEditable(false);
        
        // Barra de scroll para rutaBuques.
        scrollTextoBuques = new JScrollPane(rutaBuques);
        scrollTextoBuques.setPreferredSize(new Dimension(700, 300));
        
        // (JButton) iniciar ruta.
        comenzarBuques = new JButton("Iniciar ruta");
        comenzarBuques.addActionListener(this);

        // (JButton) parar ruta.
        pararBuques = new JButton("Parar ruta");
        pararBuques.setPreferredSize(comenzarBuques.getPreferredSize());
        
        // (JTextArea) Puertos.
        infoPuertosTexto = new JTextArea(1, 10);
        infoPuertosTexto.setEditable(false);
        infoPuertosTexto.setPreferredSize(new Dimension(700, 300));
        infoPuertosTexto.setBackground(new Color(0xC0D0EF));
        infoPuertosTexto.setForeground(Color.BLACK);
        infoPuertosTexto.setOpaque(true);
        infoPuertosTexto.setMargin(new Insets(10, 10, 10, 10));

        // Barra de scroll para puertos.
        scrollTextoPuertos = new JScrollPane(infoPuertosTexto);
        scrollTextoPuertos.setPreferredSize(new Dimension(700, 300));
        
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
        contenedorImagenCentroBuque = new JLabel(buqueImgFinal);
        
        // Otro JLabel para la otra imagen (puerto)
        contenedorImagenCentroPuerto = new JLabel(puertoImgFinal);
        
        // CONSTRAINTS COMPONENTES PANEL CENTRO 
        
        // Ruta buques (JTextArea Constraint)
        constraintsRutaBuques = new GridBagConstraints();
        constraintsRutaBuques.gridx = 0;
        constraintsRutaBuques.gridy = 0;
        constraintsRutaBuques.gridwidth = 1;
        constraintsRutaBuques.gridheight = 1;
        constraintsRutaBuques.anchor = GridBagConstraints.NORTH;
        constraintsRutaBuques.insets = new Insets(5, 5, 5, 5);
        constraintsRutaBuques.weighty = 0;
        
        // Info puertos (JTextArea Constraint)
        constraintsInfoPuertosTexto = new GridBagConstraints();
        constraintsInfoPuertosTexto.gridx = 1;
        constraintsInfoPuertosTexto.gridy = 1;
        constraintsInfoPuertosTexto.gridwidth = 0;
        constraintsInfoPuertosTexto.gridheight = 0;
        constraintsInfoPuertosTexto.anchor = GridBagConstraints.EAST;
        constraintsInfoPuertosTexto.insets = new Insets(350, 0, 0, 0);
        constraintsInfoPuertosTexto.weighty = 0;
        constraintsInfoPuertosTexto.weightx = 1;
        
        // Imagen buque (ImageIcon Constraints)
        constraintsImagenBuque = new GridBagConstraints();
        constraintsImagenBuque.gridx = 1;
        constraintsImagenBuque.gridy = 0;
        constraintsImagenBuque.gridwidth = 0;
        constraintsImagenBuque.gridheight = 0;
        constraintsImagenBuque.anchor = GridBagConstraints.NORTH;
        constraintsImagenBuque.insets = new Insets(30, 80, 5, 5);
        constraintsImagenBuque.weighty = 0;
        constraintsImagenBuque.weightx = 0;
        
        // Boton comenzar (JButton Constraint)
        constraintsBotonComenzar = new GridBagConstraints();
        constraintsBotonComenzar.gridx = 1;
        constraintsBotonComenzar.gridy = 0;
        constraintsBotonComenzar.gridwidth = 1;
        constraintsBotonComenzar.gridheight = 1;
        constraintsBotonComenzar.anchor = GridBagConstraints.NORTH;
        constraintsBotonComenzar.insets = new Insets(170, 80, 5, 5);
        constraintsBotonComenzar.weighty = 0;
        
        // Boton parar (JButton Constraint)
        constraintsBotonParar = new GridBagConstraints();
        constraintsBotonParar.gridx = 1;
        constraintsBotonParar.gridy = 0;
        constraintsBotonParar.gridwidth = 1;
        constraintsBotonParar.gridheight = 1;
        constraintsBotonParar.anchor = GridBagConstraints.NORTH;
        constraintsBotonParar.insets = new Insets(220, 80, 5, 5);
        constraintsBotonParar.weighty = 1;
        
        // Boton info puertos (JButton Constraint)
        constraintsInfoPuertosBoton = new GridBagConstraints();
        constraintsInfoPuertosBoton.gridx = 0;
        constraintsInfoPuertosBoton.gridy = 1;
        constraintsInfoPuertosBoton.gridwidth = 1;
        constraintsInfoPuertosBoton.gridheight = 1;
        constraintsInfoPuertosBoton.anchor = GridBagConstraints.WEST;
        constraintsInfoPuertosBoton.insets = new Insets(520, 0, 0, 20);
        constraintsInfoPuertosBoton.weighty = 1;
        constraintsInfoPuertosBoton.weightx = 0;
        
        // Imagen Puerto (ImageIcon Constraints)
        constraintsImagenPuerto = new GridBagConstraints();
        constraintsImagenPuerto.gridx = 0;
        constraintsImagenPuerto.gridy = 0;
        constraintsImagenPuerto.gridwidth = 0;
        constraintsImagenPuerto.gridheight = 0;
        constraintsImagenPuerto.anchor = GridBagConstraints.SOUTH;
        constraintsImagenPuerto.insets = new Insets(100, 20, 140, 750);
        constraintsImagenPuerto.weighty = 0;
        constraintsImagenPuerto.weightx = 0;
        
        // Adición de componentes al panel de centro-abajo
        panelComponenetesInternoCentroAbajo.add(contenedorImagenCentroPuerto, constraintsImagenPuerto);
        panelComponenetesInternoCentroAbajo.add(scrollTextoPuertos, constraintsInfoPuertosTexto);
        panelComponenetesInternoCentroAbajo.add(infoPuertosBoton, constraintsInfoPuertosBoton);
        
        // Adición de componentes al panel de centro-arriba
        panelComponenetesInternoCentroArriba.add(scrollTextoBuques, constraintsRutaBuques);
        panelComponenetesInternoCentroArriba.add(contenedorImagenCentroBuque, constraintsImagenBuque);
        panelComponenetesInternoCentroArriba.add(comenzarBuques, constraintsBotonComenzar);
        panelComponenetesInternoCentroArriba.add(pararBuques, constraintsBotonParar);
        
        panelComponenetesInternoCentroArriba.setVisible(true);
        
        // Se añade el panel de componentes al del centro
        ladoCentro.add(panelComponenetesInternoCentroAbajo, BorderLayout.SOUTH);
        ladoCentro.add(panelComponenetesInternoCentroArriba, BorderLayout.NORTH);
        
        // Se añade el panel del centro a su contenedor interno.
        ladoCentroInterno.add(ladoCentro, BorderLayout.CENTER);
        
        // Adición de paneles al JFrame principal.
        // Como el panel principal utiliza BorderLayout, se pueden colocar los paneles en 
        // NORTH, EAST, SOUTH, WEST, CENTER.
        this.add(ladoIzquierdoInterno, BorderLayout.WEST);
        this.add(ladoCentroInterno, BorderLayout.CENTER);
        
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

        if (e.getSource() == comenzarBuques) {
            
            SwingUtilities.invokeLater(new Runnable() {
                
                @Override
                public void run() {
                    rutaBuques.append("Test\n");
                }
            });
        }
    }
    
    /*
    private void actualizarHilo(String text, Component component){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
                public void run() {
                    if (component instanceof JTextArea){
                        ((JTextArea) component).append(text);
                        component.revalidate();
                        component.repaint();
                        System.out.println(rutaBuques.getText());
                                }                      
                            }
                        }
                    );
                }
*/
}
