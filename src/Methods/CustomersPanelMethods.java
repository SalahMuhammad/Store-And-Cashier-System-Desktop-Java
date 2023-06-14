package Methods;

import classes.CustomersO;
import crud.dialogs.CustomersD;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modules.CustomersC;

public class CustomersPanelMethods {
    
    public static void tableAction( JPanel salesP, JPanel customersP, JTable t, JLabel customerId, JButton name ) {
        salesP.setVisible( true );
        customersP.setVisible( false );

        customerId.setText( t.getValueAt( t.getSelectedRow(), 0 ).toString() );
        name.setText( "اسم العميل: " + t.getValueAt( t.getSelectedRow(), 1).toString() );
    }
    
    public static void tableMouseClicked( MouseEvent evt, JTable t, String filter, JPanel sp, JPanel cp, JLabel customerId, JButton name ) { 
        // TODO add your handling code here:
        // popup dialog to update item that has been clicked twice
        if ( evt.getClickCount() == 2 && t.getSelectedColumn() != 0 ) {
            System.out.println();
            tableAction( sp, cp, t, customerId, name );
            return;
        }
        
        if ( evt.getClickCount() == 2 && t.getSelectedColumn() == 0 ) {
            int s = t.getSelectedRow();

            new CustomersD( null, true )
                .init(
                    t.getValueAt( s, 0 ).toString(), 
                    t.getValueAt( s, 1 ).toString(), 
                    t.getValueAt( s, 2 ).toString()
                );
            
            displayCustomers( t, filter );
            return;
        }
        
        customersRightClickEvent( evt ); 
    }
    
    public static void customersRightClickEvent( MouseEvent evt ) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            new CustomersD( null, true ).setVisible( true );
        }
    }
    
    public static void displayCustomers( JTable t, String nameLike ) {
        ArrayList<CustomersO> arr;
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        
        if ( nameLike.trim().isEmpty() )
            return;
        
        arr = new CustomersC().getAll( nameLike );
        Object[] row = new Object[3];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = arr.get(i).id;
            row[1] = arr.get(i).name;
            row[2] = arr.get(i).phones;

            model.addRow(row);
        }
    }
    
}
