/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Salah
 */
public class MyLabel extends JLabel {

    public MyLabel( String text ) {
        setText( text );
        setPreferredSize( new Dimension( 150, 50 ) );
        setHorizontalAlignment( SwingConstants.CENTER );
    }
    
}
