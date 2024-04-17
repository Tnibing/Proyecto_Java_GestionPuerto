package agentes;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author Fran <6W>
 */
public class GUI_TEST extends JFrame implements ActionListener {
    
    JButton boton;
    JCheckBox seleccion;
    
    public GUI_TEST() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        String[] navieras = {"Arkas", "Maersk", "CMA"};
        JComboBox listaNavieras = new JComboBox(navieras);
        
        String[] puertos = {"Valencia (España)", "Castellón (España)", "Barcelona (España)", "Pireo (Grecia)", "Estambul (Turquía)", "Yarimca (Turquía)"};
        JComboBox listaPuertos = new JComboBox(puertos);
        
        this.add(listaNavieras);
        this.add(listaPuertos);
        this.pack();
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
