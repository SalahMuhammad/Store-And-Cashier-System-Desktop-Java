package modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MySQLAdapter {
    
    protected Connection        con;
    protected PreparedStatement ps;
    protected ResultSet         rs;
    
    public void connect() throws SQLException {
        try {
            Class.forName( "com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/nabo?useUnicode=true&characterEncoding=utf8&sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false", "root", "" );
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog( null, "connect(); " + ex );
        }
    }
    
    public void closeConnection() {
        try {
            if ( this.rs != null ) this.rs.close();
            this.ps.close();
            this.con.close();
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
    
    public void delete( String table, String id ) throws SQLException {
        String query  = "DELETE FROM " + table + " WHERE " + id;
        
        this.connect();
        this.ps = con.prepareStatement( query );
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
    
}