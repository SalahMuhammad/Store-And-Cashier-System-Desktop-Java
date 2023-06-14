package classes;

import java.math.BigDecimal;

public class SalesO extends ItemsO {
    public int id;
    public BigDecimal price;
    public int qty;

    public SalesO( int id, String itemId, String desc, BigDecimal price, int qty) {
        this.id = id;
        this.itemId = itemId;
        this.desc = desc;
        this.price = price;
        this.qty = qty;
    }

    public String getItemId() {
        return itemId;
    }

    public String getDesc() {
        return desc;
    }
}
