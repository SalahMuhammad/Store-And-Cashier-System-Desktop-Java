package modules;

import classes.CustomersO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CustomersC extends MySQLAdapter {
    
    String table = "customers";
    
    public ArrayList<CustomersO> getAll( String nameLike ) {
        ArrayList<CustomersO> list = new ArrayList<>();
        
        try {
            ps = select(table, "name like ?", "*", null, "name asc", null, null );
            ps.setString( 1, "%" + nameLike + "%" );
            rs = ps.executeQuery();
            
            CustomersO c;
            while ( rs.next() ) {
                c = new CustomersO( 
                    rs.getInt( "id" ), 
                    rs.getString( "name" ), 
                    rs.getString( "phone" ) 
                );
                
                list.add( c );
            }
            
            return list;
        } catch ( SQLException ex ) {
            JOptionPane.showMessageDialog( null, ex );
        } finally {
            closeConnection();
        }
        
        return null;
    }
    
    public void insert( String name, String phone ) {
        int result = insert( "INSERT INTO customers VALUES ( null, ?, ? )", "هذا العميل موجود بالفعل...",name, phone );
        
        if ( result == 1 )
            JOptionPane.showMessageDialog( null, "تم اضافة العميل بنجاح..." );
    }
    
    public int update( String id, String name, String phone ) {
        int result = update( "UPDATE customers SET name = ?, phone = ? WHERE id = ?", "هذا العميل موجود بالفعل...", name, phone, id );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "تم تحديث بيانات العميل بنجاح..." );
            return result;
        }

        return -1;
    }
    
    public int delete( String id ) {
        int result = delete2( "DELETE FROM customers WHERE id = ?", id);
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "تم حذف العميل بنجاح..." );
            return result;
        }

        return -1;
    }
}
