package controladoresEventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Fran <6W>
 */
public class EventoBotonGenerarArchivo implements ActionListener {

    private JTextField nombreArchivoUsuario;
    private JTextArea infoBuques;

    private File archivoFinal;

    private BufferedWriter bw;

    public EventoBotonGenerarArchivo(JTextField nombreArchivoUsuario, JTextArea infoBuques) {

        this.nombreArchivoUsuario = nombreArchivoUsuario;
        this.infoBuques = infoBuques;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String nombreArchivo = nombreArchivoUsuario.getText();
        String infoBuquesTexto = infoBuques.getText();

        if (nombreArchivo.isEmpty() || infoBuquesTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡Necesitas escribir un nombre para el archivo y que existan datos sobre las rutas!", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            
            archivoFinal = new File(nombreArchivo + ".txt");

            try {

                bw = new BufferedWriter(new FileWriter(archivoFinal));
                bw.write(infoBuquesTexto);

                JOptionPane.showMessageDialog(null, "Se ha escrito el archivo \"" + nombreArchivo + "\" en la siguiente ruta:\n" + archivoFinal.getAbsolutePath(), "Confirmado", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, "¡Error al escribir en el archivo!", "Error", JOptionPane.ERROR_MESSAGE);
                
            } finally {
                
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(EventoBotonGenerarArchivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
