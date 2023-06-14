package Methods;

import classes.ItemOrderInvoicesO;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modules.ItemOrderInvoicesC;

public class ItemOrderInvoicesPanelMethods {
    
    public static void tableMouseClicked( MouseEvent evt, JTable t, String filter ) {
        if ( evt.getClickCount() == 2 ) {
            int srow = t.getSelectedRow();
            
            int result = JOptionPane.showConfirmDialog( null, "هل انت متاكد من انك تريد حذف هذة الفاتورة", "تاكيد", 0 );
            
            if ( result == JOptionPane.YES_OPTION ) {
                new ItemOrderInvoicesC().delete( t.getValueAt( srow, 1 ).toString() );
                
                display( t, filter );
            }
        }
        
        rightClickEvent( evt, t, filter );
    }
    
    public static void rightClickEvent( MouseEvent evt, JTable t, String filter ) {
        if ( evt.getButton() == MouseEvent.BUTTON3 ) {
            int result = JOptionPane.showConfirmDialog( null, "هل انت متاكد من انك تريد ادراج فاتورة جديدة...", "تاكيد", 0 );
            
            if ( result == JOptionPane.YES_OPTION ) {
                new ItemOrderInvoicesC().insert();
                
                display( t, filter );
            }
        }
    }
    
    public static void display( JTable t, String where ) {
        ArrayList<ItemOrderInvoicesO> list = null;
        
        DefaultTableModel model = ( DefaultTableModel ) t.getModel();
        model.setRowCount( 0 );
        
        if ( ! where.trim().isEmpty() ) {
            list = new ItemOrderInvoicesC().getAll( where );
            
            Object[] row = new Object[3];
            for ( ItemOrderInvoicesO ioio : list ) {
                row[0] = ioio.date;
                row[1] = ioio.id;

                model.addRow( row );
            }
        }
    }
    
}
