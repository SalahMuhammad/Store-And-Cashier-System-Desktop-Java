package Methods;

import crud.dialogs.ItemsD;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modules.ItemsC;

public class ItemsPanelMethods extends JPanel {
    
    public ItemsPanelMethods() {
    }
    
    public void fiterTextKeyReleased( JTextField ft, JTable t ) {
        String filter = ft.getText();
                
        display( t, "itemId like '%" + filter + "%' or description like '%" + filter + "%'" );
    }
    
    public void tableMousePressed( MouseEvent evt, JTable t, JTable suppInvTable, JTable suppSuppliesTable, JPanel suppInvPanel, JTextField filterField ) {    
        if ( t.getSelectedColumn() == 0 && evt.getClickCount() == 2 ) {
            // Set Row Count 0 In SuppSupplies Table
            DefaultTableModel dtm = ( DefaultTableModel ) suppSuppliesTable.getModel();
            dtm.setRowCount( 0 );
            suppSuppliesTable.setModel( dtm );
            
            new SuppliersInvPanelMethods().display( suppInvTable, "itemId = '" + t.getValueAt( t.getSelectedRow(), 0) + "'" );
            suppInvPanel.setVisible( true );
            return;
        }
        
        // popup dialog to insert new items
        if ( evt.getClickCount() == 2 ) {
            int s = t.getSelectedRow();
            
            new ItemsD( null, true ).dialogInitializer( 
                t.getValueAt( s, 0 ).toString(), 
                t.getValueAt( s, 1 ).toString(), 
                t.getValueAt( s, 2 ).toString(), 
                t.getValueAt( s, 3 ).toString(), 
                t.getValueAt( s, 4 ).toString(), 
                t.getValueAt( s, 5 ).toString() 
            );

            display( t, "itemId like '%" + filterField.getText() + "%' or description like '%" + filterField.getText() + "%'" );
        }

        // update item that has been clicked twice
        
        rightClickEvent(evt, t, filterField );
    }
    
    public void rightClickEvent( MouseEvent evt, JTable t, JTextField filterField ) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            ItemsD itemDialog = new ItemsD( null, true );
    //        itemDialog.suppinvtxt.setText( suppInvTable.getValueAt(suppInvTable.getSelectedRow(), 0).toString() );
            itemDialog.setVisible( true );

            if ( filterField.getText().isEmpty() ) return;
            
            display( t, "itemId like '%" + filterField.getText() + "%' or description like '%" + filterField.getText() + "%'" );
        }
    }
    
//    public void rightClickAction( MouseEvent evt, JTable t, )
    
    public void display( JTable t, String where ) {
        ArrayList< classes.ItemsO > arr =  new ItemsC().getAll( where );
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        Object[] row = new Object[8];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = arr.get(i).getItem_id();
            row[1] = arr.get(i).getDescription();
            row[2] = arr.get(i).getPurchasePrice();
            row[3] = arr.get(i).getWs_ws_price();
            row[4] = arr.get(i).getWs_price();
            row[5] = arr.get(i).getPrice();
            row[6] = arr.get(i).warehouseStock;
            row[7] = arr.get(i).centerStock;
            
            model.addRow(row);
        }
    }
    
    public void displayForSales( JTable t, String where ) {
        ArrayList< classes.ItemsO > arr =  new ItemsC().getAll( where );
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = arr.get(i).getItem_id();
            row[1] = arr.get(i).getDescription();
            row[2] = arr.get(i).getWs_price();
            row[3] = arr.get(i).getPrice();
            row[4] = arr.get(i).warehouseStock;
            row[5] = arr.get(i).centerStock;

            model.addRow(row);
        }
    }
}
