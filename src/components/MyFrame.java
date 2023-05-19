package components;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    
    public MyFrame( String title, int width, int height ) {
        
//        setLayout( new BorderLayout( 10, 5 ) );
        setTitle( title );
        setSize( width, height );
        setLocationRelativeTo( this );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
    }
}
