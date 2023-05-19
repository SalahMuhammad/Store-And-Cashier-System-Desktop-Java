package Methods;

import crud.dialogs.SuppSuppliesD;
import java.awt.event.MouseEvent;
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
                ( int ) t.getValueAt( t.getSelectedRow(), 0 )
            );
            
            display( t, "supp_invoice = " + suppInvTable.getValueAt( suppInvTable.getSelectedRow(), 0 ) );
        }

        // popup dialog to insert new items
        rightClickEvent( evt, t, suppInvTable );
    }
    
    public void rightClickEvent( MouseEvent evt, JTable t, JTable suppInvTable ) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            SuppSuppliesD o = new SuppSuppliesD( null, true );
            o.suppInvId = ( int ) suppInvTable.getValueAt( suppInvTable.getSelectedRow(), 0 );
            
            o.setVisible( true );
            
            display( t, "supp_invoice = " + suppInvTable.getValueAt( suppInvTable.getSelectedRow(), 0 ) );
        }
    }
    
    public void display( JTable t, String where ) {
        ArrayList< classes.SuppSuppliesO > arr = new SuppSuppliesC().getAll( where );
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = arr.get(i).id;
            row[1] = arr.get(i).desc;
            row[2] = arr.get(i).count;
            
            model.addRow(row);
        }
    }
}
