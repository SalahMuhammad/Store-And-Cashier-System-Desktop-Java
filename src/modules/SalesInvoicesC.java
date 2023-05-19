package modules;

import classes.SalesInvoicesO;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SalesInvoicesC extends MySQLAdapter {
    
    String table = "sales_invoices";
    
    public ArrayList<SalesInvoicesO> getInvoices( String lastNumDays ) {
        ArrayList<SalesInvoicesO> list = new ArrayList<>();
        
        try {
            connect();
            
            ps = con.prepareStatement( "SELECT si.id, si.date FROM " + table + " si LEFT JOIN sales s ON s.invoice_id = si.id LEFT JOIN items i ON i.itemId = s.itemId WHERE si.date > NOW() - INTERVAL ? HOUR OR i.description like ? ORDER BY si.date DESC" );
            ps.setString( 1, lastNumDays );
            ps.setString( 2, "%" + lastNumDays + "%" );
            rs = ps.executeQuery();
            
            while ( rs.next() ) {
                list.add( new SalesInvoicesO( 
                        rs.getInt( "id" ), 
                        rs.getTimestamp("date" ) 
                    ) 
                );
            }
            
            return list;
        } catch ( SQLException ex ) {
            JOptionPane.showMessageDialog( null, ex, "خطاء", 2 );
        } finally {
            closeConnection();
        }
        
        return null;
    }
    
    public int insert() {
        try {
            connect();
            
            ps = con.prepareStatement( "INSERT INTO sales_invoices () VALUES ()", Statement.RETURN_GENERATED_KEYS );
            ps.execute();
            
            rs = ps.getGeneratedKeys();
            while ( rs.next() ) {
                return ( int ) rs.getLong( 1 );
            }
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog( null, e, "خطاء", 2 );
        } finally {
            closeConnection();
        }

        return Integer.parseInt( null );
    }
    
     public void delete( int id ) {
        try {
            this.delete( table, "id=?");
            ps.setInt( 1, id );
            
            ps.execute();
            
            JOptionPane.showMessageDialog( null, "تم حذف الفاتورة بنجاح");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex, "خطاء", 2 );
        } finally {
            closeConnection();
        }
     }
}
