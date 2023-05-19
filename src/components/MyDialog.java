package components;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.Spring.height;

public class MyDialog extends JDialog {
    
    public MyDialog() {
//        setSize( new Dimension( width, height ) );
//        setLocationRelativeTo( this );
        
        setModal( true );
//        setVisible( true );
    }
    
}
