package classes;

public class SuppSuppliesO {
    public int id;
    public String itemId;
    public String desc;
    public int count;
    public int invoiceId;

    public SuppSuppliesO(int id, String desc, int count) {
        this.id = id;
        this.itemId = itemId;
        this.desc = desc;
        this.count = count;
    }

    public SuppSuppliesO(String itemId, String desc, int count, int invoiceId) {
        this.itemId = itemId;
        this.desc = desc;
        this.count = count;
        this.invoiceId = invoiceId;
    }
}
