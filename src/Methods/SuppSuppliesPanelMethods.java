package Methods;

import classes.SuppSuppliesO;
import crud.dialogs.SuppSuppliesD;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modules.SuppSuppliesC;

public class SuppSuppliesPanelMethods {
    
//    public void fiterTextKeyReleased( JTextField ft, JTable t ) {                
//        display( t, "supp_info.name like '%" + ft.getText() + "%'" );
//    }
    
    public void tableMousePressed( MouseEvent evt, JTable t, JTable suppInvTable ) {        
        // update item that has been clicked twice
        if ( evt.getClickCount() == 2 ) {
            
            SuppSuppliesD o = new SuppSuppliesD( null, true );
            o.initialze( 
                ( int ) t.getValueAt( t.getSelectedRow(), 4 )
            );
            
            display( t, "supp_invoice = " + suppInvTable.getValueAt( suppInvTable.getSelectedRow(), 4 ) );
        }

        // popup dialog to insert new items
        rightClickEvent( evt, t, suppInvTable );
    }
    
    public void rightClickEvent( MouseEvent evt, JTable t, JTable suppInvTable ) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            SuppSuppliesD o = new SuppSuppliesD( null, true );
            o.suppInvId = ( int ) suppInvTable.getValueAt( suppInvTable.getSelectedRow(), 4 );
            
            o.setVisible( true );
            
            display( t, "supp_invoice = " + suppInvTable.getValueAt( suppInvTable.getSelectedRow(), 4 ) );
        }
    }
    
    public static void display( JTable t, String where ) {
        ArrayList< classes.SuppSuppliesO > arr;
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        
        if ( where.trim().isEmpty() )
            return;
        
        arr = new SuppSuppliesC().getAll( where );
        BigDecimal total = new BigDecimal( 0 );
        
        Object[] row = new Object[5];
        for ( SuppSuppliesO obj : arr ) {
            row[0] = obj.price.multiply( BigDecimal.valueOf( obj.count ) );
            row[1] = obj.price;
            row[2] = obj.count;
            row[3] = obj.desc;
            row[4] = obj.id;
            
            total = total.add( obj.price.multiply( BigDecimal.valueOf( obj.count ) ) );
            
            model.addRow(row);
        }
    }
}
