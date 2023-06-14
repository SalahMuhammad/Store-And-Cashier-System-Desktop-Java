package modules;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SuppliersInvC extends MySQLAdapter {
    
    private String table = "supp_invoices";
    private String join = " si JOIN supp_info sf ON si.supp_id = sf.id "
            + "LEFT JOIN supp_supplies ss ON ss.supp_invoice = si.id";
    
    public ArrayList<classes.SuppliersInvO> getAll( String where ) {
        ArrayList<classes.SuppliersInvO> list = new ArrayList<>();
        
        classes.SuppliersInvO info = null;
        try {
            this.ps = this.select( table + join , "sf.name like ? OR si.date > NOW() - INTERVAL ? HOUR", "si.id, si.date, si.note, sf.name, SUM( ss.count * ss.price ) AS invoice_price", "si.id", "si.date desc", null, null );
            ps.setString( 1, "%" + where + "%" );
            ps.setString( 2, "");
            
            rs = ps.executeQuery();

            while ( this.rs.next() ) {
                info = new classes.SuppliersInvO( 
                    this.rs.getInt( "id" ),
                    this.rs.getBigDecimal( "invoice_price" ),
                    this.rs.getTimestamp( "date" ) ,
                    this.rs.getString( "note" ),
                    this.rs.getString( "name" )
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
    
    public ArrayList<classes.SuppliersInvO> getAll2( String where ) {
        ArrayList<classes.SuppliersInvO> list = new ArrayList<>();
        
        classes.SuppliersInvO info = null;
        try {
            this.ps = this.select( table + join , "ss.itemId = ?", "si.id, si.date, si.note, sf.name, SUM( ss.count * ss.price ) AS invoice_price", "si.id", "si.date desc", null, null );
//            ps.setString( 1, "%" + where + "%" );
            ps.setString( 1, where );
            
            rs = ps.executeQuery();

            while ( this.rs.next() ) {
                info = new classes.SuppliersInvO( 
                    this.rs.getInt( "id" ),
                    this.rs.getBigDecimal( "invoice_price" ),
                    this.rs.getTimestamp( "date" ) ,
                    this.rs.getString( "note" ),
                    this.rs.getString( "name" )
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
    
    public byte[] getImg( String where ) {
        try {
            this.rs = this.select( table , where, "inv", null, null, null, null ).executeQuery();

            if ( this.rs.next() ) {
                return this.rs.getBytes("inv" );
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "getAll(); " + ex);
        } finally {
            this.closeConnection();
        }
        
        return null;
    }

    public int insert( InputStream invoice, int supplierID, String note ) {
        String query = "INSERT INTO " + table + " ( inv, supp_id, note ) VALUES ( ?, ?, ? )";

        try {
            
            this.connect();
            this.ps = this.con.prepareStatement( query );

            this.ps.setBlob( 1, invoice );
            this.ps.setInt( 2, supplierID );
            this.ps.setString( 3, note );

            this.ps.execute();

            JOptionPane.showMessageDialog( null, "تم ادراج الفاتورة بنجاح..." );
            
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        } finally {
            closeConnection();
        }

        return -1;
    }
    
    public int update( int id, InputStream invoice, int supplierID, String note ) {
        String query = "UPDATE " + table + " SET inv=?, supp_id=?, note=? where id=?";
        
        try {
            this.connect();
            
            this.ps = this.con.prepareStatement( query );
            
            this.ps.setBlob( 1, invoice );
            this.ps.setInt( 2, supplierID );
            this.ps.setString( 3, note );
            this.ps.setInt( 4, id );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "تم تحديث الفاتورة بنجاح..." );
            
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
            
            JOptionPane.showMessageDialog( null, "تم حذف الفاتورة بنجاح..." );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        } finally {
            this.closeConnection();
        }
    }
}
