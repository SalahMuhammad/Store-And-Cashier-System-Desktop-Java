package modules;

import classes.SuppSuppliesO;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SuppSuppliesC extends MySQLAdapter {
    
    private String table = "supp_supplies";
    private String join = " join items on supp_supplies.itemId = items.itemId";
    
    public ArrayList<classes.SuppSuppliesO> getAll( String where ) {
        ArrayList<classes.SuppSuppliesO> list = new ArrayList<>();
        
        classes.SuppSuppliesO suppSupplies = null;
        try {
            this.rs = this.select( table + join, where, "id, supp_supplies.itemId, description, count", null, "description asc", null, null ).executeQuery();
            
            while ( this.rs.next() ) {
                suppSupplies = new classes.SuppSuppliesO(
                    rs.getInt( "id" ),
                    rs.getString( "description" ),
                    rs.getInt( "count" )
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
            ps = select( table + join, "id = ?", "supp_supplies.itemId, count, description, supp_invoice", null, null, "1", null );
            
            ps.setInt( 1, id );

            rs = ps.executeQuery();
            
            if ( rs.next() ) {
                return new SuppSuppliesO( 
                    rs.getString( "supp_supplies.itemId" ), 
                    rs.getString( "description" ), 
                    rs.getInt( "count" ), 
                    rs.getInt( "supp_invoice" )
                );
            }
            
        } catch ( SQLException ex ) {
            JOptionPane.showMessageDialog( null, "getSingleItem: " + ex, "Error", 2 );
        }
        
        return null;
    }
    
    public int insert( String itemid, int count, int suppInvId ) {
        String query = "INSERT INTO " + table + " ( itemId, count, supp_invoice ) VALUES ( ?, ?, ? )";
        
        try {
            this.connect();
            this.ps = this.con.prepareStatement( query );
        
            this.ps.setString( 1, itemid );
            this.ps.setInt( 2, count );
            this.ps.setInt( 3, suppInvId );

            this.ps.execute();

            JOptionPane.showMessageDialog( null, "تم اضافة العدد بنجاح..." );
            
            return 1;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog( null, "هذا الصنف غير موجود...", "خطاء", 2 );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        }  finally {
            closeConnection();
        }

        return -1;
    }
    
    public int update( int id ,String itemId, int count) {
        String query = "UPDATE " + table + " SET itemId=?, count=? where id=?";
        
        try {
            this.connect();
            
            this.ps = this.con.prepareStatement( query );
            
            this.ps.setString( 1, itemId );
            this.ps.setInt( 2, count );
            this.ps.setInt( 3, id );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "تم تحديث العدد بنجاح..." );
            
            return 1;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog( null, "هذا الصنف غير موجود...", "خطاء", 2 );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        } finally {
            this.closeConnection();
        }
        
        return -1;
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
