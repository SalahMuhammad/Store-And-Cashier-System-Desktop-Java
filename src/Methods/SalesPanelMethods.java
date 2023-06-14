package Methods;

import classes.SalesO;
import classes.SalesOO;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modules.SalesC;

public class SalesPanelMethods {
    
//    public static void tableDoubleClickAction( MouseEvent evt, JTable t, JTextField desc, JTextField price, JTextField qty, JLabel dateLabel, JLabel invoiceIdLabel ) {
//        int sRow = t.getSelectedRow();
//
//        if ( t.getValueAt( sRow, 0 ) == "" ) {
//            desc.setText    ( t.getValueAt( sRow, 2 ).toString() );
//            price.setText   ( t.getValueAt( sRow, 3 ).toString() );
//            qty.setText     ( t.getValueAt( sRow, 4 ).toString() );
//
//            ( ( DefaultTableModel ) t.getModel() ).removeRow( sRow );
//
//            desc.requestFocus();
//            return;
//        }
//
//        SalesD salesDialog = new SalesD( null, true );
//
//        salesDialog.initialize( 
//            Integer.parseInt( t.getValueAt( sRow, 0 ).toString() ), // sales transaction id
//            t.getValueAt( sRow, 2 ).toString(), // description
//            t.getValueAt( sRow, 3 ).toString(), // price
//            t.getValueAt( sRow, 4 ).toString() // qty
//        );
//
//        ( ( DefaultTableModel ) t.getModel() ).setRowCount( 0 );
//        dateLabel.setText( "" );
//
//        displaySalesTransactions( t, invoiceIdLabel.getText(), dateLabel );
//    }
    
    public static void tableDoubleClickOrEnterAction( JTable t, BigDecimal price, BigDecimal wsPrice, JTextField desc, JTextField qty, JTextField priceField, JRadioButton ...radios ) {
        int s = t.getSelectedRow();
        
        priceField.setEditable( false );
            
        BigDecimal a = new BigDecimal( t.getValueAt( s, 2 ).toString() );
        if ( a.equals( price ) ) {
            radios[0].setSelected( true );
        } else if ( a.equals( wsPrice ) ) {
            radios[1].setSelected( true );
        } else {
            radios[2].setSelected( true );
            priceField.setEditable( true );
        }

        desc.setText( t.getValueAt( s, 3 ).toString() );
        qty.setText( t.getValueAt( s, 1 ).toString() );
        priceField.setText( t.getValueAt( s, 2 ).toString() );

        ( ( DefaultTableModel ) t.getModel() ).removeRow( t.getSelectedRow() );

        desc.requestFocus();
    }
    
    public static void displaySalesTransactions( JTable t, String invoiceid, JLabel dateLabel ) {
        SalesOO obj = new SalesC().getAll( "si.id=" + invoiceid );
        
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        model.setRowCount( 0 );
        Object[] row = new Object[6];
        
        if ( obj == null ) return;
        
        ArrayList<SalesO> arr   = obj.listData;
        Timestamp date          = obj.date;
        
        for (int i = 0; i < arr.size(); i++) {
            row[0] = arr.get(i).price.multiply(BigDecimal.valueOf( arr.get(i).qty ) )/* * arr.get(i).qty*/;
            row[1] = arr.get(i).qty;
            row[2] = arr.get(i).price;
            row[3] = arr.get(i).getDesc();
            row[4] = arr.get(i).getItemId();
            row[5] = arr.get(i).id;

            model.addRow(row);
        }

        dateLabel.setText( date.toString() );  
    }
}
