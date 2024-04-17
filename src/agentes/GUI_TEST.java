package agentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
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
    
    public GUI_TEST() {
        
        this.setTitle("Gestión Portuaria");
        this.getContentPane().setBackground(new Color(0x649EFF));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        boton = new JButton("Aceptar");
        
        info = new JTextArea();
        info.setEditable(false);
        
        ImageIcon icono = new ImageIcon("buqueIcono.png");
        this.setIconImage(icono.getImage());
        
        /*
        String[] navieras = {"Arkas", "Maersk", "CMA"};
        listaNavieras = new JComboBox(navieras);
        
        String[] puertos = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertos = new JComboBox(puertos);
        */
        
        this.add(boton, BorderLayout.EAST);
        this.add(new JScrollPane(info), BorderLayout.CENTER);
        //this.add(listaNavieras, BorderLayout.NORTH);
        //this.add(listaPuertos);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
