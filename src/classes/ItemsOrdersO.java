package classes;

public class ItemsOrdersO extends ItemsO {
    public int id;
    public int qty;

    public ItemsOrdersO( int id, String description, int qty ) {
        this.desc = description;
        this.id = id;
        this.qty = qty;
    }    
}
