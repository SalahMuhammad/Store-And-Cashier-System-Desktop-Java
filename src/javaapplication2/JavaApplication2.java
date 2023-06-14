package javaapplication2;

import components.MyFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
//import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modules.MySQLAdapter;

public class JavaApplication2 /*extends Authenticator*/ {
    MyFrame frame = new MyFrame( "overview", 800, 500 );
    
    JPanel p = new JPanel();
    JButton button = new JButton( "Click Me" );
    JButton conole = new JButton( "a" );
    JButton sales = new JButton( "sales" );
    
    Properties porps = new Properties();

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
        
    }
    
    public static void main(String[] args) {
        JavaApplication2 ja2 = new JavaApplication2();
        
        try {
            Scanner s = new Scanner( new File( "C:/Program Files/s" ) );
            
            while ( s.hasNext() ) {
                String data = s.nextLine();
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog( null, "Verification Code Maybe Lost...", "Error", 0);
//            JavaApplication2.sendHTMLMail();
            JOptionPane.showMessageDialog( null, "done" );
            System.exit(0);
        }
        
        ja2.frame.setVisible( true );
    }

}