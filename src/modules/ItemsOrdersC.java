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
            ps = this.select( table + join, "io.invoice_id = ?", "io.id, i.description, io.qty", null, "i.description asc", null, null );
//            ps.setString( 1, "%" + lastNumDays + "%" );
            ps.setString( 1, lastNumDays );
             
            this.rs = ps.executeQuery();
            
            while ( rs.next() ) {
                itemsOrders = new classes.ItemsOrdersO(
                    rs.getInt( "io.id" ),
                    this.rs.getString( "i.description" ),
                    this.rs.getInt( "io.qty" )
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
    
    public void insert( String ...values ) {
        int result = insert( 
            "INSERT INTO " + table + " ( itemId, qty, invoice_id ) VALUES ( ?, ?, ? )", 
            "duplicate entry error", 
            values 
        );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "تم ادراج المعاملة بنجاح..." );
        }
    }
    
    public int update( int id, String itemId, int qty ) {
        String query = "UPDATE " + table + " io SET itemId=?, qty=" + qty + " where id=" + id
            + " AND "
                + "CASE ? "
                    + "WHEN io.itemId THEN "
                        + "CASE " + qty + " >= qty "
                            + "WHEN 1 THEN "
                                + "ABS( " + qty + " - qty ) "
                                + "<= "
                                + "COALESCE( ( SELECT SUM( count ) FROM supp_supplies WHERE itemId = io.itemId ), 0 ) - "
                                + "COALESCE( ( SELECT SUM( qty ) FROM items_orders WHERE itemId = io.itemId ), 0 ) " // warehouse stock
                            + "WHEN 0 THEN "
                                + "ABS( " + qty + " - qty ) "
                                + "<= "
                                + "COALESCE( ( SELECT SUM( qty ) FROM items_orders WHERE itemId = io.itemId ), 0 ) - "
                                + "COALESCE( ( SELECT SUM( qty ) FROM sales WHERE itemId = io.itemId ), 0 ) " // center stock
                        + "END "
                    + "ELSE "
                        + "( qty <= " // if quantity greater than center stock return true
                            + "COALESCE( ( SELECT SUM( qty ) FROM items_orders ioo WHERE ioo.itemId = io.itemId ), 0 ) - "
                            + "COALESCE( ( SELECT SUM( qty ) FROM sales s WHERE s.itemId = io.itemId ), 0 )"
                        + " AND "
                            + qty + " <= " // quantity greater than warehouse stock
                            + "COALESCE( ( SELECT SUM( count ) FROM supp_supplies ss WHERE ss.itemId = ? ), 0 ) - "
                            + "COALESCE( ( SELECT SUM( qty ) FROM items_orders iooo WHERE iooo.itemId = ? ), 0 ) "
                        + " ) "
                + "END";   
        
        try {
            this.connect();
            
            this.ps = this.con.prepareStatement( query );
            
            ps.setString( 1, itemId );
            ps.setString( 2, itemId );
            ps.setString( 3, itemId );
            ps.setString( 4, itemId );
            
            int result = this.ps.executeUpdate();
            
            if ( result == 1 )
                JOptionPane.showMessageDialog( null, "تم تحديث المعاملة بنجاح..." );

            return result;
        } catch ( SQLIntegrityConstraintViolationException ex ) {
            JOptionPane.showMessageDialog( null, "هذا الصنف غير موجود", "خطاء", 2 );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex, "خطاء", 2 );
        } finally {
            this.closeConnection();
        }
        
        return -1;
    }
    
    public int delete( int id ) {
        try {
            this.delete( table , "id=? AND qty <= "
                    + "COALESCE( ( SELECT SUM(qty) FROM items_orders ioo WHERE ioo.itemId = items_orders.itemId ), 0 ) - "
                    + "COALESCE( ( SELECT SUM(qty) FROM sales s WHERE s.itemId = items_orders.itemId), 0 )");
            this.ps.setInt(1, id );
            
            int result = ps.executeUpdate();
            
            if ( result == 1 )
                JOptionPane.showMessageDialog( null, "تم حذف المعاملة ينجاح... " );
            
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex, "خطاء", 2 );
        } finally {
            this.closeConnection();
        }
        
        return -1;
    }
}
