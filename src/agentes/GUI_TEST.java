package agentes;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Fran <6W>
 */

public class GUI_TEST extends JFrame implements ActionListener {
    
    JComboBox listaNavieras;
    JComboBox listaPuertos;
    
    public GUI_TEST() {
        
        this.setTitle("Gesti�n Portuaria");
        this.getContentPane().setBackground(new Color(0x649EFF));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        ImageIcon icono = new ImageIcon("buqueIcono.png");
        this.setIconImage(icono.getImage());
        
        String[] navieras = {"Arkas", "Maersk", "CMA"};
        listaNavieras = new JComboBox(navieras);
        
        String[] puertos = {"Valencia (Espa�a)", "Castell�n (Espa�a)", "Barcelona (Espa�a)", "Pireo (Grecia)", "Estambul (Turqu�a)", "Yarimca (Turqu�a)"};
        listaPuertos = new JComboBox(puertos);
        
        this.add(listaNavieras);
        this.add(listaPuertos);
        this.setSize(1400, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
