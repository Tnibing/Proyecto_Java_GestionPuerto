package controladoresEventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author Fran <6W>
 */

public class EventoMostrarInfoPuertos implements ActionListener {
    
    private JTextArea texto;
    
    public EventoMostrarInfoPuertos(JTextArea texto) {
        this.texto = texto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        texto.append("Test botón info puertos\n");
        
    }
    
}
