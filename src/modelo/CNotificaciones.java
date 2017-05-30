package modelo;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CNotificaciones {

    private JLabel representacionNotificacion;
    private JPanel contenedorNotificaciones;
    private GridBagConstraints gbc;
    private static int auxiliar1 = 0,auxiliar2 = 0;

    public CNotificaciones(JPanel original){
        
        contenedorNotificaciones = original;
        contenedorNotificaciones.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);

    }
    
    public void setNotificacion(String textoNotificacion,String toolTip, ImageIcon urlImagen){
        
        gbc.gridx = auxiliar1; // El área de texto empieza en la columna cero.
        gbc.gridy = auxiliar2; // El área de texto empieza en la fila cero
        
        gbc.weighty = 1.0;
        gbc.weightx = 5.0; 
        
        representacionNotificacion = new JLabel();
        representacionNotificacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        representacionNotificacion.setFont(new Font("Times New Roman", Font.BOLD, 14));
        representacionNotificacion.setText(textoNotificacion);
        representacionNotificacion.setToolTipText(toolTip);
        representacionNotificacion.setName(textoNotificacion);
        representacionNotificacion.setVerticalTextPosition(JLabel.BOTTOM);
        representacionNotificacion.setHorizontalTextPosition(JLabel.CENTER);
        representacionNotificacion.setIcon(urlImagen);
        
        contenedorNotificaciones.add(representacionNotificacion,gbc);
        
        auxiliar1 ++;
        
        if(auxiliar1 == 5){
            auxiliar1 = 0;
            auxiliar2 ++;
        }
        
        contenedorNotificaciones.repaint();
        
    }
    
}
