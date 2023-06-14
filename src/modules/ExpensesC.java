package modules;

import classes.ExpensesO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ExpensesC extends MySQLAdapter {
    String tableName = "expenses";
    
    public ArrayList<ExpensesO> getAll( String lastNumHoursOrNote ) {
        ArrayList<ExpensesO> list = new ArrayList<>();
        
        try {
            ps = select( tableName + " exp LEFT JOIN supp_info si ON si.id = exp.supplier_id", "date > NOW() - INTERVAL ? HOUR OR note LIKE ? OR si.name LIKE ?", "*", null, "date desc", null, null );
            ps.setString( 1, lastNumHoursOrNote );
            ps.setString( 2, "%" + lastNumHoursOrNote + "%" );
            ps.setString( 3, "%" + lastNumHoursOrNote + "%" );
            
            rs = ps.executeQuery();
            
            while( rs.next() ) {
                list.add(
                    new ExpensesO(
                        rs.getInt( "exp.id" ),
                        rs.getString( "si.name" ),
                        rs.getBigDecimal( "pay" ),
                        rs.getString( "note" ), 
                        rs.getTimestamp( "date" )
                    )
                );
            }
            
            return list;
        } catch ( SQLException e) {
            JOptionPane.showMessageDialog( null, e, "error", 2 );
        } finally {
            closeConnection();
        }
        
        return null;
    }
    
    public void insert( String ...values ) {
        int result = insert( "INSERT INTO expenses ( pay, note, supplier_id ) VALUE ( ?, ?, ? )", "DEError", values );
        
        if ( result == 1 )
            JOptionPane.showMessageDialog( null, "تم ادراج المعاملة بنجاح..." );
    }
    
    public int update( String ...values ) {
        int result = update( "UPDATE expenses SET pay = ?, note = ?, supplier_id =  ? WHERE id = ?", "DEError", values );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "تم تحديث المعاملة بنجاح بنجاح..." );
            return result;
        }

        return -1;
    }
    
    public int delete( String id ) {
        int result = delete2( "DELETE FROM expenses WHERE id = ?", id);
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "تم حذف المعاملة بنجاح..." );
            return result;
        }

        return -1;
    }
}
