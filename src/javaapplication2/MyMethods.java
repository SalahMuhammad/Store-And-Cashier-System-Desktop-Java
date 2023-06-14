package javaapplication2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class MyMethods {
    
    public static SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd  HH:mm" );
    
    public static void createKeybindings(JTable table) {
        table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        table.getActionMap().put("Enter", new AbstractAction() {  
            @Override
            public void actionPerformed(ActionEvent ae) {
                //do something on JTable enter pressed
            }
        });
    }
    
    public static void addEscapeListener(final JDialog dialog) {
        ActionListener escListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        };

        dialog.getRootPane().registerKeyboardAction(escListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

    }
    
    public static void onKeyDownTableRequestFocus( KeyEvent evt, JTable t ) {
        if ( evt.getKeyCode() == KeyEvent.VK_DOWN ) {
            if ( t.getRowCount() > 0 ) {
                t.requestFocus();
                t.setRowSelectionInterval( 0, 0 );
            }
        }
    }
    
    public static void jTableHeaderRendererTextToCenter( JTable table ) {
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment( JLabel.CENTER );
    }
    
    public static void jTableTextAlignment( JTable t, int horizontalAlignment ) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment( horizontalAlignment );
        
        for ( int i = 0; i < t.getColumnCount(); i++ ) {
            t.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
    
    static int i;
    /**
     * when user press enter on first field, then second field request focus
     * @param fields 
     */
    public static void jTFRequestFocus( JTextField ...fields ) {
        fields[0].addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fields[1].requestFocus();
            }
        });
        
//        for ( i = 0; i < fields.length;  ) {
//            if ( fields.length-1 == i ) 
//                break;
//            fields[i].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
////                    i++;
//                        fields[i+1].requestFocus();
//                    
//                }
//                
//            });
//            System.out.println( i );
//            i++;
//            System.out.println(i);
//        }
    }   
    
    public static void runReport( String JRXMLName, String jasperName, String PDFName, ArrayList obj ) {
//        String outputFile = ""; // output path

        String a = "C:\\Users\\Salah\\JaspersoftWorkspace\\MyReports\\" + JRXMLName + ".jrxml";
//        String b = "C:\\Users\\Salah\\JaspersoftWorkspace\\MyReports\\" + JRXMLName + ".jrxml";
//        String jrxmlFile = "./reportsJARXML/" + JRXMLName + ".jrxml";
        String jasperOutputPath = "C:\\Users\\Salah\\JaspersoftWorkspace\\MyReports\\" + jasperName + ".jasper";
        String outputPDFPath = "reports/" + PDFName + ".pdf";
        
        List<Object> listItems = new ArrayList<>();
        
        for ( Object e : obj ) {
            listItems.add( e );
        }

//        ExpensesO e1 = new ExpensesO( new BigDecimal( "1" ), "aaشش" );
//        ExpensesO e2 = new ExpensesO( new BigDecimal( "2" ), "ssسس" );
//        ExpensesO e3 = new ExpensesO( new BigDecimal( "3" ), "ddيي" );
//
//        listItems.add( e1 );
//        listItems.add( e2 );
//        listItems.add( e3 );
        
        // Convert List To JRBeanCollectionDataSource
        JRBeanCollectionDataSource beanDataSource = new JRBeanCollectionDataSource( listItems );
        
        HashMap hm = new HashMap();
        hm.put( "CollectionBeanParam", beanDataSource );
        
        try {
            InputStream input = new FileInputStream( new File( a ) );
            JasperDesign jDesign = JRXmlLoader.load( input );
            
            JasperReport jr = JasperCompileManager.compileReport( jDesign );
//            JasperCompileManager.compileReportToFile( a );
        
            JasperPrint jprint = JasperFillManager.fillReport( jr, hm, new JREmptyDataSource() );
            
//            JasperViewer.viewReport( jprint, true );
            JasperExportManager.exportReportToPdfFile( jprint, outputPDFPath );
            
            JOptionPane.showMessageDialog( null, "تم" );
        } catch (JRException ex) {
            JOptionPane.showMessageDialog( null, ex, "error", 0 );
        } catch (FileNotFoundException ex ) {
            JOptionPane.showMessageDialog( null, ex, "error", 0 );
        }
    }
}