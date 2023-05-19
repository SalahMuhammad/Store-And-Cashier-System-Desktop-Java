package Methods;

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
    
    public void tableMousePressed( MouseEvent evt, JTable t, String value ) {
        // popup dialog to insert new items
        if ( evt.getClickCount() == 2 ) {
            int s = t.getSelectedRow();
            
            new ItemsOrdersD( null, true).init(
                    Integer.parseInt( t.getValueAt( s, 0 ).toString() ), 
                    t.getValueAt( s, 1 ).toString(), 
                    t.getValueAt( s, 2 ).toString()
                );

            display( t, value );
        }

        rightClickAction( evt, t, value );
    }
    
    public void rightClickAction( MouseEvent evt, JTable t, String value) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            new ItemsOrdersD( null, true ).setVisible( true );

            if ( value.isEmpty() ) return;
            
            display( t, value );
        }
    }
    
    public void display( JTable t, String lastNumDays ) {
        ArrayList< classes.ItemsOrdersO > arr = new ItemsOrdersC().getAll( lastNumDays );
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = arr.get(i).id;
            row[1] = arr.get(i).getDescription();
            row[2] = arr.get(i).qty;
            row[3] = arr.get(i).date;
            
            model.addRow(row);
        }
    }
}
