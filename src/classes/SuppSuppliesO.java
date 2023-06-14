package classes;

import java.math.BigDecimal;

public class SuppSuppliesO {
    public int id;
    public String itemId;
    public String desc;
    public int count;
    public BigDecimal price;
    public int invoiceId;

    public SuppSuppliesO(int id, String desc, int count, BigDecimal price ) {
        this.id = id;
        this.desc = desc;
        this.count = count;
        this.price = price;
    }

    public SuppSuppliesO(String itemId, String desc, int count, BigDecimal price ) {
        this.itemId = itemId;
        this.desc = desc;
        this.count = count;
        this.price = price;
        this.invoiceId = invoiceId;
    }
}
