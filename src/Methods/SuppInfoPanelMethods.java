package Methods;

import classes.SuppliersInfoO;
import crud.dialogs.SuppInfoD;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javaapplication2.ExpensesTableD;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modules.SuppliersInfoC;

public class SuppInfoPanelMethods {
    
    public void fiterTextKeyReleased( JTextField ft, JTable t ) {
        display( t, ft.getText() );
    }
    
    public void tableMousePressed( MouseEvent evt, JTable t, JTextField ft ) {
        // popup dialog to insert new items
        if ( evt.getClickCount() == 2 ) {
            int s = t.getSelectedRow();
            
            if ( t.getSelectedColumn() != 3 ) {
                new ExpensesTableD( null, true ).init( 
                    t.getValueAt( s, 2 ).toString(), 
                    t.getValueAt( s, 2 ).toString() 
                );
                
                display( t, ft.getText() );
                
                return;
            }
            
            new SuppInfoD( null, true ).dialogInitializer( 
                    Integer.parseInt( t.getValueAt( s, 3 ).toString() ), 
                    t.getValueAt( s, 2 ).toString(), 
                    t.getValueAt( s, 1 ).toString()
            );

            display( t, ft.getText() );
        }

        // update item that has been clicked twice
        righClickAction( evt, t, ft );
    }
    
    public void righClickAction( MouseEvent evt, JTable t, JTextField ft) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            new SuppInfoD( null, true ).setVisible( true );

            display( t, ft.getText() );
        }
    }
    
    public void display( JTable t, String where ) {
        ArrayList< classes.SuppliersInfoO > arr;
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        
        if ( ! where.trim().isEmpty() ) {
            arr = new SuppliersInfoC().getAll( where );
        
            Object[] row = new Object[4];
            for ( SuppliersInfoO obj : arr ) {
                row[0] = obj.debt;
                row[1] = obj.phone;
                row[2] = obj.name;
                row[3] = obj.id;

                model.addRow(row);
            }
        }
        
        
    }
}
