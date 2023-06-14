package Methods;

import classes.ItemsOrdersO;
import crud.dialogs.ItemsOrdersD;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modules.ItemsOrdersC;

public class ItemsOrdersPanelMethods {
    
    public void fiterTextKeyReleased( String ft, JTable t ) {
        display( t, ft );
    }
    
    public void tableMousePressed( MouseEvent evt, JTable t, String value, String invoicId ) {
        // popup dialog to insert new items
        if ( evt.getClickCount() == 2 ) {
            int s = t.getSelectedRow();
            
            new ItemsOrdersD( null, true).init(
                    Integer.parseInt( t.getValueAt( s, 2 ).toString() ), 
                    t.getValueAt( s, 1 ).toString(), 
                    t.getValueAt( s, 0 ).toString()
                );

            display( t, value );
        }

        rightClickAction( evt, t, value, invoicId );
    }
    
    public void rightClickAction( MouseEvent evt, JTable t, String value, String invoicId ) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            ItemsOrdersD iod = new ItemsOrdersD( null, true );
            iod.invId = invoicId;
            
            iod.setVisible( true );
            
            display( t, value );
        }
    }
    
    public static void display( JTable t, String lastNumDays ) {
        ArrayList< classes.ItemsOrdersO > arr;
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        
        if ( ! lastNumDays.trim().isEmpty() ) {
            arr = new ItemsOrdersC().getAll( lastNumDays );
        
            Object[] row = new Object[4];
            for ( ItemsOrdersO obj : arr ) {
                row[0] = obj.qty;
                row[1] = obj.getDescription();
                row[2] = obj.id;

                model.addRow(row);
            }
        }
    }
}
