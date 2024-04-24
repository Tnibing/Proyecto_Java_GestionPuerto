package controladoresEventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author Fran <6W>
 */

public class EventoBotonLimpiarPantalla implements ActionListener {
    
    private JTextArea texto;
    
    public EventoBotonLimpiarPantalla(JTextArea texto) {
        this.texto = texto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        texto.setText("");
    }
}
