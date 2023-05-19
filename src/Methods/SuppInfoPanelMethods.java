package Methods;

import crud.dialogs.SuppInfoD;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modules.SuppliersInfoC;

public class SuppInfoPanelMethods {
    
    public void fiterTextKeyReleased( JTextField ft, JTable t ) {
        display( t, "name like '%" + ft.getText() + "%'" );
    }
    
    public void tableMousePressed( MouseEvent evt, JTable t, JTextField ft ) {
//        if ( evt.getButton() == MouseEvent.BUTTON1 ) {
//            displaySuppInv( "supp_id=" + suppInfoTable.getValueAt( suppInfoTable.getSelectedRow(), 0 ).toString() );
//        }

        // popup dialog to insert new items
        if ( evt.getClickCount() == 2 ) {
            int s = t.getSelectedRow();
            
            new SuppInfoD( null, true ).dialogInitializer( 
                    Integer.parseInt( t.getValueAt( s, 0 ).toString() ), 
                    t.getValueAt( s, 1 ).toString(), 
                    t.getValueAt( s, 2 ).toString()
            );

            display( t, "name like '%" + ft.getText() + "%'" );
//            displaySuppInv( "supp_id=null" );
        }

        // update item that has been clicked twice
        righClickAction( evt, t, ft );
    }
    
    public void righClickAction( MouseEvent evt, JTable t, JTextField ft) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            new SuppInfoD( null, true ).setVisible( true );

            if ( ft.getText().isEmpty() ) return;
            
            display( t, "name like '%" + ft.getText() + "%'" );
//            displaySuppInv( "supp_id=null" );
        }
    }
    
    public void display( JTable t, String where ) {
        ArrayList< classes.SuppliersInfoO > arr = new SuppliersInfoC().getAll( where );
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = arr.get(i).id;
            row[1] = arr.get(i).name;
            row[2] = arr.get(i).phone;
            
            model.addRow(row);
        }
    }
}
