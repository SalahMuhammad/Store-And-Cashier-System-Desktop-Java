package modules;

import classes.SalesOO;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SalesC extends MySQLAdapter {
    private String table = "sales";
    private String join = " JOIN items i ON i.itemId = sales.itemId"
                        + " JOIN sales_invoices si ON si.id = sales.invoice_id";
    
    public SalesOO getAll( String where ) {
        ArrayList<classes.SalesO> list = new ArrayList<>();
        Timestamp date = null;
        
        classes.SalesO salesO = null;
        try {
            this.rs = this.select( table + join, where, "sales.id, i.itemId, sales.price, sales.qty, i.description, si.date", null, "i.description asc", null, null ).executeQuery();

            if ( ! rs.next() ) return null;
            
            date = rs.getTimestamp( "date" );
            
            do {
                salesO = new classes.SalesO(
                    rs.getInt( "sales.id" ),
                    this.rs.getString( "i.itemId" ),
                    this.rs.getString( "i.description" ),
                    this.rs.getFloat( "sales.price" ),
                    this.rs.getInt( "qty" )
                );

                list.add( salesO );
            } while ( rs.next() );
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "getAll(); " + ex, "خطاء", 2);
        } finally {
            this.closeConnection();
        }
        
        return new SalesOO( list, date );
    }
    
    public int insert( String values ) {
        String query = "INSERT INTO " + table + " VALUES " + values;
        
        try {
            connect();
            ps = con.prepareStatement( query );
            
            ps.execute();
            
//            JOptionPane.showMessageDialog( null, "تم ادراج المعاملة بنجاح... " );
            
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex, "خطاء", 2 );
        }  finally {
            closeConnection();
        }

        return -1;
    }
    
    public int update( int id, String itemId, float price, int qty ) {
        String query = "UPDATE " + table + " SET itemId=?, price=?, qty=? where id=? "
                + "AND ? <= coalesce( ( SELECT SUM(qty) FROM items_orders WHERE itemId = ? ), 0 ) "
                + "- coalesce( ( SELECT SUM(qty) FROM sales WHERE itemId = ? ), 0 ) + qty";
        
        try {
            this.connect();
            
            this.ps = this.con.prepareStatement( query );
            
            this.ps.setString( 1, itemId );
            this.ps.setFloat(2, price );
            this.ps.setInt( 3, qty );
            this.ps.setInt( 4, id );
            ps.setInt( 5, qty );
            ps.setString( 6, itemId);
            ps.setString( 7, itemId);

            int result = this.ps.executeUpdate();
            
            if ( result == 1 ) {
                JOptionPane.showMessageDialog( null, "تم تحديث الصنف بنجاح... " );
            } else if ( result == 0 )  {
                JOptionPane.showMessageDialog( null, "المتاح اقل من المطلوب...", "خطاء", 2 );
            }  
                
            return result;
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
