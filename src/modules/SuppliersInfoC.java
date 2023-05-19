package modules;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SuppliersInfoC extends MySQLAdapter {
 
    private String table = "supp_info";
//    private String join = " join supp_supplies on items.itemId = supp_supplies.itemId";
    
    public ArrayList<classes.SuppliersInfoO> getAll( String where ) {
        ArrayList<classes.SuppliersInfoO> list = new ArrayList<>();
        classes.SuppliersInfoO info = null;
        
        try {
            this.rs = this.select( table , where, "*", null, "name asc", null, null ).executeQuery();

            while ( this.rs.next() ) {
                info = new classes.SuppliersInfoO( 
                    this.rs.getInt( "id" ), 
                    this.rs.getString( "name" ), 
                    this.rs.getString( "phone" ) 
                );
                
                list.add( info );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "getAll(); " + ex);
        } finally {
            this.closeConnection();
        }
        
        return list;
    }
    
    public int getSupplierID( String name ) {
        try {
            this.connect();
            this.ps = this.con.prepareStatement( "SELECT id FROM " + table + " WHERE name = ?" );
            
            this.ps.setString( 1, name );
                    
            this.rs = this.ps.executeQuery();

            if ( this.rs.next() ) {
                return this.rs.getInt( "id" );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "getSupplierID(); " + ex);
        } finally {
            this.closeConnection();
        }
        
        return -1;
    }
    
    public int insert( String name, String phone ) {
        String query = "INSERT INTO " + table + " VALUES ( null, ?, ? )";
        
        try {
            this.connect();
            this.ps = this.con.prepareStatement( query );
            
            this.ps.setString( 1, name );
            this.ps.setString( 2, phone );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "تم ادراج المورد بنجاح..." );
            
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        }  finally {
            closeConnection();
        }

        return -1;
    }
    
    public int update( int id, String name, String phone ) {
        String query = "UPDATE " + table + " SET name=?, phone=? where id=?";
        
        try {
            this.connect();
            
            this.ps = this.con.prepareStatement( query );
            
            this.ps.setString( 1, name );
            this.ps.setString( 2, phone );
            this.ps.setInt( 3, id );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "تم تحديث المورد بنجاح..." );
            
            return 1;
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
            
            JOptionPane.showMessageDialog( null, "تم حذف المورد بنجاح" );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        } finally {
            this.closeConnection();
        }
    }
}
