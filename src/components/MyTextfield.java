package components;

import java.awt.Dimension;
import javax.swing.JTextField;

public class MyTextfield extends JTextField {

    public MyTextfield() {
        setPreferredSize( new Dimension( 150, 25 ) );
        setHorizontalAlignment( JTextField.CENTER );
    }
    
}
