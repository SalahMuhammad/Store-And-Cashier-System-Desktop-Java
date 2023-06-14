package modules;

import classes.ItemOrderInvoicesO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemOrderInvoicesC extends MySQLAdapter {
    
    String tableName = "item_order_invoices";
    
    public ArrayList<ItemOrderInvoicesO> getAll( String whereClause ) {
        ArrayList<ItemOrderInvoicesO> list = new ArrayList<>();
        
        try {
            ps = select( tableName, "date > NOW() - INTERVAL ? HOUR", "*", null, "date desc", null, null );
            ps.setString( 1, whereClause );
            
            rs = ps.executeQuery();
            
            while ( rs.next() ) {
                list.add(
                    new ItemOrderInvoicesO( 
                        rs.getInt( "id" ), 
                        rs.getTimestamp( "date" ) )
                );
            }
            
            return list;
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog( null, e, "error", 0 );
        } finally {
            closeConnection();
        }
        
        return null;
    }
    
    public void insert() {
        int result = insert( "INSERT INTO " + tableName + " () VALUES ()", "Duplicate Entry Error" );
        
        if ( result == 1 )
            JOptionPane.showMessageDialog( null, "تم اضافة الفاتورة بنجاح بنجاح..." );
    }
    
    public int delete( String id ) {
        int result = delete2( "DELETE FROM " + tableName + " WHERE id = ?", id );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "تم حذف الفاتورة بنجاح..." );
            return result;
        }

        return -1;
    }
}
