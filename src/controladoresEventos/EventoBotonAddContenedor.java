package controladoresEventos;

import agentes.Naviera;
import cargas.Contenedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import rutas.Puerto;

/**
 *
 * @author Fran <6W>
 */
public class EventoBotonAddContenedor implements ActionListener {
    
    private Puerto pValencia;
    private Puerto pCastellon;
    private Puerto pBarcelona;
    private Puerto pPireo;
    private Puerto pEstambul;
    private Puerto pYarimca;
    
    private Puerto contenedorPuertoOrigen;
    private Puerto contenedorPuertoDestino;
    
    private Naviera nav;
    private JComboBox naviera;
    
    private Contenedor contenedor;
    
    private int numContenedores;
    private JFormattedTextField numContenedoresParsearEsto;
    
    private JComboBox puertoO;
    private JComboBox puertoD;
    
    public EventoBotonAddContenedor(JComboBox puertoO, JComboBox puertoD, JComboBox naviera, JFormattedTextField num, 
                Puerto pValencia, Puerto pCastellon, Puerto pBarcelona, Puerto pPireo, Puerto pEstambul, Puerto pYarimca) {
        
        this.pValencia = pValencia;
        this.pCastellon = pCastellon;
        this.pBarcelona = pBarcelona;
        this.pPireo = pPireo;
        this.pEstambul = pEstambul;
        this.pYarimca = pYarimca;
        
        numContenedoresParsearEsto = num;
        
        this.naviera = naviera;
        
        this.puertoO = puertoO;
        this.puertoD = puertoD;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Thread hiloAddContenedores = new Thread(() -> {
            
            nav = new Naviera((String)naviera.getSelectedItem());
            
            numContenedores = numContenedoresParsearEsto.getValue() == null ? 0 : (Integer) numContenedoresParsearEsto.getValue();
            
            String seleccionPuertoOrigen = (String) puertoO.getSelectedItem();
            String[] selecPuertoO = seleccionPuertoOrigen.split(" ");
            
            String seleccionPuertoDestino = (String) puertoD.getSelectedItem();
            String[] selecPuertoD = seleccionPuertoDestino.split(" ");
            
            switch (selecPuertoO[0]) {
                
                case "Valencia" -> contenedorPuertoOrigen = pValencia;
                            
                case "Castellón" -> contenedorPuertoOrigen = pCastellon;
                
                case "Barcelona" -> contenedorPuertoOrigen = pBarcelona;
                
                case "Pireo" -> contenedorPuertoOrigen = pPireo;
                
                case "Estambul" -> contenedorPuertoOrigen = pEstambul;
                
                case "Yarimca" -> contenedorPuertoOrigen = pYarimca;
            }
            
            switch (selecPuertoD[0]) {
                
                case "Valencia" -> contenedorPuertoDestino = pValencia;
                            
                case "Castellón" -> contenedorPuertoDestino = pCastellon;
                
                case "Barcelona" -> contenedorPuertoDestino = pBarcelona;
                
                case "Pireo" -> contenedorPuertoDestino = pPireo;
                
                case "Estambul" -> contenedorPuertoDestino = pEstambul;
                
                case "Yarimca" -> contenedorPuertoDestino = pYarimca;
            }
            
            while (numContenedores > 0) {
                
                contenedor = new Contenedor(nav, contenedorPuertoOrigen, contenedorPuertoDestino);
                contenedorPuertoOrigen.addContenedores(contenedor);
                numContenedores--;
            }
            
        });
        
        hiloAddContenedores.start();
    }
}
