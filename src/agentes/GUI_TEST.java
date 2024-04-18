package agentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Fran <6W>
 */
public class GUI_TEST extends JFrame implements ActionListener {

    private JComboBox listaNavieras;
    private JComboBox listaPuertos;
    private JButton boton;
    private JTextArea info;
    private JPanel texto;
    private JPanel ladoIzquierdo;
    private JPanel centro;
    private GridBagConstraints constrainsListaPuertos;
    private GridBagConstraints constrainsListaNavieras;

    public GUI_TEST() {

        this.setTitle("Gestión Portuaria");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        boton = new JButton("Aceptar");

        centro = new JPanel();
        centro.setBackground(new Color(0x649EFF));
        centro.add(boton);

        texto = new JPanel();
        texto.setPreferredSize(new Dimension(65, 65));
        texto.setBackground(new Color(0x649EFF));

        info = new JTextArea("HOLA");
        info.setEditable(false);
        info.setBackground(Color.red);

        texto.add(info);

        ImageIcon icono = new ImageIcon("buqueIcono.png");
        this.setIconImage(icono.getImage());

        String[] navieras = {"Arkas", "Maersk", "CMA"};
        listaNavieras = new JComboBox(navieras);
        listaNavieras.setPreferredSize(new Dimension(139, 25));

        String[] puertos = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertos = new JComboBox(puertos);

        ladoIzquierdo = new JPanel();
        ladoIzquierdo.setLayout(new GridBagLayout());
        
        constrainsListaPuertos = new GridBagConstraints();
        constrainsListaPuertos.gridx  = 0;
        constrainsListaPuertos.gridy = 0;
        constrainsListaPuertos.gridwidth = 1;
        constrainsListaPuertos.gridheight = 1;
        constrainsListaPuertos.anchor = GridBagConstraints.NORTH;
        constrainsListaPuertos.insets = new Insets(5, 5, 5, 5);
        constrainsListaPuertos.weighty = 0;

        constrainsListaNavieras = new GridBagConstraints();
        constrainsListaNavieras.gridx  = 0;
        constrainsListaNavieras.gridy = 1;
        constrainsListaNavieras.gridwidth = 1;
        constrainsListaNavieras.gridheight = 1;
        constrainsListaNavieras.anchor = GridBagConstraints.NORTH;
        constrainsListaNavieras.insets = new Insets(5, 5, 5, 5);
        constrainsListaNavieras.weighty = 1;
        
        ladoIzquierdo.setPreferredSize(new Dimension(290, 800));
        ladoIzquierdo.setBackground(Color.WHITE);
        ladoIzquierdo.add(listaPuertos, constrainsListaPuertos);
        ladoIzquierdo.add(listaNavieras, constrainsListaNavieras);

        this.add(texto, BorderLayout.CENTER);
        this.add(ladoIzquierdo, BorderLayout.WEST);
        this.add(centro, BorderLayout.CENTER);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
