package modules;

import classes.SuppSuppliesO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SuppSuppliesC extends MySQLAdapter {
    
    private String table = "supp_supplies";
    private String join = " join items on supp_supplies.itemId = items.itemId";
    
    public ArrayList<classes.SuppSuppliesO> getAll( String where ) {
        ArrayList<classes.SuppSuppliesO> list = new ArrayList<>();
        
        classes.SuppSuppliesO suppSupplies = null;
        try {
            this.rs = this.select( table + join, where, "id, supp_supplies.price, description, count", null, "description asc", null, null ).executeQuery();
            
            while ( this.rs.next() ) {
                suppSupplies = new classes.SuppSuppliesO(
                    rs.getInt( "id" ),
                    rs.getString( "description" ),
                    rs.getInt( "count" ),
                    rs.getBigDecimal( "price" )
                );
                
                list.add( suppSupplies );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "getAll(); " + ex);
        } finally {
            this.closeConnection();
        }
        
        return list;
    }
    
    public SuppSuppliesO getSingleItem( int id ) {
        try {
            ps = select( table + join, "id = ?", "supp_supplies.itemId, count, description, supp_invoice, supp_supplies.price", null, null, "1", null );
            
            ps.setInt( 1, id );

            rs = ps.executeQuery();
            
            if ( rs.next() ) {
                return new SuppSuppliesO(
                    rs.getString( "supp_supplies.itemId" ), 
                    rs.getString( "description" ), 
                    rs.getInt( "count" ), 
                    rs.getBigDecimal( "supp_supplies.price" )
                );
            }
            
        } catch ( SQLException ex ) {
            JOptionPane.showMessageDialog( null, "getSingleItem: " + ex, "Error", 2 );
        }
        
        return null;
    }
    
    public int insert( String ...values ) {
        String query = "INSERT INTO " + table + " VALUES ( ?, ?, ?, ?, null )";
        
        int result = 0;
        result = insert( query, "Duplicate Entry Error.", values );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "تم ادراج المعاملة بنجاح..." );
            return result;
        }
        
        return result;
    }
    
    public int update( String ...values ) {
        String query = "UPDATE " + table + " ss SET itemId=?, count=?, price=? where id=? "
                + "AND COALESCE( ( SELECT SUM(count) FROM supp_supplies s WHERE s.itemId = ss.itemId ), 0 ) - "
                + "COALESCE( ( SELECT SUM(qty) FROM items_orders io WHERE io.itemId = ss.itemId ), 0 )  >= count - " + values[1];
        
        int result = update( query, "Duplicate Entry Error.", values );
        
        switch ( result ) {
            case 1:
                JOptionPane.showMessageDialog( null, "تم تحديث المعاملة بنجاح..." );
                break;
            case 0:
                JOptionPane.showMessageDialog( null, "لا يوجد ما يكفي من القطع", "خطاء", 2 );
                break;
            default:
                JOptionPane.showMessageDialog( null, "An Error Occurred... update()", "error", 0 );
                break;
        }
        
        return result;
    }
    
    public void delete( int id ) {
        try {
            this.delete( table, "id=?");
            this.ps.setInt( 1, id );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "تم حذف العدد بنجاح..." );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        } finally {
            this.closeConnection();
        }
    }
    
}
