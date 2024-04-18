package agentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
    
    public GUI_TEST() {
        
        this.setTitle("Gestión Portuaria");
        this.getContentPane().setBackground(new Color(0x649EFF));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        boton = new JButton("Aceptar");
        
        texto = new JPanel();
        texto.setPreferredSize(new Dimension(65, 65));
        texto.setBackground(new Color(0x649EFF));
        
        ladoIzquierdo = new JPanel();
        
        info = new JTextArea("HOLA");
        info.setEditable(false);
        info.setBackground(Color.red);
        
        texto.add(info);
        
        ImageIcon icono = new ImageIcon("buqueIcono.png");
        this.setIconImage(icono.getImage());
        
        
        String[] navieras = {"Arkas", "Maersk", "CMA"};
        listaNavieras = new JComboBox(navieras);
        
        String[] puertos = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        listaPuertos = new JComboBox(puertos);
        
        
        ladoIzquierdo.setBackground(Color.WHITE);
        ladoIzquierdo.add(listaPuertos);
        ladoIzquierdo.add(listaNavieras);

        this.add(texto, BorderLayout.CENTER);
        this.add(ladoIzquierdo, BorderLayout.WEST);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
