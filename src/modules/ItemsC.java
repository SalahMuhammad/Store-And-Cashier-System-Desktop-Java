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
      
    public ArrayList<ItemsO> getAll( String where ) {
        ArrayList<ItemsO> list = new ArrayList<>();
        ItemsO item = null;
        
        try {
            this.rs = this.select( 
                table, where, "*, " + sumSuppSupplies+ ", " + sumItemsOrders + "," + sumSales , null, "description asc", null, null )
            .executeQuery();

            while ( this.rs.next() ) {
                item = new classes.ItemsO( 
                    this.rs.getString( "itemId" ),
                    this.rs.getString( "description" ),
                    this.rs.getFloat("purchasing_price" ),
                    this.rs.getFloat( "price" ), 
                    this.rs.getFloat( "ws_price" ), 
                    this.rs.getFloat( "ws_ws_price" ),
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
    
//    public ArrayList<classes.ItemsO> getAllForSalesTable( String where ) {
//        ArrayList<classes.ItemsO> list = new ArrayList<>();
//        classes.ItemsO item = null;
//        
//        try {
////            this.rs = this.select( table + " i " + joinSuppSupplies + " " + joinItemsOrders + " " + joinSales, where, "i.itemId, i.description, i.ws_price, i.price, " + warehouseStock + ", " + centerStock, "i.itemId", "i.description asc", null, null )
////                .executeQuery();
//
//            while ( this.rs.next() ) {
//                item = new classes.ItemsO( 
//                    this.rs.getString( "itemId" ),
//                    this.rs.getString( "description" ),
//                    this.rs.getFloat("ws_price" ),
//                    this.rs.getFloat( "price" ),
//                    rs.getInt( "warehouse_stock"),
//                    rs.getInt( "center_stock" )
//                );
//
//                list.add( item );
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog( null, "getAll(); " + ex);
//        } finally {
//            this.closeConnection();
//        }
//        
//        return list;
//    }
    
//    public ArrayList<classes.ItemsO> getAllForSearchText( String description ) {
//        ArrayList<classes.ItemsO> list = new ArrayList<>();
//        classes.ItemsO item = null;
//        
//        try {
//            connect();
//            ps = con.prepareStatement( "SELECT itemId, description FROM items WHERE description LIKE ?");
//            ps.setString( 1, "%" + description + "%" );
//            
//            rs = ps.executeQuery();
//
//            while ( rs.next() ) {
//                item = new classes.ItemsO( 
//                    rs.getString( "itemId" ),
//                    rs.getString( "description" )
//                );
//                
//                list.add( item );
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog( null, "getAll(); " + ex);
//        } finally {
//            this.closeConnection();
//        }
//        
//        return list;
//    }
    
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
    
    public int insert( String item_id, String description, float purchasePrice, float ws_ws_price, float ws_price, float price  ) {
        String query = "INSERT INTO " + table + " VALUES ( ?, ?, ?, ?, ?, ? )";
        
        try {
            this.connect();
            this.ps = this.con.prepareStatement( query );
            
            this.ps.setString( 1, item_id );
            this.ps.setString( 2, description );
            this.ps.setFloat( 3, purchasePrice );
            this.ps.setFloat( 4, price );
            this.ps.setFloat( 5, ws_price );
            this.ps.setFloat( 6, ws_ws_price );
            
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
    
    public int update( String old_item_id, String item_id, String description, float purchasePrice, float price, float ws_price, float ws_ws_price ) {
        String query = "UPDATE " + table + " SET itemId=?, description=?, purchasing_price=?, price=?, ws_price=?, ws_ws_price=? where itemId=?";
        
        try {
            this.connect();
            
            this.ps = this.con.prepareStatement( query );
            
            this.ps.setString( 1, item_id );
            this.ps.setString( 2, description );
            this.ps.setFloat( 3, purchasePrice );
            this.ps.setFloat( 4, price );
            this.ps.setFloat( 5, ws_price );
            this.ps.setFloat( 6, ws_ws_price );
            this.ps.setString( 7, old_item_id );
            
            this.ps.execute();
            
            JOptionPane.showMessageDialog( null, "Item Updated Successfully..." );
            
            return 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog( null, ex );
        } finally {
            this.closeConnection();
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
