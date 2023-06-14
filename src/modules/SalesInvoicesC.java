package modules;

import classes.SalesInvoicesO;
import java.math.BigDecimal;
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
            
            ps = con.prepareStatement( "SELECT si.*, c.name, ( SELECT SUM( qty * unit_price ) FROM sales WHERE invoice_id = si.id ) AS total, payed FROM " + table + " si "
                    + "LEFT JOIN sales s ON s.invoice_id = si.id "
//                    + "LEFT JOIN items i ON i.itemId = s.itemId "
                    + "LEFT JOIN customers c ON c.id = si.customer_id "
                    + "WHERE si.date > NOW() - INTERVAL ? HOUR OR c.name like ? GROUP BY si.id ORDER BY si.date DESC" );
            ps.setString( 1, lastNumDays );
            ps.setString( 2, "%" + lastNumDays + "%" );
            rs = ps.executeQuery();
            
            while ( rs.next() ) {
                list.add( new SalesInvoicesO(
                        rs.getInt( "id" ), 
                        rs.getTimestamp("date" ),
                        rs.getString( "name" ),
                        rs.getBigDecimal( "payed" ).compareTo( new BigDecimal("1.00") ) == 0 ? rs.getBigDecimal( "total" ) : rs.getBigDecimal( "payed" ),
                        rs.getBigDecimal( "total" ),
                        rs.getString( "note" )
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
    
    public int insert2( String customerId, String payed, String note ) {
        try {
            connect();
            
            ps = con.prepareStatement( "INSERT INTO sales_invoices ( customer_id, payed, note ) VALUES ( ?, ?, ? )", Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, customerId );
            ps.setString( 2, payed );
            ps.setString( 3, note );
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

        return -1;
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
