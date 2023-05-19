package javaapplication2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableCellRenderer;

public class MyMethods {
    
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
            t.requestFocus();
            if ( t.getRowCount() > 0 )
                t.setRowSelectionInterval( 0, 0 );
        }
    }
    
    public static void jTableTextAlignment( JTable t, int horizontalAlignment ) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment( horizontalAlignment );
        for ( int i = 0; i < t.getColumnCount(); i++ ) {
            t.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }
    
}
