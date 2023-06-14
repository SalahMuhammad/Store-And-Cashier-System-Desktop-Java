package modules;

import classes.ItemsO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ItemsC extends MySQLAdapter {

    private String table = "items";
    
    private String sumSuppSupplies  = "( SELECT SUM(count) FROM supp_supplies WHERE itemId = items.itemId ) AS a";
    private String sumItemsOrders   = "( SELECT SUM(qty) FROM items_orders WHERE itemId = items.itemId ) AS b";
    private String sumSales         = "( SELECT SUM(qty) FROM sales WHERE itemId = items.itemId ) AS c";
      
    public ArrayList<ItemsO> getAll( String itemIdOrDescriptionLike ) {
        ArrayList<ItemsO> list = new ArrayList<>();
        ItemsO item = null;
        
        try {
            ps = this.select( 
                table, "itemId LIKE ? OR description LIKE ?", "*, " + sumSuppSupplies+ ", " + sumItemsOrders + "," + sumSales , null, "description asc", null, null );
            ps.setString( 1, "%" + itemIdOrDescriptionLike + "%" );
            ps.setString( 2, "%" + itemIdOrDescriptionLike + "%" );
            rs = ps.executeQuery();

            while ( this.rs.next() ) {
                item = new classes.ItemsO( 
                    this.rs.getString( "itemId" ),
                    this.rs.getString( "description" ),
                    this.rs.getBigDecimal("purchasing_price" ),
                    this.rs.getBigDecimal( "price" ), 
                    this.rs.getBigDecimal( "ws_price" ), 
                    this.rs.getBigDecimal( "ws_ws_price" ),
                    rs.getInt( "a" ) - rs.getInt( "b" ),
                    rs.getInt( "b" ) - rs.getInt( "c" )
                );

                list.add( item );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "getAll(); " + ex);
        } finally {
            this.closeConnection();
        }
        
        return list;
    }
    
    public int getWarehouseStock( String itemId ) {
        try {
            ps = select( 
                    "supp_supplies" ,
                    "itemId = ?", 
                    "coalesce( SUM(count), 0 ) - coalesce( ( SELECT SUM(qty) FROM items_orders WHERE itemId = ? ), 0 )", 
                    null, 
                    null, 
                    "1", 
                    null 
            );
            ps.setString( 1, itemId );
            ps.setString( 2, itemId );
            
            rs = ps.executeQuery();
            if ( rs.next() )
                return rs.getInt( 1 );
                   
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog( null, e, "error", 2 );
        } finally {
            closeConnection();
        }
        
        return 325723;
    }
    
    public int getCenterStock( String itemId ) {
        try {
            ps = select( 
                    "items_orders",
                    "itemId = ?", 
                    "coalesce( SUM(qty), 0 ) - coalesce( ( SELECT SUM(qty) FROM sales WHERE itemId = ? ), 0 )", 
                    null, 
                    null, 
                    "1", 
                    null 
            );
            ps.setString( 1, itemId );
            ps.setString( 2, itemId );
            rs = ps.executeQuery();
            
            if ( rs.next() )
                return rs.getInt( 1 );
                   
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog( null, e, "error", 2 );
        } finally {
            closeConnection();
        }
        
        return -1;
    }
    
    public String getItemId( String desc ) {        
        try {            
            this.ps = this.select( table , "description=?", "itemId", null, null, null, null );
            this.ps.setString( 1, desc );
            this.rs = this.ps.executeQuery();
            
            if ( this.rs.next() ) {
                return rs.getString( "itemId" );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "getItem(); " + ex);
        } finally {
            this.closeConnection();
        }
        
        return null;
    }
    
    public ItemsO getItemPrice( String itemId ) {
        ItemsO item = null;
        
        try {
            ps = this.select( table, "itemId = ?", "price, ws_price" , null, "description asc", null, null );
            ps.setString( 1, itemId );
            rs = ps.executeQuery();

            while ( this.rs.next() ) {
                item = new classes.ItemsO(
                    rs.getBigDecimal( "price" ),
                    rs.getBigDecimal( "ws_price" )
                );

                return item;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, "getAll(); " + ex);
        } finally {
            this.closeConnection();
        }
        
        return null;
    }
    
    public int insert( String item_id, String description, String purchasePrice, String ws_ws_price, String ws_price, String price  ) {
        String query = "INSERT INTO " + table + " VALUES ( ?, ?, ?, ?, ?, ? )";
        
        try {
            this.connect();
            this.ps = this.con.prepareStatement( query );
            
            this.ps.setString( 1, item_id );
            this.ps.setString( 2, description );
            this.ps.setString( 3, purchasePrice );
            this.ps.setString( 4, price );
            this.ps.setString( 5, ws_price );
            this.ps.setString( 6, ws_ws_price );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "Item Inserted Successfully..." );
            
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        }  finally {
            closeConnection();
        }

        return -1;
    }
    
    public int update( String ...values ) {
        String query = "UPDATE " + table + " SET itemId=?, description=?, purchasing_price=?, price=?, ws_price=?, ws_ws_price=? where itemId=?";
        
        int result = update(
            query, 
            "هذا المعرف او الوصف موجود بالفعل...", 
            values
        );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "تم تحديث بيانات الصنف بنجاح..." );
            return result;
        }
        
        return -1;
    }
    
    public int updatePrices( String ...values ) {
        String query = "UPDATE " + table + " SET purchasing_price=?, price=?, ws_price=?, ws_ws_price=? where itemId=?";
        
        int result = update(
            query, 
            "هذا المعرف او الوصف موجود بالفعل...", 
            values
        );
        
        if ( result == 1 ) {
            JOptionPane.showMessageDialog( null, "تم تحديث بيانات الصنف بنجاح...\nسعر الشراء: " + values[0] + "\nجملة الجملة: " + values[3] + "\nجملة: " + values[2] + "\nقطاعي: " + values[1]);
            return result;
        }
        
        return -1;
    }
    
    public void delete( String item_id ) {
        try {
            this.delete( table, "itemId=?");
            this.ps.setString( 1, item_id );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "Item Deleted Successfully..." );
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        } finally {
            this.closeConnection();
        }
    }
}
