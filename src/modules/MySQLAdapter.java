package modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class MySQLAdapter {
    
    protected static Connection con;
    protected PreparedStatement ps;
    protected ResultSet         rs;
    
    public static void connect() throws SQLException {
        try {
            Class.forName( "com.mysql.jdbc.Driver");
            con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/nabo?useUnicode=true&characterEncoding=utf8&sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false", "root", "" );
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog( null, "connect(); " + ex );
        }
    }
    
    public void closeConnection() {
        try {
            if ( this.rs != null ) this.rs.close();
            this.ps.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "closeConnection(); " + ex);
        }
    }
    
    public PreparedStatement select( String table, String where, String fields, String groupBy, String order, String limit, String offset ) throws SQLException {
        String query = "SELECT " + fields + " FROM " + table
            + ( where != null ? " WHERE " + where : "" )
            + ( offset != null && limit != null ? " OFFSET " + offset : "" )
            + ( groupBy != null ? " GROUP BY " + groupBy : "" )
            + ( order != null ? " ORDER BY " + order : "" )
            + ( limit != null ? " LIMIT " + limit : "" );

        this.connect();

        return this.ps = this.con.prepareStatement( query );
    }
    
    protected int insert( String query, String duplicateEntryErrorMessage, String ...args ) {
        try {
            connect();
            
            ps = con.prepareStatement( query );

            for ( int i = 0; i < args.length; i++ ) {
                 ps.setString( i+1, args[i] );
            }
            
            return ps.executeUpdate();
        } catch ( SQLIntegrityConstraintViolationException ex ) {
            JOptionPane.showMessageDialog( null, duplicateEntryErrorMessage, "خطاء", 0 );
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog( null, "An Error Occurred, insert(): \n" + e, "error", 0 );
        } finally {
            closeConnection();
        }
        
        return -1;
    }
    
    protected int update( String query,String duplicateEntryErrorMessage, String ...args ) {
        try {
            connect();
            
            ps = con.prepareStatement( query );
            
            for ( int i = 0; i < args.length; i++ ) {
                 ps.setString( i+1, args[i] );
            }
            
            return ps.executeUpdate();
        } catch ( SQLIntegrityConstraintViolationException ex ) {
            JOptionPane.showMessageDialog( null, ex + "\n" + duplicateEntryErrorMessage, "خطاء", 0 );
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog( null, "An Error Occurred, insert(): \n" + e, "error", 0 );
        } finally {
            closeConnection();
        }
        
        return -1;
    }
    
    public void delete( String table, String id ) throws SQLException {
        String query  = "DELETE FROM " + table + " WHERE " + id;
        
        this.connect();
        this.ps = con.prepareStatement( query );
    }
    
    public int delete2( String query, String id ) {
        try {
            this.connect();
            this.ps = con.prepareStatement( query );
            ps.setString( 1, id );
            
            return ps.executeUpdate();
        } catch ( SQLIntegrityConstraintViolationException ex ) {
            JOptionPane.showMessageDialog( null, "يرجي حذف الماملات المرتبطة بهذة المعاملة اولا...", "خطاء", 0 );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        } finally {
            closeConnection();
        }
        
        return -1;
    }
    
    public int countRows() {
      int rowCount = 0;

      try {
          while ( this.rs.next() ) rowCount++;
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog( null, "countRows(); " + ex);
      }

      return rowCount;
    }
    
    public static void a( String jasperFileName, String pdfName ) {    
        try {
   //        String jrxmlFileName = "D:/SsWS/java/java projects -/JavaApplication2/reports/items.jrxml";
           String jrxmlFileName = "reportsJARXML\\items.jrxml";
           String jasperFilePath = "reportsJARXML\\" + jasperFileName + ".jasper";
           String pdfFilePath = "reports/" + pdfName + ".pdf";
   // this step only one time when new file create to get jasper file
           JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFilePath );
           
           HashMap hm = new HashMap();
   //        hm.put("ID", "123");
   //        hm.put("DATENAME", "April 2006");

           // get connection
           connect();

           // Generate jasper print
           JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport( jasperFilePath, hm, con );

           // Export pdf file
           JasperExportManager.exportReportToPdfFile( jprint, pdfFilePath );

           JOptionPane.showMessageDialog( null, "تم" );

        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, e, "error", 0 );
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog( null, ex, "error", 0 );
            }
        }
    }
}