package Methods;

import crud.dialogs.SuppliersInvD;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modules.SuppliersInvC;

public class SuppliersInvPanelMethods {
    
    public void fiterTextKeyReleased( JTextField ft, JTable t ) {                
        if ( ft.getText().isEmpty() ) return;
        
        display( t, "sf.name like '%" + ft.getText() + "%'" );
    }
    
    public void tableMousePressed( MouseEvent evt, JTable t, JTable suppSupplies, JLabel imgLabel, JTextField ft ) {
        // popup dialog to insert new items
        byte[] img = null;
        imgLabel.setIcon( null );
        
        try {
            img = new SuppliersInvC().getImg( "id=" + t.getValueAt( t.getSelectedRow(), 0 ) );
            
            setJLabelImage( img, imgLabel );
            
            new SuppSuppliesPanelMethods().display( suppSupplies, "supp_invoice = " + t.getValueAt( t.getSelectedRow(), 0 ) );
        } catch ( java.lang.ArrayIndexOutOfBoundsException ex ) {}
          catch ( NullPointerException ex ) {}
        
        // update item that has been clicked twice
        if ( evt.getClickCount() == 2 ) {
            int s = t.getSelectedRow();
            
            new SuppliersInvD( null, true ).initialze(
                ( int ) t.getValueAt( s, 0),
                img,
                t.getValueAt( s, 4 ).toString(), 
                t.getValueAt( s, 2 ).toString(),
                t.getValueAt( s, 3 ).toString()
            );
            
            new SuppSuppliesPanelMethods().display( suppSupplies, "supp_invoice = " + null );
            
            if ( ft.getText().isEmpty() ) return;
            
            display( t, "sf.name like '%" + ft.getText() + "%'" );
            // empty supp_supplies table
            
        }

        // popup dialog to insert new items
        tableSingleClickEvent( evt, t, suppSupplies, ft );
    }
    
    public void tableSingleClickEvent( MouseEvent evt, JTable t, JTable suppSupplies, JTextField ft ) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            new SuppliersInvD( null, true ).setVisible( true );
            
            new SuppSuppliesPanelMethods().display( suppSupplies, "supp_invoice = " + null );
            
            if ( ft.getText().isEmpty() ) return;
            
            display( t, "sf.name like '%" + ft.getText() + "%'" );
        }
    }
    
    private void setJLabelImage( byte[] img, JLabel imgLabel ) {
        try {
            imgLabel.setIcon( null );
            
            ImageIcon ii = new ImageIcon ( 
                new ImageIcon( img ).getImage()
                .getScaledInstance( imgLabel.getWidth(), imgLabel.getHeight(), java.awt.Image.SCALE_SMOOTH ) 
            );
            imgLabel.setIcon( ii );
        } catch ( NullPointerException ex ) {}
    }
    
    public void display( JTable t, String where ) {
        ArrayList< classes.SuppliersInvO > arr = new SuppliersInvC().getAll( where );
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i = 0; i < arr.size(); i++) {
            row[0] = arr.get(i).id;
            row[1] = arr.get(i).date;
            row[2] = arr.get(i).invPrice;
            row[3] = arr.get(i).note;
            row[4] = arr.get(i).name;
            
            model.addRow(row);
        }
    }
}
