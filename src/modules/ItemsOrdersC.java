package modules;

import classes.ItemsOrdersO;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemsOrdersC extends MySQLAdapter {
    private String table = "items_orders";
    private String join = " io JOIN items i ON i.itemId = io.itemId ";
    
    public ArrayList<ItemsOrdersO> getAll( String lastNumDays ) {
        ArrayList<ItemsOrdersO> list = new ArrayList<>();
        
        ItemsOrdersO itemsOrders = null;
        try {
             ps = this.select( table + join, "date > NOW() - INTERVAL ? DAY OR i.description like ?", "io.id, i.description, io.qty, io.date", null, "io.date desc", null, null );
             
             ps.setString( 1, lastNumDays );
             ps.setString( 2, "%" + lastNumDays + "%" );
             
            this.rs = ps.executeQuery();
            
            while ( rs.next() ) {
                itemsOrders = new classes.ItemsOrdersO(
                    rs.getInt( "io.id" ),
                    this.rs.getString( "i.description" ),
                    this.rs.getInt( "io.qty" ),
                    this.rs.getTimestamp( "io.date" )
                );

                list.add( itemsOrders );
            }
            
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "getAll(); " + ex, "خطاء", 2);
        } finally {
            this.closeConnection();
        }
        
        return null;
    }
    
    public int insert( String itemId, int qty ) {
        String query = "INSERT INTO " + table + " ( itemId, qty ) VALUES ( ?, ? )";
        
        try {
            connect();
            ps = con.prepareStatement( query );
            ps.setString( 1, itemId );
            ps.setInt( 2, qty );
            
            ps.execute();
 
            JOptionPane.showMessageDialog( null, "تم ادراج المعاملة بنجاح..." );
            
            return 1;
        } catch ( SQLIntegrityConstraintViolationException ex ) {
            JOptionPane.showMessageDialog( null, "هذا الصنف غير موجود", "خطاء", 2 );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex, "خطاء", 2 );
        } finally {
            closeConnection();
        }

        return -1;
    }
    
    public int update( int id, String itemId, int qty ) {
        String query = "UPDATE " + table + " SET itemId=?, qty=? where id=?"
                + " AND ? <= coalesce( ( SELECT SUM( count ) FROM supp_supplies WHERE itemId = ? ), 0 ) "
                + "- coalesce( ( SELECT SUM( qty ) FROM items_orders WHERE itemId = ? ), 0 ) + qty"
                + " AND ? coalesce( ( SELECT SUM( qty ) FROM items_orders WHERE itemId = ? ), 0 ) "
                + "- coalesce( ( SELECT SUM(qty) FROM sales WHERE itemId = ? ), 0 ) + qty";
        
        try {
            this.connect();
            
            this.ps = this.con.prepareStatement( query );
            
            this.ps.setString( 1, itemId );
            this.ps.setInt( 2, qty );
            this.ps.setInt( 3, id );
            ps.setInt( 4, qty );
            ps.setString( 5, itemId );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "تم تحديث المعاملة بنجاح..." );
            
            return 1;
        } catch ( SQLIntegrityConstraintViolationException ex ) {
            JOptionPane.showMessageDialog( null, "هذا الصنف غير موجود", "خطاء", 2 );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex, "خطاء", 2 );
        } finally {
            this.closeConnection();
        }
        
        return -1;
    }
    
    public void delete( int id ) {
        try {
            this.delete( table, "id=?");
            this.ps.setInt(1, id );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "تم حذف المعاملة ينجاح... " );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex, "خطاء", 2 );
        } finally {
            this.closeConnection();
        }
    }
}
