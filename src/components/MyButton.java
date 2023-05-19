package components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class MyButton extends JButton {
    
    public MyButton() {
        setContentAreaFilled( false );
        setBorder( new EmptyBorder( 7, 5, 7, 5 ) );
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = ( Graphics2D ) g.create();
        g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        g2.setBackground( getBackground() );
        g2.fill( new RoundRectangle2D.Double( 0, 0, getWidth(), getHeight(), getHeight(), getHeight() ) );
        g2.dispose();
        
        super.paintComponent( g );
    }
    
}
