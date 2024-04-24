package controladoresEventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import rutas.Puerto;
import rutas.Ruta;

/**
 *
 * @author Fran <6W>
 */

public class EventoMostrarInfoPuertos implements ActionListener {
    
    private JTextArea texto;
    private Ruta ruta;
    
    public EventoMostrarInfoPuertos(JTextArea texto, Ruta ruta) {
        this.texto = texto;
        this.ruta = ruta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (Puerto p : ruta.getPuertos()) {
            texto.append(p.toString() + "\n");
        }
        
        texto.append(String.format("%s\n\n", "-".repeat(100)));
        
        texto.setCaretPosition(texto.getDocument().getLength());
        
    }
    
}
