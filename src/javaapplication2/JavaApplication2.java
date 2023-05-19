/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import components.ButtonEditor;
import components.ButtonRenderer;
import components.MyDialog;
import components.MyFrame;
import components.MyScrollPane;
import components.MyTable;
import components.ScrollBarUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import modules.ItemsC;
import modules.MySQLAdapter;
import modules.SalesInvoicesC;

/**
 *
 * @author Salah
 */
public class JavaApplication2 extends MySQLAdapter {
    MyFrame frame = new MyFrame( "overview", 800, 500 );
    
    JPanel p = new JPanel();
    JButton button = new JButton( "Click Me" );
    JButton conole = new JButton( "a" );
    JButton sales = new JButton( "sales" );

    public JavaApplication2() {
        
        conole.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Console().setVisible(true);
            }
        });
        
        sales.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sales().setVisible( true );
                frame.dispose();
            }
        });
        
        p.add( conole );
        p.add( button );
        p.add( sales );
        frame.add( p );
        
//        frame.pack();
        frame.setVisible( true );
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JavaApplication2 ja2 = new JavaApplication2();
        
//        table.getColumnModel().getColumn( 1 ).setCellRenderer( new ButtonRenderer() );
//        table.getColumnModel().getColumn( 1 ).setCellEditor( new ButtonEditor( new JTextField() ) );
        

//        ja2.displayItems(items, itemsTable );
        


        

//        String myString = "This text will be copied into clipboard";
//        StringSelection stringSelection = new StringSelection(myString);
//        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//        clipboard.setContents(stringSelection, null);
//
//        // Create a Clipboard object using getSystemClipboard() method
//        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
//
//        try {
//            // Get data stored in the clipboard that is in the form of a string (text)
//            System.out.println(c.getData(DataFlavor.stringFlavor));
//        } catch (UnsupportedFlavorException ex) {
//            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(JavaApplication2.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}