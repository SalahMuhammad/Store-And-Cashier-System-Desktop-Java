package Methods;

import classes.ItemsO;
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
        display( t, ft.getText() );
    }
    
    public String tableMousePressed( MouseEvent evt, JTable t, JPanel suppInvPanel, String filter ) {    
        if ( t.getSelectedColumn() == 7 && evt.getClickCount() == 2 ) {
            return "Barcode Column Has Been Clicked";
        }
        
        // popup dialog to insert new items
        if ( evt.getClickCount() == 2 ) {
            int s = t.getSelectedRow();
            
            new ItemsD( null, true ).dialogInitializer( 
                t.getValueAt( s, 7 ).toString(), 
                t.getValueAt( s, 6 ).toString(), 
                t.getValueAt( s, 5 ).toString(), 
                t.getValueAt( s, 4 ).toString(), 
                t.getValueAt( s, 3 ).toString(), 
                t.getValueAt( s, 2 ).toString() 
            );

            display( t, filter );
        }

        // update item that has been clicked twice
        
        rightClickEvent( evt, t, filter );
        
        return null;
    }
    
    public void rightClickEvent( MouseEvent evt, JTable t, String filter ) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            new ItemsD( null, true ).setVisible( true );

            display( t, filter );
        }
    }
    
//    public void rightClickAction( MouseEvent evt, JTable t, )
    
    public void display( JTable t, String itemIdOrDescriptionLike ) {
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        
        model.setRowCount(0);
        if ( ! itemIdOrDescriptionLike.trim().isEmpty() ) {
            ArrayList< classes.ItemsO > arr =  new ItemsC().getAll( itemIdOrDescriptionLike );
            Object[] row = new Object[8];
            
            for ( ItemsO obj : arr ) {
                row[0] = obj.centerStock;
                row[1] = obj.warehouseStock;
                row[2] = obj.getPrice();
                row[3] = obj.getWs_price();
                row[4] = obj.getWs_ws_price();
                row[5] = obj.getPurchasePrice();
                row[6] = obj.getDescription();
                row[7] = obj.getItem_id();

                model.addRow(row);
            }
        }
    }
    
    public void displayForSales( JTable t, String itemIdOrDescriptionLike ) {
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        
        model.setRowCount(0);
        if ( ! itemIdOrDescriptionLike.trim().isEmpty() ) {
            ArrayList< classes.ItemsO > arr =  new ItemsC().getAll( itemIdOrDescriptionLike );
            Object[] row = new Object[6];
            
            for ( ItemsO obj : arr ) {
                row[0] = obj.getItem_id();
                row[1] = obj.getDescription();
                row[2] = obj.getWs_price();
                row[3] = obj.getPrice();
                row[4] = obj.warehouseStock;
                row[5] = obj.centerStock;

                model.addRow(row);
            }
        }
    }
}
