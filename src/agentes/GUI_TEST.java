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

    private JComboBox listaNavieras;
    private JComboBox listaPuertos;
    private JPanel ladoIzquierdo;
    private GridBagConstraints constrainsListaPuertos;
    private GridBagConstraints constrainsListaPuertos2;
    private JLabel seleccionPuertoOrigen;
    private GridBagConstraints seleccionPOrigen;
    private JLabel seleccionPuertoDestino;
    private GridBagConstraints seleccionPDestino;
    private JLabel seleccionNaviera;

    public GUI_TEST() {

        this.setTitle("Gestión Portuaria");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(0x649EFF));

        ImageIcon icono = new ImageIcon("buqueIcono.png");
        this.setIconImage(icono.getImage());

        String[] navieras = {"Arkas", "Maersk", "CMA"};
        listaNavieras = new JComboBox(navieras);
        listaNavieras.setPreferredSize(new Dimension(139, 25));

        String[] puertos = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertos = new JComboBox(puertos);
        
        seleccionPuertoOrigen = new JLabel();
        seleccionPuertoOrigen.setText("Selecciona el puerto de origen:");
        
        seleccionPuertoDestino = new JLabel();
        seleccionPuertoDestino.setText("Selecciona el puerto de destino:");
        
        ladoIzquierdo = new JPanel();
        ladoIzquierdo.setLayout(new GridBagLayout());
        
        seleccionPDestino = new GridBagConstraints();
        seleccionPDestino.gridx  = 0;
        seleccionPDestino.gridy = 2;
        seleccionPDestino.gridwidth = 1;
        seleccionPDestino.gridheight = 1;
        seleccionPDestino.anchor = GridBagConstraints.NORTH;
        seleccionPDestino.insets = new Insets(5, 5, 5, 5);
        seleccionPDestino.weighty = 0;
        
        seleccionPOrigen = new GridBagConstraints();
        seleccionPOrigen.gridx  = 0;
        seleccionPOrigen.gridy = 0;
        seleccionPOrigen.gridwidth = 1;
        seleccionPOrigen.gridheight = 1;
        seleccionPOrigen.anchor = GridBagConstraints.NORTH;
        seleccionPOrigen.insets = new Insets(5, 5, 5, 5);
        seleccionPOrigen.weighty = 0;
        
        constrainsListaPuertos = new GridBagConstraints();
        constrainsListaPuertos.gridx  = 0;
        constrainsListaPuertos.gridy = 1;
        constrainsListaPuertos.gridwidth = 1;
        constrainsListaPuertos.gridheight = 1;
        constrainsListaPuertos.anchor = GridBagConstraints.NORTH;
        constrainsListaPuertos.insets = new Insets(5, 5, 5, 5);
        constrainsListaPuertos.weighty = 1;

        constrainsListaPuertos2 = new GridBagConstraints();
        constrainsListaPuertos2.gridx  = 0;
        constrainsListaPuertos2.gridy = 3;
        constrainsListaPuertos2.gridwidth = 1;
        constrainsListaPuertos2.gridheight = 1;
        constrainsListaPuertos2.anchor = GridBagConstraints.NORTH;
        constrainsListaPuertos2.insets = new Insets(5, 5, 5, 5);
        constrainsListaPuertos2.weighty = 20;
        
        ladoIzquierdo.setPreferredSize(new Dimension(290, 800));
        ladoIzquierdo.setBackground(Color.WHITE);
        ladoIzquierdo.add(seleccionPuertoOrigen, seleccionPOrigen);
        ladoIzquierdo.add(listaPuertos, constrainsListaPuertos);
        ladoIzquierdo.add(seleccionPuertoDestino, seleccionPDestino);
        ladoIzquierdo.add(listaPuertos, constrainsListaPuertos2);

        this.add(ladoIzquierdo, BorderLayout.WEST);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
