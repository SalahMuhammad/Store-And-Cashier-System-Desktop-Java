package classes;

import java.sql.Timestamp;

public class ItemsOrdersO extends ItemsO {
    public int id;
    public int qty;
    public Timestamp date;

    public ItemsOrdersO( int id, String description, int qty, Timestamp date ) {
        this.desc = description;
        this.id = id;
        this.qty = qty;
        this.date = date;
    }    
}
