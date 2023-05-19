package classes;

public class ItemsO {
    
    protected String itemId;
    protected String desc;
    private float purchasePrice;
    private float price;
    private float ws_price;
    private float ws_ws_price;
    public int warehouseStock;
    public int centerStock;

    public ItemsO() {}
    
    public ItemsO(String item_id, String description, float price, float ws_price) {
        this.itemId = item_id;
        this.desc = description;
        this.price = price;
        this.ws_price = ws_price;
    }

    public ItemsO(String item_id, String description, float price, float ws_price, int warehouseStock, int centerStock ) {
        this.itemId = item_id;
        this.desc = description;
        this.price = price;
        this.ws_price = ws_price;
        this.warehouseStock = warehouseStock;
        this.centerStock = centerStock;
    }
    
    public ItemsO(String item_id, String description) {
        this.itemId = item_id;
        this.desc = description;
    }

    public ItemsO(String item_id, String description, float purchasePrice, float price, float ws_price, float ws_ws_price, int warehouseStock, int centerStock ) {
        this.itemId = item_id;
        this.desc = description;
        this.purchasePrice = purchasePrice;
        this.price = price;
        this.ws_price = ws_price;
        this.ws_ws_price = ws_ws_price;
        this.warehouseStock = warehouseStock;
        this.centerStock = centerStock;
    }

    public ItemsO(String item_id, String description, float purchasePrice, float price, float ws_price, float ws_ws_price) {
        this.itemId = item_id;
        this.desc = description;
        this.purchasePrice = purchasePrice;
        this.price = price;
        this.ws_price = ws_price;
        this.ws_ws_price = ws_ws_price;
    }

    public String getItem_id() {
        return itemId;
    }

    public String getDescription() {
        return desc;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public float getPrice() {
        return price;
    }

    public float getWs_price() {
        return ws_price;
    }

    public float getWs_ws_price() {
        return ws_ws_price;
    }
}
